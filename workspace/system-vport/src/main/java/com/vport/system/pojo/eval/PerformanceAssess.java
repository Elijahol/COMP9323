package com.vport.system.pojo.eval;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class PerformanceAssess implements Serializable{
    
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private Long id;
    private Long player;
    private Date time;
    private String comment;
    private Long trainer;
    
    private List<PerformanceContent> performanceContents;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPlayer() {
        return player;
    }

    public void setPlayer(Long player) {
        this.player = player;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    

    public Long getTrainer() {
        return trainer;
    }

    public void setTrainer(Long trainer) {
        this.trainer = trainer;
    }

    public List<PerformanceContent> getPerformanceContents() {
        return performanceContents;
    }

    public void setPerformanceContents(List<PerformanceContent> performanceContents) {
        this.performanceContents = performanceContents;
    }

    
    
    
}
