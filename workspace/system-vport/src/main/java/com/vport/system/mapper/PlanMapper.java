package com.vport.system.mapper;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.github.abel533.mapper.Mapper;
import com.vport.system.pojo.training.PhysicalDetail;
import com.vport.system.pojo.training.PhysicalDetailNonSpecilized;
import com.vport.system.pojo.training.PhysicalDetailSpecilized;
import com.vport.system.pojo.training.PlanType;
import com.vport.system.pojo.training.SkillDetail;
import com.vport.system.pojo.training.SkillDetailWithFullInfo;
import com.vport.system.pojo.training.TrainingPlan;
import com.vport.system.pojo.training.TrainingPlanInfo;
/**
 * PlanMapper is dynamic mapper which can be implemented by the framework mybatis.
 * This project applied the plugin jar "com.github.abel533.mapper" which is general mapper
 * encapsulating a series of functions to interact with database 
 * 
 * The github of "com.github.abel533.mapper" is an open source site
 * Gitbub address of the plugin is https://github.com/abel533/Mapper
 * 
 * @author Siyu Wang
 */
public interface PlanMapper extends Mapper<PlanType>{
    
    void insertNewPlan(TrainingPlan newPlan);

    void insertPhysicalDetail(PhysicalDetail physicalDetail);

    void insertPhysicalSchemaDetail(@Param("trainingSchenmaId")Long id, @Param("physicalDetailId")Long id2);

    void insertSkillDetail(SkillDetail skillDetail);

    void insertSkillSchemaDetail(@Param("trainingSchenmaId")Long id,@Param("skillDetailId")Long id2);

    TrainingPlanInfo selectPlanInfoById(Long schemaId);

    List<PhysicalDetailNonSpecilized> selectWarmUpBySchemaId(Long id);

    List<PhysicalDetailNonSpecilized> selectRelaxiationBySchemaId(Long id);

    List<PhysicalDetailSpecilized> selectSpecilizedBySchemaId(Long schemaId);

    List<SkillDetailWithFullInfo> selectSkillDetailWithFullInfo(Long schemaId);

    List<PlanType> selectTypeWithUnit();
    
    List<Date> findSchemaTrainingTimeByClassId(Long classId);

    List<TrainingPlan> findFuturePlan(Long classId);

}
