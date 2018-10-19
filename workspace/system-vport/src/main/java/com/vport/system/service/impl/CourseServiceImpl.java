package com.vport.system.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.aspectj.apache.bcel.classfile.Code;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.abel533.entity.Example;
import com.vport.system.bean.CourseTime;
import com.vport.system.bean.ResponseData;
import com.vport.system.bean.Student;
import com.vport.system.bean.TimeTable;
import com.vport.system.bean.TimeTableWithWeek;
import com.vport.system.mapper.CourseMapper;
import com.vport.system.mapper.PlanMapper;
import com.vport.system.mapper.UserMapper;
import com.vport.system.pojo.ClassInfoForStu;
import com.vport.system.pojo.TrainingClassToDisPlay;
import com.vport.system.pojo.person.User;
import com.vport.system.pojo.training.TrainingClass;
import com.vport.system.pojo.training.TrainingClassInfo;
import com.vport.system.pojo.training.TrainingPlan;
import com.vport.system.service.CourseService;
import com.vport.system.service.InfoService;
import com.vport.system.utils.DateUtil;
/**
 * This Class is an implementation of the interface CourseService.
 * The main function of this class is to complete the business logic 
 * relating to training courses and training class.
 * @author Siyu Wang
 *
 */
@Service
public class CourseServiceImpl implements CourseService {
    
    @Autowired
    private CourseMapper courseMapper;
    
    @Autowired
    private PlanMapper planMapper;
    /**
     * infoService injection
     * The purpose of using infoService is to send the notification
     * after the relevant operation
     */
    @Autowired
    private InfoService infoService;
    
    @Autowired
    private UserMapper userMapper;
    
    /**
     * Get the information of the classes which currently 
     * the instructor is responsible for according to the instructor id
     * 
     */
    @Override
    public List<TrainingClassInfo> getClassInfo(User trainer) {
        
        List<TrainingClassInfo> list = courseMapper.findClassByTrainer(trainer.getId());
        for (TrainingClassInfo trainingClassInfo : list) {
            if (trainingClassInfo.getIsOpen() != true) {
                Long classId = trainingClassInfo.getClassId();
                List<User> studentList = courseMapper.findStudentsByClass(classId);
                List<Student> students = new ArrayList<Student>();
                for (User user : studentList) {
                    Student student = new Student(user);
                    students.add(student);
                }
                trainingClassInfo.setStudents(students);
            }
           
        }
        
        
        return list;
    }
    /**
     * Get the class information containing the historical plans for the instructor
     *  1. get the basic class info according to the class id
     *  2. get the players information of the class
     *  3. get the historical plans information 
     */
    @Override
    public TrainingClassInfo getClassInfoByClassId(Long classId) {
        TrainingClassInfo classInfo = (TrainingClassInfo) courseMapper.findClassInfoByClassId(classId);
        List<User> stuList = courseMapper.findStudentsByClass(classId);
        List<Student> students = new ArrayList<Student>();
        for (User user : stuList) {
            Student student = new Student(user);
            students.add(student);
        }
        classInfo.setStudents(students);
        List<TrainingPlan> plansHistory = courseMapper.findPlanHistoryByClass(classId);
        classInfo.setPlansHistory(plansHistory);
        List<TrainingPlan> futurePlans = courseMapper.findFuturePlansByClass(classId);
        classInfo.setFuturePlans(futurePlans);
        return classInfo;
    }
    /**
     * Get the class information containing the historical plans for the player
     *  1. get the basic class info according to the class id
     *  2. get the players information of the class
     *  3. get the historical plans information 
     */
    @Override
    public ClassInfoForStu getClassInfoByClassIdForStu(Long classId) {
        ClassInfoForStu classInfoForStu = courseMapper.findClassInfoForStuByClassId(classId);
        String[] days = classInfoForStu.getPeriod().split("-");
        List<String> daysOfTraining = new ArrayList<>();
        for (String day : days) {
            daysOfTraining.add(DateUtil.dayOfWeek.get(Long.parseLong(day)));
        }
        classInfoForStu.setDaysOfTraining(daysOfTraining);
        List<User> stuList = courseMapper.findStudentsByClass(classId);
        List<Student> students = new ArrayList<Student>();
        for (User user : stuList) {
            Student student = new Student(user);
            students.add(student);
        }
        classInfoForStu.setStudents(students);
        List<TrainingPlan> plans = courseMapper.findPlanHistoryByClass(classId);
        classInfoForStu.setPlans(plans);
        return classInfoForStu;
    }

    /**
     * Get the timetable according to the user id
     * 
     */
    @Override
    public Map<String, Object> getTimeTable(Long id,Integer role) {
        List<TrainingClassInfo> list = null;
        if (role != 2) {
            list = courseMapper.findClassByTrainer(id);
        }else{
            list = courseMapper.findClassByPlayer(id);
        }
                
        /**
         * 1. Get the current week days:
         *      the key is the day of the current week;
         *      the value is the object TimeTableWithWeek which initially is null
         * 2. Calculate the time of each course and put it into the relevant week day
         */
        //1.Get the current week days
        Map<String, Object> weekDays = DateUtil.getWeekDays(0);
        //2.Calculate the time 
        for (TrainingClassInfo trainingClassInfo : list) {
            if(trainingClassInfo.getIsOpen() == false){
                String[] trainingDays = trainingClassInfo.getPeriod().split("-");
                String hourTo = trainingClassInfo.getHourTo();
                for (String day : trainingDays) {
                    int dayOfWeek = Integer.parseInt(day);
                    Date futureDate = DateUtil.getDateByWeekday(dayOfWeek);
                    String DayOfMonth = DateUtil.getDayOfMonth(futureDate);
                    String dateToString = DateUtil.dateToString(futureDate);
                    String dateToString2 = dateToString +" "+hourTo.split("-")[0];
                    futureDate = DateUtil.stringToDate(dateToString2);
                    TimeTable timeTable = new TimeTable(trainingClassInfo.getClassId(),trainingClassInfo.getClassName(),
                                                        futureDate, trainingClassInfo.getPlace(),hourTo);

                    
                    
                    ((TimeTableWithWeek) weekDays.get(DayOfMonth)).getTimeTables().add(timeTable);
                    Collections.sort(((TimeTableWithWeek) weekDays.get(DayOfMonth)).getTimeTables(),new MyComparator());
                
                }
            }
        }
        
        //Find the nearest class time
        Date currTime = new Date();
        long curr = currTime.getTime();
        Long min = Long.MAX_VALUE;
        TimeTable timeTableNear = null;
        for (String day : weekDays.keySet()) {
            List<TimeTable> courses = ((TimeTableWithWeek) weekDays.get(day)).getTimeTables();
            for (TimeTable timeTable : courses) {
                long time = timeTable.getTime().getTime();
                if (time < curr) continue;
                if (time - curr < min) {
                    timeTableNear = new TimeTable(timeTable.getClassId(), timeTable.getClassName(), timeTable.getTime(), timeTable.getPlace(), timeTable.getHourTo());
                    timeTableNear.setVisualTime(((TimeTableWithWeek) weekDays.get(day)).getVisualTime().split(" ")[0]+ " "+timeTableNear.getVisualTime());
                    min = time - curr;
                }
                   
            }
        }
        weekDays.put("00", timeTableNear);
        return weekDays;
    }

    /**
     * Get the training time according to the class id
     * 
     */
    @Override
    public List<CourseTime> getClassTimeByClassId(Long classId) {
        TrainingClass trainingClass = courseMapper.selectByPrimaryKey(classId);
        String[] days = trainingClass.getPeriod().split("-");
        String hourTo = trainingClass.getHourTo();
        List<CourseTime> timeList = new ArrayList<CourseTime>();
        List<Date> historyPlanTime = planMapper.findSchemaTrainingTimeByClassId(classId);
        for (String day : days) {
            int dayOfWeek = Integer.parseInt(day);
            Date futureDate = DateUtil.getDateByWeekday(dayOfWeek);
            String dateToString = DateUtil.dateToString(futureDate);
            String dateToString2 = dateToString +" "+hourTo.split("-")[0];
            futureDate = DateUtil.stringToDate(dateToString2);
            if (futureDate.compareTo(new Date()) > 0 && !historyPlanTime.contains(futureDate)) {
                CourseTime courseTime = new CourseTime(futureDate, dateToString + " " + hourTo+" " + DateUtil.getWeekDay(futureDate));
                timeList.add(courseTime);
            }
        }
        Collections.sort(timeList);
        return timeList;
    }
    
    /**
     * Add a new course
     */
    @Override
    public void addCourse(TrainingClass trainingClass, Long trainer) {
        trainingClass.setCreatetime(new Date());
        trainingClass.setIsOpen(true);
        trainingClass.setIsFinish(false);
        courseMapper.storeClass(trainingClass);
        courseMapper.linkClassAndTrainer(trainingClass.getClassId(),trainer,1);
        infoService.addNewCourseInfo(trainingClass.getClassId());
        
    }
    /**
     * Get the class detail which this class is free to join
     * 
     */
    @Override
    public TrainingClassToDisPlay getOpenCourseDetail(Long classId) {
        TrainingClass trainingClass = courseMapper.selectByPrimaryKey(classId);
        trainingClass.setTrainingDay(trainingClass.getPeriod());
        TrainingClassToDisPlay trainingClassToDisPlay = new TrainingClassToDisPlay();
        trainingClassToDisPlay.setPics(Arrays.asList(trainingClass.getPic().split(",")));
        User trainer = courseMapper.findChiefTrainerOfClass(trainingClass.getClassId());
        trainingClassToDisPlay.setTrainingClass(trainingClass);
        List<User> students = courseMapper.findStudentsByClass(classId);
        trainingClassToDisPlay.setStudents(students);
        trainingClassToDisPlay.setTrainer(trainer);
        trainingClassToDisPlay.setStartTime(trainingClass.getStarttime());
        trainingClassToDisPlay.setDeadLine(trainingClass.getDeadLine());
        return trainingClassToDisPlay;
    }
    /**
     * Get the list of the classes that are free to join
     */
    @Override
    public List<TrainingClassToDisPlay> getOpenCourse() {
        Example example = new Example(TrainingClass.class);
        example.createCriteria().andEqualTo("isOpen", true);
        List<TrainingClass> list = courseMapper.selectByExample(example);
        List<TrainingClassToDisPlay> res = new ArrayList<>();
        for (TrainingClass trainingClass : list) {
            TrainingClassToDisPlay trainingClassToDisPlay = new TrainingClassToDisPlay();
            trainingClassToDisPlay.setTrainingClass(trainingClass);
            trainingClassToDisPlay.setPics(Arrays.asList(trainingClass.getPic().split(",")));
            res.add(trainingClassToDisPlay);
        }
        return res;
    }
    /**
     * Get the classes for the player according the player
     */
    @Override
    public List<ClassInfoForStu> getClassInfoForStu(User player) {
        
        return courseMapper.findClassInfoByStu(player.getId());
    }
    
    /**
     * Complete the process of joining class
     * 1.check if the age of the player meets the requirements of the class
     * 2.Return the result according the checking
     *     The returning type "ResponseData" contains three fields:
     *          1. code: join successfully == true? 1:0
     *          2. msg: contain the message to info the user
     *          3. data: the response data
     * @throws ParseException 
     */
    @Override
    public ResponseData joinTheClass(User student, Long classId) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        Integer code = 1;
        String msg = "";
        TrainingClass trainingClass = courseMapper.selectByPrimaryKey(classId);
        String[] ageRange = trainingClass.getAgeRange().split("-");
        Integer stuAge = student.getAge();
        Integer start = Integer.parseInt(ageRange[0]);
        Integer end = Integer.parseInt(ageRange[1]);
        /**
         * 1.check the age of the user
         * 2.check if the class time conflict the current class times of the player  
         */
        if (stuAge >= start && stuAge <= end) {
            
            
            List<TrainingClassInfo> stuClassList = courseMapper.findClassByPlayer(student.getId());
            
            for (TrainingClassInfo stuClass : stuClassList) {
                List<String> stuTimes = Arrays.asList(stuClass.getPeriod().split("-"));
                List<String> tartTimes = Arrays.asList(trainingClass.getPeriod().split("-"));
                for (String tartTime : tartTimes) {
                    if (stuTimes.contains(tartTime)) {
                        String[] periods1 = stuClass.getHourTo().split("-");
                        String[] periods2 = trainingClass.getHourTo().split("-");
                        Date s = sdf.parse(periods1[0]);
                        Date e = sdf.parse(periods1[1]);
                        Date s1 = sdf.parse(periods2[0]);
                        Date e1 = sdf.parse(periods2[1]);
                        if (s1.compareTo(s) <= 0 && e1.compareTo(s) >= 0) {
                            code = 0;
                            msg = "The traing time of one of your current classes conflicts with this class";
                            break;
                        }else if (s1.compareTo(e) <= 0 && e1.compareTo(e) >= 0){
                            code = 0;
                            msg = "The traing time of one of your current classes conflicts with this class";
                            break;
                        }else if (s1.compareTo(s) >= 0 && e1.compareTo(e) <= 0 ) {
                            code = 0;
                            msg = "The traing time of one of your current classes conflicts with this class";
                            break;
                        }
                        
                    }
                }
            }
            if (code == 1) {
                courseMapper.linkClassAndStu(classId,student.getId());
                infoService.addNewJoinInfo(student.getId(),trainingClass.getClassId());
            }
        }else{
            code = 0;
            msg = "Your age does not meet the requirements of the class";
        }
        return new ResponseData(code, msg, null);
    }
    /**
     * Get the full address name of the training class
     * according to the class id and short name of the address
     * 根据班级id和place查找具体地址
     */
    @Override
    public String findFullAddress(String classId, String place) {
        Example example = new Example(TrainingClass.class);
        example.createCriteria().andEqualTo("classId", classId).andEqualTo("place", place);
        return courseMapper.selectByExample(example).get(0).getAddress();
    }
    
    
    

    

}
class MyComparator implements Comparator<TimeTable>{

    @Override
    public int compare(TimeTable o1, TimeTable o2) {
        return o1.getTime().compareTo(o2.getTime());
    }
    
}
