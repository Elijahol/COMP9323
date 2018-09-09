package com.vport.system.pojo.eval;

import java.util.Date;

import com.vport.system.utils.DateUtil;

public class GeneralPerformanceDataOrderByTime implements Comparable<GeneralPerformanceDataOrderByTime>{
    
    private Double score;
    private Date time;
    private String visualTime;
    
    
    
    
    public Date getTime() {
        return time;
    }
    public void setTime(Date time) {
        this.visualTime = DateUtil.dateToString(time);
        this.time = time;
    }
    public String getVisualTime() {
        return visualTime;
    }
    public void setVisualTime(String visualTime) {
        this.visualTime = visualTime;
    }
    
    public Double getScore() {
        return score;
    }
    public void setScore(Double score) {
        this.score = score;
    }
    
    @Override
    public String toString() {
        return "GeneralPerformanceDataOrderByTime [score=" + score + ", time=" + time + ", visualTime="
                + visualTime + "]";
    }
    @Override
    public int compareTo(GeneralPerformanceDataOrderByTime o) {
        return this.time.compareTo(o.getTime());
    }
    
}
