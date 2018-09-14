package com.vport.system.controller;



import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.vport.system.bean.CourseTime;
import com.vport.system.bean.PlanTree;
import com.vport.system.bean.ResponseData;
import com.vport.system.bean.TimeTable;
import com.vport.system.bean.TimeTableWithWeek;
import com.vport.system.pojo.person.User;
import com.vport.system.pojo.training.TrainingClassInfo;
import com.vport.system.pojo.training.TrainingPlanInfo;
import com.vport.system.service.CourseService;
import com.vport.system.service.PlanService;

@Controller
@RequestMapping("course")
public class CourseController {
    
    private HttpServletRequest request;
    private HttpServletResponse response;
    private HttpSession session;
   
   
    @ModelAttribute
    public void setReqAndRes(HttpServletRequest request,HttpServletResponse response){
        this.request = request;
        this.response = response;
        this.session = request.getSession();
    }
    
    @Autowired
    private PlanService planService;
    
    @Autowired
    private CourseService courseService;
    
    @RequestMapping(value="planTree",method = RequestMethod.GET)
    @ResponseBody
    public ResponseData getPlanTree(Long classId){
        PlanTree planTree = planService.getPlanTree();
        List<CourseTime> list = courseService.getClassTimeByClassId(classId);
        List<Object> data = new ArrayList<>();
        data.add(planTree.getData());
        data.add(list);
        return new ResponseData(0, "yes", data);
    }
    
    @RequestMapping(value="classInfo",method = RequestMethod.GET)
    @ResponseBody
    public List<TrainingClassInfo> getClassInfo(){
        User trainer = (User) session.getAttribute("existUser");
        if (trainer == null) {
            trainer = new User();
            trainer.setId(1L);
        }
        List<TrainingClassInfo> classInfo = courseService.getClassInfo(trainer);
        return classInfo;
    }
    
    /**
     * 根据班级Id得到班级相关信息
     * @param classId
     * @return
     */
    @RequestMapping(value="classInfoByClassId",method = RequestMethod.GET)
    public String getClassInfoByClassId(Long classId,Model model){
        TrainingClassInfo classInfo = courseService.getClassInfoByClassId(classId);
        model.addAttribute("classInfo", classInfo);
        return "courseDetails";
    }
    
    @RequestMapping(value="timeTable",method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> getTimeTable(Long id){
        Map<String, Object> timeTable = courseService.getTimeTable(id);
        return timeTable;
    }
    @RequestMapping(value="eachPlan",method = RequestMethod.GET)
    @ResponseBody
    public ResponseData getEachPlan(Long id){
        TrainingPlanInfo trainingPlanInfo = planService.getTrainingPlanInfo(id);
        List<TrainingPlanInfo> list = new ArrayList<TrainingPlanInfo>();
        list.add(trainingPlanInfo);
        return new ResponseData(0, "", list);
    }
}
