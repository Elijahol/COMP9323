package com.vport.system.pojo;



import java.io.Serializable;
import java.util.List;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Table(name = "training_hierarchy")
public class PlanType implements Serializable {
    /**
     * 
     */
    @Transient
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String chTypeName;
    private String typeName;
    private Long parentId;
    private Boolean isParent;
    private String unitName;
    @Transient
    private List<PlanType> children;
    
    
    public String getChTypeName() {
        return chTypeName;
    }
    public void setChTypeName(String chTypeName) {
        this.chTypeName = chTypeName;
    }
    public Long getParentId() {
        return parentId;
    }
    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }
    public List<PlanType> getChildren() {
        return children;
    }
    public void setChildren(List<PlanType> children) {
        this.children = children;
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
    public String getUnitName() {
        return unitName;
    }
    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }
    @Override
    public String toString() {
        return "PlanType [id=" + id + ", chTypeName=" + chTypeName + ", typeName=" + typeName + ", parentId="
                + parentId + ", isParent=" + isParent + ", unitName=" + unitName + ", children=" + children
                + "]";
    }
    
    
    
    
}
