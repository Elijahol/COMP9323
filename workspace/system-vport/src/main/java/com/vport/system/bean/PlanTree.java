package com.vport.system.bean;



import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.vport.system.pojo.training.PlanType;

public class PlanTree implements Serializable{
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private List<PlanType> data = new ArrayList<PlanType>();

    public List<PlanType> getData() {
        return data;
    }

    public void setData(List<PlanType> data) {
        this.data = data;
    }
    
    
}
