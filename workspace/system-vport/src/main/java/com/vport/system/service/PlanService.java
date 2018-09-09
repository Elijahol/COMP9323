package com.vport.system.service;



import com.vport.system.bean.MakeTrainingPlan;
import com.vport.system.bean.PlanTree;
import com.vport.system.pojo.TrainingPlanInfo;

public interface PlanService {
    PlanTree getPlanTree();
    void makeNewPlan(MakeTrainingPlan newPlan);
    TrainingPlanInfo getTrainingPlanInfo(Long schemaId);
}
