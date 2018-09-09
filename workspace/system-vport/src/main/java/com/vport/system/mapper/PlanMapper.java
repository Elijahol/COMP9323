package com.vport.system.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.github.abel533.mapper.Mapper;
import com.vport.system.pojo.PhysicalDetail;
import com.vport.system.pojo.PhysicalDetailNonSpecilized;
import com.vport.system.pojo.PhysicalDetailSpecilized;
import com.vport.system.pojo.PlanType;
import com.vport.system.pojo.SkillDetail;
import com.vport.system.pojo.SkillDetailWithFullInfo;
import com.vport.system.pojo.TrainingPlan;
import com.vport.system.pojo.TrainingPlanInfo;

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

}
