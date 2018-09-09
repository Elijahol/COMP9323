package com.vport.system.pojo.eval;

import java.io.Serializable;

public class EvaluateContent implements Serializable{
    
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private Long id;
    private String name;
    private String chName;
    private Long type;
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
    public Long getType() {
        return type;
    }
    public void setType(Long type) {
        this.type = type;
    }
    @Override
    public String toString() {
        return "EvaluateContent [id=" + id + ", name=" + name + ", chName=" + chName + ", type=" + type + "]";
    }
    
    
}
