package com.vport.system.pojo;

public class PhysicalDetailSpecilized extends PhysicalDetail {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private String parentName;
    private String typeName;
    private String unitName;
    
    
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
