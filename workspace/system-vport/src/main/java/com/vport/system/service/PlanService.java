package com.vport.system.service;



import com.vport.system.bean.MakeTrainingPlan;
import com.vport.system.bean.PlanTree;
import com.vport.system.pojo.training.TrainingPlan;
import com.vport.system.pojo.training.TrainingPlanInfo;

public interface PlanService {
    PlanTree getPlanTree();
    void makeNewPlan(MakeTrainingPlan newPlan);
    TrainingPlanInfo getTrainingPlanInfo(Long schemaId);
    TrainingPlan getClosestPlan(Long classId);
}
