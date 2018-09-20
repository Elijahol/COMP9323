package com.vport.system.pojo.eval;

import java.text.SimpleDateFormat;
import java.util.Date;

public class PerformanceScoreWithTime {
    private Long typeId;
    private String typeName;
    private String typeNameCh;
    private Double score;
    private Date time;
    private String visualTime;
    public Long getTypeId() {
        return typeId;
    }
    public void setTypeId(Long typeId) {
        this.typeId = typeId;
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
    public Double getScore() {
        return score;
    }
    public void setScore(Double score) {
        this.score = score;
    }
    public Date getTime() {
        return time;
    }
    public void setTime(Date time) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy");
        this.visualTime = sdf.format(time);
        this.time = time;
    }
    public String getVisualTime() {
        return visualTime;
    }
    public void setVisualTime(String visualTime) {
        this.visualTime = visualTime;
    }
    
    
}
