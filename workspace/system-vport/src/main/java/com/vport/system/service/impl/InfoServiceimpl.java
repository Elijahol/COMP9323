package com.vport.system.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.abel533.entity.Example;
import com.jolbox.bonecp.ConnectionTesterThread;
import com.vport.system.mapper.CourseMapper;
import com.vport.system.mapper.InfoMapper;
import com.vport.system.mapper.UserMapper;
import com.vport.system.pojo.Info;
import com.vport.system.pojo.person.User;
import com.vport.system.service.InfoService;
import com.vport.system.utils.DateUtil;
/**
 * InfoServiceImpl is an implementation of the interface InfoService.
 * it completes the business logic of notification function and interact with 
 * database through the relevant dynamic mappers like courseMapper, userMapper and infoMapper.
 * 
 * The methods that starts with "add", are responsible for add some new notifications
 * according to the relevant logic. To add a new notification must contain fields such as
 * "content", "url", "userId"
 * 
 * @author Liling Zhang
 */
@Service
public class InfoServiceimpl implements InfoService {
    
    @Autowired
    private CourseMapper courseMapper;
    
    @Autowired
    private UserMapper userMapper;
    
    @Autowired
    private InfoMapper infoMapper;
    /**
     * This method is to add a notification about 
     * new plan to all players in the system.
     * 
     */
    @Override
    public void addNewPlanInfoToStu(Long schemaId, Long classId) {
        List<User> students = courseMapper.findStudentsByClass(classId);
        String content = "New Training Plan";
        String url = "http://www.vport.com/rest/course/toEachPlan?id="+schemaId;
        Date time = new Date();
        for (User student : students) {
            Info info = new Info(student.getId(), content, url, time,0);
            infoMapper.insert(info);
        }

    }
    /**
     * This method is to add a notification about
     * reminding the player that his training data has been updated
     */
    @Override
    public void addNewEvalInfo(Long player) {
        String content = "Training Data Updated";
        String url = "http://www.vport.com/rest/common/showStu?id="+player;
        Date time = new Date();
        Info info = new Info(player, content, url, time, 0);
        infoMapper.insert(info);
        
    }
    /**
     * This method is to add a notification about
     * new course.
     */
    @Override
    public void addNewCourseInfo(Long classId) {
        String content = "New Course Open";
        String url = "http://www.vport.com/rest/course/showOpenCourseDetail?classId="+classId;
        Date time = new Date();
        List<User> list = userMapper.findUserByRole(2L);
        for (User user : list) {
            Info info = new Info(user.getId(), content, url, time, 0);
            infoMapper.insert(info);
        }
        
    }
    /**
     * The method is to add a notification about
     * there is a new player joined into a course
     */
    @Override
    public void addNewJoinInfo(Long id, Long classId) {
        String content = "Joined New Class";
        String url = "http://www.vport.com/rest/course/classInfoByClassIdForStu?classId="+classId;
        Date time = new Date();
        Info info = new Info(id, content, url, time, 0);
        infoMapper.insert(info);
        
        content = "New Student Joined";
        url = "http://www.vport.com/rest/course/classInfoByClassIdForStu?classId="+classId;
        User trainer = courseMapper.findChiefTrainerOfClass(classId);
        Info infoForT = new Info(trainer.getId(), content, url, time, 0);
        infoMapper.insert(infoForT);
        List<User> admins = userMapper.findUserByRole(3L);
        for (User admin : admins) {
            if (admin.getId() != trainer.getId()) {
                infoForT.setUserId(admin.getId());
                infoMapper.insert(infoForT);
            }
        }
        
    }
    /**
     * This method is to get all notifications of a user
     * including the unread notifications and read notifications
     */
    @Override
    public List<Info> getAllInfoByUser(Long userId) {
        Example example = new Example(Info.class);
        example.setOrderByClause("time desc");
        example.createCriteria().andEqualTo("userId", userId);
        List<Info> list = infoMapper.selectByExample(example);
        Date now = new Date();
        for (Info info : list) {
            Date start = info.getTime();
            info.setHisTime(DateUtil.timeDiffText(start, now));
        }
        return list;
    }
    /**
     * This method is to change the notification status
     * from unread to read.
     */
    @Override
    public void changeInfoStatus(Long id) {
        Info info = new Info();
        info.setId(id);
        info.setStatus(1);
        infoMapper.updateByPrimaryKeySelective(info);
        
    }
    
    /**
     * This method is to delete all notifications of a user.
     */
    @Override
    public void deleteInfoByUser(Long id) {
        Example example = new Example(Info.class);
        example.createCriteria().andEqualTo("userId", id);
        infoMapper.deleteByExample(example);
        
    }

    

    

    
    
    

}
