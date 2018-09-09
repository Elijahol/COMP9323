package com.vport.system.bean;

import java.io.Serializable;
import java.util.List;

import com.vport.system.pojo.PhysicalDetail;
import com.vport.system.pojo.SkillDetail;
import com.vport.system.pojo.TrainingPlan;

public class MakeTrainingPlan implements Serializable{
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private TrainingPlan plan;
    
    private List<PhysicalDetail> physicalDetails;
    
    private List<SkillDetail> skillDetails;

    public TrainingPlan getPlan() {
        return plan;
    }

    public void setPlan(TrainingPlan plan) {
        this.plan = plan;
    }

    public List<PhysicalDetail> getPhysicalDetails() {
        return physicalDetails;
    }

    public void setPhysicalDetails(List<PhysicalDetail> physicalDetails) {
        this.physicalDetails = physicalDetails;
    }

    public List<SkillDetail> getSkillDetails() {
        return skillDetails;
    }

    public void setSkillDetails(List<SkillDetail> skillDetails) {
        this.skillDetails = skillDetails;
    }
    
    
    
}
