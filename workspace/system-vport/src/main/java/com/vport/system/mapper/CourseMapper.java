package com.vport.system.mapper;


import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.github.abel533.mapper.Mapper;
import com.vport.system.pojo.ClassInfoForStu;
import com.vport.system.pojo.person.User;
import com.vport.system.pojo.training.TrainingClass;
import com.vport.system.pojo.training.TrainingClassInfo;
import com.vport.system.pojo.training.TrainingPlan;
/**
 * CourseMapper is dynamic mapper which can be implemented by the framework mybatis.
 * This project applied the plugin jar "com.github.abel533.mapper" which is general mapper
 * encapsulating a series of functions to interact with database 
 * 
 * The github of "com.github.abel533.mapper" is an open source site
 * Gitbub address of the plugin is https://github.com/abel533/Mapper
 * 
 * @author Siyu Wang
 */
public interface CourseMapper extends Mapper<TrainingClass> {
    List<TrainingClassInfo> findClassByTrainer(Long id);

    List<User> findStudentsByClass(Long classId);
    
    List<TrainingPlan> findPlanHistoryByClass(Long classId);

    TrainingClassInfo findClassInfoByClassId(Long classId);

    void storeClass(TrainingClass trainingClass);

    void linkClassAndTrainer(@Param("classId")Long classId, @Param("trainer")Long trainer,@Param("isChief") Integer isChief);

    User findChiefTrainerOfClass(Long classId);

    List<TrainingClassInfo> findClassByPlayer(Long id);

    List<ClassInfoForStu> findClassInfoByStu(Long id);

    ClassInfoForStu findClassInfoForStuByClassId(Long classId);

    void linkClassAndStu(@Param("classId")Long classId, @Param("student")Long id);

    List<TrainingPlan> findFuturePlansByClass(Long classId);
}
