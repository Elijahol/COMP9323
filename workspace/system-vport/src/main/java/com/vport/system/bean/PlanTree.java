package com.vport.system.bean;



import java.util.ArrayList;
import java.util.List;

import com.vport.system.pojo.PlanType;

public class PlanTree {
    private List<PlanType> data = new ArrayList<PlanType>();

    public List<PlanType> getData() {
        return data;
    }

    public void setData(List<PlanType> data) {
        this.data = data;
    }
    
    
}
