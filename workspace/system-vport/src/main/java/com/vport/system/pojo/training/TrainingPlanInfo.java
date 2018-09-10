package com.vport.system.pojo.training;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.persistence.Transient;

import com.vport.system.pojo.training.PhysicalContent;
import com.vport.system.pojo.training.SkillDetailWithFullInfo;

public class TrainingPlanInfo extends TrainingPlan{
    
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    
    @Transient
    private PhysicalContent physicalPart;
    @Transient
    private Map<String,List<SkillDetailWithFullInfo>> skillPart;

    

    public PhysicalContent getPhysicalPart() {
        return physicalPart;
    }

    public void setPhysicalPart(PhysicalContent physicalPart) {
        this.physicalPart = physicalPart;
    }

    public Map<String, List<SkillDetailWithFullInfo>> getSkillPart() {
        return skillPart;
    }

    public void setSkillPart(Map<String, List<SkillDetailWithFullInfo>> skillPart) {
        this.skillPart = skillPart;
    }
    
    
    
}
