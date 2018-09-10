package com.vport.system.bean;

import java.io.Serializable;

import com.vport.system.pojo.eval.EvaluateType;

public class EvaluateData implements Serializable{
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private EvaluateType cognitiveTechniques;
    private EvaluateType athleticAbility;
    public EvaluateType getCognitiveTechniques() {
        return cognitiveTechniques;
    }
    public void setCognitiveTechniques(EvaluateType cognitiveTechniques) {
        this.cognitiveTechniques = cognitiveTechniques;
    }
    public EvaluateType getAthleticAbility() {
        return athleticAbility;
    }
    public void setAthleticAbility(EvaluateType athleticAbility) {
        this.athleticAbility = athleticAbility;
    }
    
}
