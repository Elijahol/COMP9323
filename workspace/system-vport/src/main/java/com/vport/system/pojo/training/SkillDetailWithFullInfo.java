package com.vport.system.pojo.training;

public class SkillDetailWithFullInfo extends SkillDetail{
    
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private String parentName;
    private String parentNameCh;
    private String typeName;
    private String typeNameCh;
    
    
    public String getParentNameCh() {
        return parentNameCh;
    }
    public void setParentNameCh(String parentNameCh) {
        this.parentNameCh = parentNameCh;
    }
    public String getTypeNameCh() {
        return typeNameCh;
    }
    public void setTypeNameCh(String typeNameCh) {
        this.typeNameCh = typeNameCh;
    }
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
