package com.vport.system.pojo.eval;

import java.io.Serializable;
import java.util.List;

public class AvgPerformanceData implements Serializable{
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private List<PerformanceScore>  cognitiveTechniques;
    private List<PerformanceScore> athleticAbility;
    public List<PerformanceScore> getCognitiveTechniques() {
        return cognitiveTechniques;
    }
    public void setCognitiveTechniques(List<PerformanceScore> cognitiveTechniques) {
        this.cognitiveTechniques = cognitiveTechniques;
    }
    public List<PerformanceScore> getAthleticAbility() {
        return athleticAbility;
    }
    public void setAthleticAbility(List<PerformanceScore> athleticAbility) {
        this.athleticAbility = athleticAbility;
    }
    
    
}
