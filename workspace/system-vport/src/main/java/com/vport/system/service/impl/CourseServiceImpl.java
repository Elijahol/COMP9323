package com.vport.system.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vport.system.bean.Student;
import com.vport.system.bean.TimeTable;
import com.vport.system.mapper.CourseMapper;
import com.vport.system.pojo.TrainingClassInfo;
import com.vport.system.pojo.TrainingPlan;
import com.vport.system.pojo.User;
import com.vport.system.service.CourseService;
import com.vport.system.utils.DateUtil;

@Service
public class CourseServiceImpl implements CourseService {
    
    @Autowired
    private CourseMapper courseMapper;
    

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


    @Override
    public List<TimeTable> getTimeTable(User user) {
        List<TrainingClassInfo> list = courseMapper.findClassByTrainer(user.getId());
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
                TimeTable timeTable = new TimeTable(trainingClassInfo.getClassId(),
                                                    futureDate, trainingClassInfo.getPlace(),hourTo);
                String visualTime = dateToString+ " " + hourTo+" "+DateUtil.getWeekDay(futureDate);
                timeTable.setVisualTime(visualTime);
                timeTables.add(timeTable);
            }
        }
        Collections.sort(timeTables, new MyComparator());
        return timeTables;
    }

}
class MyComparator implements Comparator<TimeTable>{

    @Override
    public int compare(TimeTable o1, TimeTable o2) {
        return o1.getTime().compareTo(o2.getTime());
    }
    
}
