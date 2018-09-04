package com.vport.system.pojo;

public class SkillDetailWithFullInfo extends SkillDetail{
    
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private String parentName;
    private String typeName;
    public String getParentName() {
        return parentName;
    }
    public void setParentName(String parentName) {
        this.parentName = parentName;
    }
    public String getTypeName() {
        return typeName;
    }
    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }
    
    
}
