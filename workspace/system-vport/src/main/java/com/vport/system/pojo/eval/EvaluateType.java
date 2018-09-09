package com.vport.system.pojo.eval;

import java.io.Serializable;
import java.util.List;

public class EvaluateType implements Serializable{
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private Long id;
    private String name;
    private String chName;
    private List<EvaluateContent> evaluateContents;
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getChName() {
        return chName;
    }
    public void setChName(String chName) {
        this.chName = chName;
    }
    public List<EvaluateContent> getEvaluateContents() {
        return evaluateContents;
    }
    public void setEvaluateContents(List<EvaluateContent> evaluateContents) {
        this.evaluateContents = evaluateContents;
    }
    @Override
    public String toString() {
        return "EvaluateType [id=" + id + ", name=" + name + ", chName=" + chName + ", evaluateContents="
                + evaluateContents + "]";
    }
    
    
}
