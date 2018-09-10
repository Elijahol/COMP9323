package com.vport.system.pojo.eval;

import java.io.Serializable;

public class PerformanceContent implements Serializable{
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private Long id;
    private Long assessId;
    private Long contentId;
    private Double count;
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Long getAssessId() {
        return assessId;
    }
    public void setAssessId(Long assessId) {
        this.assessId = assessId;
    }
    public Long getContentId() {
        return contentId;
    }
    public void setContentId(Long contentId) {
        this.contentId = contentId;
    }
    public Double getCount() {
        return count;
    }
    public void setCount(Double count) {
        this.count = count;
    }
    
    
}
