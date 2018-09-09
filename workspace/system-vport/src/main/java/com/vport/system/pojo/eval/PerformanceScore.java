package com.vport.system.pojo.eval;

import java.io.Serializable;

public class PerformanceScore implements Serializable{
    
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private Long contentId;
    private String contentName;
    private String contentNameCh;
    private Double score;
    private Long typeId;
    private String typeName;
    private String typeNameCh;
    
    public Long getContentId() {
        return contentId;
    }
    public void setContentId(Long contentId) {
        this.contentId = contentId;
    }
    public String getContentName() {
        return contentName;
    }
    public void setContentName(String contentName) {
        this.contentName = contentName;
    }
    public String getContentNameCh() {
        return contentNameCh;
    }
    public void setContentNameCh(String contentNameCh) {
        this.contentNameCh = contentNameCh;
    }
    public Long getTypeId() {
        return typeId;
    }
    public void setTypeId(Long typeId) {
        this.typeId = typeId;
    }
    public Double getScore() {
        return score;
    }
    public void setScore(Double score) {
        this.score = score;
    }
    public String getTypeName() {
        return typeName;
    }
    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }
    public String getTypeNameCh() {
        return typeNameCh;
    }
    public void setTypeNameCh(String typeNameCh) {
        this.typeNameCh = typeNameCh;
    }
    @Override
    public String toString() {
        return "PerformanceScore [contentId=" + contentId + ", contentName=" + contentName
                + ", contentNameCh=" + contentNameCh + ", score=" + score + ", typeId=" + typeId
                + ", typeName=" + typeName + ", typeNameCh=" + typeNameCh + "]";
    }
    
    
    
    
}
