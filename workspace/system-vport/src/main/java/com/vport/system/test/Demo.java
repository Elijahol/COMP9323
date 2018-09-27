/*package com.vport.system.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.vport.system.bean.CourseTime;
import com.vport.system.bean.EvaluateData;
import com.vport.system.bean.MakeTrainingPlan;
import com.vport.system.bean.TimeTable;
import com.vport.system.bean.TimeTableWithWeek;
import com.vport.system.mapper.CourseMapper;
import com.vport.system.mapper.PlanMapper;
import com.vport.system.pojo.eval.AvgPerformanceData;
import com.vport.system.pojo.eval.GeneralPerformanceDataOrderByTime;
import com.vport.system.pojo.eval.PerformanceAssess;
import com.vport.system.pojo.eval.PerformanceContent;
import com.vport.system.pojo.person.User;
import com.vport.system.pojo.training.PhysicalDetail;
import com.vport.system.pojo.training.PlanType;
import com.vport.system.pojo.training.SkillDetail;
import com.vport.system.pojo.training.TrainingClass;
import com.vport.system.pojo.training.TrainingClassInfo;
import com.vport.system.pojo.training.TrainingPlan;
import com.vport.system.pojo.training.TrainingPlanInfo;
import com.vport.system.service.CourseService;
import com.vport.system.service.EvaluateService;
import com.vport.system.service.InfoService;
import com.vport.system.service.PlanService;
import com.vport.system.service.UserService;
import com.vport.system.utils.DateUtil;
import com.vport.system.utils.MailUtils;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/application*.xml")
public class Demo {
    @Autowired
    private EvaluateService evaluateService;
    
    @Autowired
    private UserService userService;
    
    @Autowired
    private CourseService courseService;
    
    @Autowired
    private PlanService planService;
    
    @Autowired
    private PlanMapper planMapper;
    
    @Autowired
    private CourseMapper courseMapper;
    
    @Autowired
    private MailUtils mailUtils;
    
    @Autowired
    private InfoService infoService;
    
    @Test
    public void fun13(){
        infoService.deleteInfoByUser(4L);
    }
    
    
    @Test
    public void fun12(){
        Map<String, List<?>> data = new HashMap<>();
        evaluateService.getPerformanceScoreByTimeOrder(2L, data);
        System.out.println(1111);
    }
    
    @Test
    public void fun11(){
        List<GeneralPerformanceDataOrderByTime> list = evaluateService.getGeneralPerformanceWithTimeOrder(2L);
        for (GeneralPerformanceDataOrderByTime generalPerformanceDataOrderByTime : list) {
            System.out.println(generalPerformanceDataOrderByTime);
        }
    }
    
    
    
    @Test
    public void fun9(){
        PerformanceAssess performanceAssess = new PerformanceAssess();
        performanceAssess.setTrainer(1L);
        performanceAssess.setPlayer(2L);
        performanceAssess.setComment("nice");
        List<PerformanceContent> performanceContents = new ArrayList<>();
        
        Random rand = new Random();
        
        for(long i = 1; i<= 11;i++){
            PerformanceContent performanceContent1 = new PerformanceContent();
            performanceContent1.setContentId(i);
            performanceContent1.setCount((rand.nextInt(5)+1)*1.0);
            performanceContents.add(performanceContent1);
        }
//        performanceContents.add(performanceContent1);
//        performanceContents.add(performanceContent2);
        performanceAssess.setPerformanceContents(performanceContents);
        evaluateService.storePerfomanceData(performanceAssess);
    }
    
    
    
    @Test
    public void fun7(){
       EvaluateData evaluateData = evaluateService.getEvaluateType();
        System.out.println(evaluateData);
    }
    
    @Test
    public void fun6(){
       List<PlanType> list = planMapper.selectTypeWithUnit();
        System.out.println(1);
    }
    
    
    @Test
    public void fun4(){
       User trainer = new User();
       trainer.setId(1L);
        List<TrainingClassInfo> list = courseService.getClassInfo(trainer);
        for (TrainingClassInfo trainingClassInfo : list) {
           Date starttime = trainingClassInfo.getStarttime();
           System.out.println(starttime);
        }
        System.out.println(1);
    }
    
    
    
    @Test
    public void fun1(){
        User user = new User();
        user.setEmail("20432707@qq.com");
        user.setPassword("123");
        User u2 = userService.findByEmailandPassword(user);
        System.out.println(u2);
    }
    
    @Test
    public void fun2(){
      
        System.out.println("123");
           User user = new User();
           user.setName("李思宇");
           user.setPassword("123");
           user.setEmail("20432707@qq.com");
           user.setPhone("123");
           try {
           userService.register(user);
           } catch (Exception e1) {
//             e1.printStackTrace();
             System.out.println(e1.getMessage());
         }
           System.out.println("456");
    
       try {
           Thread.sleep(30 * 1000);
       } catch (InterruptedException e) {
           e.printStackTrace();
       }
    }
    
}
*/