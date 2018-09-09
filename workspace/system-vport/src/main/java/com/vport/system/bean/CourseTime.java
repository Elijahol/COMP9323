package com.vport.system.bean;

import java.io.Serializable;
import java.util.Date;

public class CourseTime implements Serializable,Comparable<CourseTime>{
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private Date trainingTime;
    private String visualTime;
    public Date getTrainingTime() {
        return trainingTime;
    }
    public void setTrainingTime(Date trainingTime) {
        this.trainingTime = trainingTime;
    }
    public String getVisualTime() {
        return visualTime;
    }
    public void setVisualTime(String visualTime) {
        this.visualTime = visualTime;
    }
    @Override
    public String toString() {
        return "CourseTime [trainingTime=" + trainingTime + ", visualTime=" + visualTime + "]";
    }
    public CourseTime(Date trainingTime, String visualTime) {
        this.trainingTime = trainingTime;
        this.visualTime = visualTime;
    }
    public CourseTime() {
    }
    @Override
    public int compareTo(CourseTime o) {
        return this.trainingTime.compareTo(o.getTrainingTime());
    }
    
    
}
