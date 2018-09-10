package com.vport.system.mapper;


import java.util.List;

import com.github.abel533.mapper.Mapper;
import com.vport.system.pojo.person.User;
import com.vport.system.pojo.training.TrainingClass;
import com.vport.system.pojo.training.TrainingClassInfo;
import com.vport.system.pojo.training.TrainingPlan;

public interface CourseMapper extends Mapper<TrainingClass> {
    List<TrainingClassInfo> findClassByTrainer(Long id);

    List<User> findStudentsByClass(Long classId);
    
    List<TrainingPlan> findPlanByClass(Long classId);
}
