package com.vport.system.service.impl;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.abel533.entity.Example;
import com.mysql.fabric.xmlrpc.base.Array;
import com.vport.system.bean.CourseTime;
import com.vport.system.bean.ResponseData;
import com.vport.system.bean.Student;
import com.vport.system.bean.TimeTable;
import com.vport.system.bean.TimeTableWithWeek;
import com.vport.system.mapper.CourseMapper;
import com.vport.system.mapper.PlanMapper;
import com.vport.system.pojo.ClassInfoForStu;
import com.vport.system.pojo.TrainingClassToDisPlay;
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
    
    @Autowired
    private PlanMapper planMapper;
    /**
     * 根据教练员提取与之有关的课程信息
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
               /* List<TrainingPlan> plans = courseMapper.findPlanByClass(classId);
                trainingClassInfo.setPlans(plans);*/
            }
           
        }
        
        
        return list;
    }
    /**
     * 根据班级id查询班级信息包括历史训练计划
     */
    @Override
    public TrainingClassInfo getClassInfoByClassId(Long classId) {
        /**
         * 1.根据id查询班级信息
         * 2.查询学生信息
         * 3.查询历史训练计划
         */
        TrainingClassInfo classInfo = (TrainingClassInfo) courseMapper.findClassInfoByClassId(classId);
        List<User> stuList = courseMapper.findStudentsByClass(classId);
        List<Student> students = new ArrayList<Student>();
        for (User user : stuList) {
            Student student = new Student(user);
            students.add(student);
        }
        classInfo.setStudents(students);
        List<TrainingPlan> plans = courseMapper.findPlanByClass(classId);
        classInfo.setPlans(plans);
        return classInfo;
    }
    /**
     * 根据班级id查询班级信息包括历史训练计划（2）
     */
    @Override
    public ClassInfoForStu getClassInfoByClassIdForStu(Long classId) {
        /**
         * 1.根据id查询班级信息包含教练
         * 2.查询学生信息
         * 3.查询历史训练计划
         */
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
        List<TrainingPlan> plans = courseMapper.findPlanByClass(classId);
        classInfoForStu.setPlans(plans);
        return classInfoForStu;
    }

    /**
     * 根据教练员获取课程时间信息
     */
    @Override
    public Map<String, Object> getTimeTable(Long id,Integer role) {
        List<TrainingClassInfo> list = null;
        if (role == 1) {
            list = courseMapper.findClassByTrainer(id);
        }else{
            list = courseMapper.findClassByPlayer(id);
        }
                
        /**
         * 1.得到当前周的日期map
         *      map里面的是<19，对象> 对象里面有对应的全时间，及List《timetable》 这一步是为空
         * 2.计算每个课程在本周内的时间，得到对应的19，放到map里相应的位置里
         */
        //1.得到当前周的日期map
        Map<String, Object> weekDays = DateUtil.getWeekDays(0);
        
        for (TrainingClassInfo trainingClassInfo : list) {
            if(trainingClassInfo.getIsOpen() == false){
                String[] trainingDays = trainingClassInfo.getPeriod().split("-");
                String hourTo = trainingClassInfo.getHourTo();
                for (String day : trainingDays) {
                    int dayOfWeek = Integer.parseInt(day);
                    //根据星期几获得当前周的时间
                    Date futureDate = DateUtil.getDateByWeekday(dayOfWeek);
                    //根据当前周的时间获得当月是哪天
                    String DayOfMonth = DateUtil.getDayOfMonth(futureDate);
                    
                    String dateToString = DateUtil.dateToString(futureDate);
                    String dateToString2 = dateToString +" "+hourTo.split("-")[0];
                    futureDate = DateUtil.stringToDate(dateToString2);
                    TimeTable timeTable = new TimeTable(trainingClassInfo.getClassId(),trainingClassInfo.getClassName(),
                                                        futureDate, trainingClassInfo.getPlace(),hourTo);
    //                String visualTime = dateToString+ " " + hourTo+" "+DateUtil.getWeekDay(futureDate);
    //                timeTable.setVisualTime(visualTime);
                    
                    //加入map
                    ((TimeTableWithWeek) weekDays.get(DayOfMonth)).getTimeTables().add(timeTable);
                    Collections.sort(((TimeTableWithWeek) weekDays.get(DayOfMonth)).getTimeTables(),new MyComparator());
                
                }
            }
        }
       
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
     * 根据班级id获取训练时间
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
     * 前加课程信息
     */
    @Override
    public void addCourse(TrainingClass trainingClass, Long trainer) {
        trainingClass.setCreatetime(new Date());
        trainingClass.setIsOpen(true);
        trainingClass.setIsFinish(false);
        courseMapper.storeClass(trainingClass);
        courseMapper.linkClassAndTrainer(trainingClass.getClassId(),trainer,1);
        
    }
    /**
     * 获取宣传的课程信息详情
     */
    @Override
    public TrainingClassToDisPlay getOpenCourseDetail(Long classId) {
        TrainingClass trainingClass = courseMapper.selectByPrimaryKey(classId);
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
     * 获取宣传课程列表
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
     * 得到关于这个学生主页面的课程信息
     */
    @Override
    public List<ClassInfoForStu> getClassInfoForStu(User player) {
        
        return courseMapper.findClassInfoByStu(player.getId());
    }
    

    

}
class MyComparator implements Comparator<TimeTable>{

    @Override
    public int compare(TimeTable o1, TimeTable o2) {
        return o1.getTime().compareTo(o2.getTime());
    }
    
}
