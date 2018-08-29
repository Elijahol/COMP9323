package com.vport.system.pojo;



import java.util.List;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Table(name = "training_hierarchy")
public class PlanType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String typeName;
    private Long parentId;
    private Boolean isParent;
    private Long unitId;
    private Integer layerNum;
    @Transient
    private List<PlanType> chlidren;
    
    
    public Long getParentId() {
        return parentId;
    }
    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }
    public List<PlanType> getChlidren() {
        return chlidren;
    }
    public void setChlidren(List<PlanType> chlidren) {
        this.chlidren = chlidren;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getTypeName() {
        return typeName;
    }
    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }
    public Boolean getIsParent() {
        return isParent;
    }
    public void setIsParent(Boolean isParent) {
        this.isParent = isParent;
    }
    public Long getUnitId() {
        return unitId;
    }
    public void setUnitId(Long unitId) {
        this.unitId = unitId;
    }
    public Integer getLayerNum() {
        return layerNum;
    }
    public void setLayerNum(Integer layerNum) {
        this.layerNum = layerNum;
    }
    @Override
    public String toString() {
        return "PlanType [id=" + id + ", typeName=" + typeName + ", parentId=" + parentId + ", isParent="
                + isParent + ", unitId=" + unitId + ", layerNum=" + layerNum + ", chlidren=" + chlidren + "]";
    }
    
    
}
