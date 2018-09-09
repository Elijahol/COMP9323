package com.vport.system.controller;



import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.vport.system.bean.PlanTree;
import com.vport.system.bean.ResponseData;
import com.vport.system.bean.TimeTable;
import com.vport.system.pojo.TrainingClassInfo;
import com.vport.system.pojo.TrainingPlanInfo;
import com.vport.system.pojo.User;
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
    public ResponseData getPlanTree(){
        PlanTree planTree = planService.getPlanTree();
        return new ResponseData(200, "yes", planTree.getData());
    }
    
    @RequestMapping(value="classInfo",method = RequestMethod.GET)
    @ResponseBody
    public ResponseData getClassInfo(){
        System.out.println("111111111111111111");
        User trainer = (User) session.getAttribute("existUser");
        List<TrainingClassInfo> classInfo = courseService.getClassInfo(trainer);
        return new ResponseData(0, "", classInfo);
    }
    @RequestMapping(value="timeTable",method = RequestMethod.GET)
    @ResponseBody
    public ResponseData getTimeTable(){
        System.out.println("222222222222222222222222");
        User trainer = (User) session.getAttribute("existUser");
        List<TimeTable> timeTable = courseService.getTimeTable(trainer);
        return new ResponseData(0, "", timeTable);
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
