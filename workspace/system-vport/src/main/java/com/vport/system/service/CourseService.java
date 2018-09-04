package com.vport.system.service;

import java.util.List;

import com.vport.system.bean.TimeTable;
import com.vport.system.pojo.TrainingClassInfo;
import com.vport.system.pojo.User;

public interface CourseService {
    List<TrainingClassInfo> getClassInfo(User trainer);
    List<TimeTable> getTimeTable(User user);
}
