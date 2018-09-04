package com.vport.system.mapper;


import java.util.List;

import com.github.abel533.mapper.Mapper;
import com.vport.system.pojo.TrainingClass;
import com.vport.system.pojo.TrainingClassInfo;
import com.vport.system.pojo.TrainingPlan;
import com.vport.system.pojo.User;

public interface CourseMapper extends Mapper<TrainingClass> {
    List<TrainingClassInfo> findClassByTrainer(Long id);

    List<User> findStudentsByClass(Long classId);
    
    List<TrainingPlan> findPlanByClass(Long classId);
}
