package com.vport.system.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vport.system.bean.CourseTime;
import com.vport.system.bean.ResponseData;
import com.vport.system.bean.Student;
import com.vport.system.bean.TimeTable;
import com.vport.system.mapper.CourseMapper;
import com.vport.system.pojo.person.User;
import com.vport.system.pojo.training.TrainingClass;
import com.vport.system.pojo.training.TrainingClassInfo;
import com.vport.system.pojo.training.TrainingPlan;
import com.vport.system.service.CourseService;
import com.vport.system.utils.DateUtil;

@Service
public class CourseServiceImpl implements CourseService {
    
    @Autowired
    private CourseMapper courseMapper;
    
    
    /**
     * 根据教练员提取与之有关的课程信息
     */
    @Override
    public List<TrainingClassInfo> getClassInfo(User trainer) {
        
        List<TrainingClassInfo> list = courseMapper.findClassByTrainer(trainer.getId());
        for (TrainingClassInfo trainingClassInfo : list) {
            Long classId = trainingClassInfo.getClassId();
            List<User> studentList = courseMapper.findStudentsByClass(classId);
            List<Student> students = new ArrayList<Student>();
            for (User user : studentList) {
                Student student = new Student(user);
                students.add(student);
            }
            trainingClassInfo.setStudents(students);
            List<TrainingPlan> plans = courseMapper.findPlanByClass(classId);
            trainingClassInfo.setPlans(plans);
        }
        
        
        return list;
    }

    /**
     * 根据教练员获取课程时间信息
     */
    @Override
    public ResponseData getTimeTable(Long id) {
        ResponseData responseData = new ResponseData();
        List<Object> data = new ArrayList<>();
        List<TrainingClassInfo> list = courseMapper.findClassByTrainer(id);
        List<TimeTable> timeTables = new ArrayList<TimeTable>();
        for (TrainingClassInfo trainingClassInfo : list) {
            String[] trainingDays = trainingClassInfo.getPeriod().split("-");
            String hourTo = trainingClassInfo.getHourTo();
            for (String day : trainingDays) {
                int dayOfWeek = Integer.parseInt(day);
                Date futureDate = DateUtil.getFutureDate(dayOfWeek);
                String dateToString = DateUtil.dateToString(futureDate);
                String dateToString2 = dateToString +" "+hourTo.split("-")[0];
                futureDate = DateUtil.stringToDate(dateToString2);
                TimeTable timeTable = new TimeTable(trainingClassInfo.getClassId(),trainingClassInfo.getClassName(),
                                                    futureDate, trainingClassInfo.getPlace(),hourTo);
                String visualTime = dateToString+ " " + hourTo+" "+DateUtil.getWeekDay(futureDate);
                timeTable.setVisualTime(visualTime);
                timeTables.add(timeTable);
            }
        }
        Collections.sort(timeTables, new MyComparator());
        Date currTime = new Date();
        //要改
        for (TimeTable timeTable : timeTables) {
            if (timeTable.getTime().compareTo(currTime) == 1) {
                String visualTime = timeTable.getVisualTime();
                String[] fields = visualTime.split(" ");
                String start = fields[1].split("-")[0];
                timeTable.setVisualTime(start);
                data.add(timeTable);
                break;
            }
        }
        data.add(timeTables);
        responseData.setData(data);
        return responseData;
    }

    /**
     * 根据班级id获取训练时间
     */
    @Override
    public List<CourseTime> getClassTimeByClassId(Long classId) {
        TrainingClass trainingClass = courseMapper.selectByPrimaryKey(classId);
        String[] days = trainingClass.getPeriod().split("-");
        String hourTo = trainingClass.getHourTo();
        List<CourseTime> timeList = new ArrayList<CourseTime>();
        for (String day : days) {
            int dayOfWeek = Integer.parseInt(day);
            Date futureDate = DateUtil.getFutureDate(dayOfWeek);
            String dateToString = DateUtil.dateToString(futureDate);
            String dateToString2 = dateToString +" "+hourTo.split("-")[0];
            futureDate = DateUtil.stringToDate(dateToString2);
            if (futureDate.compareTo(new Date()) > 0) {
                CourseTime courseTime = new CourseTime(futureDate, dateToString + " " + hourTo+" " + DateUtil.getWeekDay(futureDate));
                timeList.add(courseTime);
            }
        }
        Collections.sort(timeList);
        return timeList;
    }

}
class MyComparator implements Comparator<TimeTable>{

    @Override
    public int compare(TimeTable o1, TimeTable o2) {
        return o1.getTime().compareTo(o2.getTime());
    }
    
}
