package com.vport.system.service;

import java.util.List;

import com.vport.system.bean.CourseTime;
import com.vport.system.bean.ResponseData;
import com.vport.system.pojo.person.User;
import com.vport.system.pojo.training.TrainingClassInfo;

public interface CourseService {
    List<TrainingClassInfo> getClassInfo(User trainer);
    ResponseData getTimeTable(Long id);
    List<CourseTime> getClassTimeByClassId(Long classId);
}
