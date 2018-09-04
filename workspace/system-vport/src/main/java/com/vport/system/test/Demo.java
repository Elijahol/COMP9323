/*package com.vport.system.test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.vport.system.bean.MakeTrainingPlan;
import com.vport.system.bean.TimeTable;
import com.vport.system.mapper.PlanMapper;
import com.vport.system.pojo.PhysicalDetail;
import com.vport.system.pojo.PlanType;
import com.vport.system.pojo.SkillDetail;
import com.vport.system.pojo.TrainingClassInfo;
import com.vport.system.pojo.TrainingPlan;
import com.vport.system.pojo.TrainingPlanInfo;
import com.vport.system.pojo.User;
import com.vport.system.service.CourseService;
import com.vport.system.service.PlanService;
import com.vport.system.service.UserService;
import com.vport.system.utils.MailUtils;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/application*.xml")
public class Demo {
    @Autowired
    private UserService userService;
    
    @Autowired
    private CourseService courseService;
    
    @Autowired
    private PlanService planService;
    
    @Autowired
    private PlanMapper planMapper;
    
    @Autowired
    private MailUtils mailUtils;
    
    @Test
    public void fun6(){
       List<PlanType> list = planMapper.selectTypeWithUnit();
        System.out.println(1);
    }
    @Test
    public void fun5(){
       TrainingPlan plan = new TrainingPlan();
       plan.setChiefTainer(1L);
       plan.setAssistantTrainer(5L);
       plan.setClassId(1L);
       plan.setCreated(new Date());
       plan.setTrainingTime(new Date());
       plan.setUpdated(new Date());
       MakeTrainingPlan newPlan = new MakeTrainingPlan();
       List<PhysicalDetail> physicalDetails = new ArrayList<PhysicalDetail>();
       PhysicalDetail physicalDetail1 = new PhysicalDetail();
       physicalDetail1.setPhysicalType(20L);
       physicalDetail1.setCount(15);
       physicalDetails.add(physicalDetail1);
       
       PhysicalDetail physicalDetail2 = new PhysicalDetail();
       physicalDetail2.setPhysicalType(35L);
       physicalDetail2.setCount(10);
       physicalDetails.add(physicalDetail2);
       
       List<SkillDetail> skillDetails = new ArrayList<SkillDetail>();
       SkillDetail skillDetail1 = new SkillDetail();
       skillDetail1.setIsLimitedTime("Limited Time");
       skillDetail1.setIsContinuous("Non-Continuous");
       skillDetail1.setIsMoved("Move");
       skillDetail1.setIsMultiple("Bandy");
       skillDetail1.setGroupNum(3);
       skillDetail1.setCountNumOfGroup(15);
       skillDetail1.setNumOfSuccess(5);
       skillDetail1.setRequiredTime(10);
       skillDetail1.setIsTarget("Non-Target");
       skillDetail1.setIsCombined("combined");
       skillDetail1.setTypeOfSikll(49L);
       
       skillDetails.add(skillDetail1);
       
       
       SkillDetail skillDetail2 = new SkillDetail();
       skillDetail2.setIsLimitedTime("Non-Limited-Time");
       skillDetail2.setIsContinuous("Non-Continuous");
       skillDetail2.setIsMoved("Fixed");
       skillDetail2.setIsMultiple("Multi-Ball");
       skillDetail2.setGroupNum(4);
       skillDetail2.setCountNumOfGroup(25);
       skillDetail2.setNumOfSuccess(20);
       skillDetail2.setIsTarget("Non-Target");
       skillDetail2.setTypeOfSikll(59L);
       
       skillDetails.add(skillDetail2);
       
       newPlan.setPhysicalDetails(physicalDetails);
       newPlan.setSkillDetails(skillDetails);
       newPlan.setPlan(plan);
       planService.makeNewPlan(newPlan);
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
    public void fun3() throws Exception{
        User user = new User();
        user.setId(1L);
        List<TimeTable> timeTable = courseService.getTimeTable(user);
        System.out.println(timeTable);
        
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