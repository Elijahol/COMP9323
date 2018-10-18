package com.vport.system.service;

import java.text.ParseException;
import java.util.List;
import java.util.Map;

import com.vport.system.bean.CourseTime;
import com.vport.system.bean.ResponseData;
import com.vport.system.bean.TimeTableWithWeek;
import com.vport.system.pojo.ClassInfoForStu;
import com.vport.system.pojo.TrainingClassToDisPlay;
import com.vport.system.pojo.person.User;
import com.vport.system.pojo.training.TrainingClass;
import com.vport.system.pojo.training.TrainingClassInfo;

public interface CourseService {
    List<TrainingClassInfo> getClassInfo(User trainer);
    Map<String, Object> getTimeTable(Long id,Integer role);
    List<CourseTime> getClassTimeByClassId(Long classId);
    TrainingClassInfo getClassInfoByClassId(Long classId);
    void addCourse(TrainingClass trainingClass, Long trainer);
    List<TrainingClassToDisPlay> getOpenCourse();
    TrainingClassToDisPlay getOpenCourseDetail(Long classId);
    List<ClassInfoForStu> getClassInfoForStu(User player);
    ClassInfoForStu getClassInfoByClassIdForStu(Long classId);
    ResponseData joinTheClass(User student, Long classId) throws ParseException ;
    String findFullAddress(String classId, String place);
}
