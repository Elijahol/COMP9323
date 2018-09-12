package com.vport.system.bean;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class TimeTable implements Serializable{
    /**
     * 
     */
    private final SimpleDateFormat FORMAT = new SimpleDateFormat("KK:mm aa",Locale.ENGLISH);
    private static final long serialVersionUID = 1L;
    private Long classId;
    private String className;
    private Date time;
    private String place;
    private String hourTo;
    private String visualTime;
    
    public TimeTable(Long classId,String className, Date time, String place,String hourTo) {
        this.classId = classId;
        this.className = className;
        this.time = time;
        this.place = place;
        this.hourTo = hourTo;
        this.visualTime = FORMAT.format(time).toLowerCase();
    }
    
    public TimeTable() {
    }
    
    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getVisualTime() {
        return visualTime;
    }

    public void setVisualTime(String visualTime) {
        this.visualTime = visualTime;
    }

    public String getHourTo() {
        return hourTo;
    }

    public void setHourTo(String hourTo) {
        this.hourTo = hourTo;
    }

    public Long getClassId() {
        return classId;
    }
    public void setClassId(Long classId) {
        this.classId = classId;
    }
    public Date getTime() {
        return time;
    }
    public void setTime(Date time) {
        this.time = time;
    }
    public String getPlace() {
        return place;
    }
    public void setPlace(String place) {
        this.place = place;
    }

    @Override
    public String toString() {
        return "TimeTable [classId=" + classId + ", time=" + time + ", place=" + place + ", hourTo=" + hourTo
                + ", visualTime=" + visualTime + "]";
    }

    
    
    
}
