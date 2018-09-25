package com.vport.system.pojo.training;

public class PhysicalDetailSpecilized extends PhysicalDetail {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private String parentName;
    private String parentNameCh;
    private String typeName;
    private String typeNameCh;
    private String unitName;
    
    
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
    public String getUnitName() {
        return unitName;
    }
    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }
    @Override
    public String toString() {
        return "PhysicalDetailSpecilized [parentName=" + parentName + ", typeName=" + typeName + ", unitName="
                + unitName + "]";
    }
    
    
}
