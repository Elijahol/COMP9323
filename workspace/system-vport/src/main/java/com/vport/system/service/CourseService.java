package com.vport.system.service;

import java.util.List;
import java.util.Map;

import com.vport.system.bean.CourseTime;
import com.vport.system.bean.ResponseData;
import com.vport.system.bean.TimeTableWithWeek;
import com.vport.system.pojo.person.User;
import com.vport.system.pojo.training.TrainingClassInfo;

public interface CourseService {
    List<TrainingClassInfo> getClassInfo(User trainer);
    Map<String, Object> getTimeTable(Long id);
    List<CourseTime> getClassTimeByClassId(Long classId);
    TrainingClassInfo getClassInfoByClassId(Long classId);
}
