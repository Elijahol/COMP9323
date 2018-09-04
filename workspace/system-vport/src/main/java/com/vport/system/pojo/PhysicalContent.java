package com.vport.system.pojo;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public class PhysicalContent implements Serializable{
    
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private List<PhysicalDetailNonSpecilized> warmUp;
    private Map<String,List<PhysicalDetailSpecilized>> specializedTraining;
    private List<PhysicalDetailNonSpecilized> relaxiation;
    public List<PhysicalDetailNonSpecilized> getWarmUp() {
        return warmUp;
    }
    public void setWarmUp(List<PhysicalDetailNonSpecilized> warmUp) {
        this.warmUp = warmUp;
    }
    public Map<String, List<PhysicalDetailSpecilized>> getSpecializedTraining() {
        return specializedTraining;
    }
    public void setSpecializedTraining(Map<String, List<PhysicalDetailSpecilized>> specializedTraining) {
        this.specializedTraining = specializedTraining;
    }
    public List<PhysicalDetailNonSpecilized> getRelaxiation() {
        return relaxiation;
    }
    public void setRelaxiation(List<PhysicalDetailNonSpecilized> relaxiation) {
        this.relaxiation = relaxiation;
    }
    
    
}
