package com.vport.system.pojo;

public class PhysicalDetailNonSpecilized extends PhysicalDetail {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private String typeName;
    private String unitName;
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
        return "PhysicalDetailNonSpecilized [typeName=" + typeName + ", unitName=" + unitName + "]";
    }
    
    
}
