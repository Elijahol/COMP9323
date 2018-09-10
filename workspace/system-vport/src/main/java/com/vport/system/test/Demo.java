/*package com.vport.system.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
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
    
    @Test
    public void fun11(){
        List<GeneralPerformanceDataOrderByTime> list = evaluateService.getGeneralPerformanceWithTimeOrder(2L);
        for (GeneralPerformanceDataOrderByTime generalPerformanceDataOrderByTime : list) {
            System.out.println(generalPerformanceDataOrderByTime);
        }
    }
    
    @Test
    public void fun10(){
        AvgPerformanceData avgPerformanceDataByPlayer = evaluateService.getAvgPerformanceDataByPlayer(2L);
        System.out.println(avgPerformanceDataByPlayer);
    }
    
    @Test
    public void fun9(){
        PerformanceAssess performanceAssess = new PerformanceAssess();
        performanceAssess.setChiefTrainer(1L);
        performanceAssess.setAssistant(5L);
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
    public void fun8(){
        TrainingClass trainingClass = courseMapper.selectByPrimaryKey(1L);
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
        System.out.println(timeList);
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
    public void fun5(){
       TrainingPlan plan = new TrainingPlan();
       plan.setChiefTrainer(1L);
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