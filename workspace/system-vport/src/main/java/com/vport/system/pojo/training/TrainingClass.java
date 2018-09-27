package com.vport.system.pojo.training;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Table(name = "training_class")
public class TrainingClass implements Serializable{
    
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long classId;
    private String className;
    private String place;
    private String period;
    private String hourTo;
    private String rank;
    private String description;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date starttime;
    private Date createtime;
    private Boolean isOpen;
    private Boolean isFinish;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @Column(name = "deadLine")
    private Date deadLine;
    private String pic;
    private String ageRange;
    
    
    
   
    public String getAgeRange() {
        return ageRange;
    }
    public void setAgeRange(String ageRange) {
        this.ageRange = ageRange;
    }
    public Date getDeadLine() {
        return deadLine;
    }
    public void setDeadLine(Date deadLine) {
        this.deadLine = deadLine;
    }
    public String getPic() {
        return pic;
    }
    public void setPic(String pic) {
        this.pic = pic;
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
    public String getClassName() {
        return className;
    }
    public void setClassName(String className) {
        this.className = className;
    }
    public String getPlace() {
        return place;
    }
    public void setPlace(String place) {
        this.place = place;
    }
    public String getPeriod() {
        return period;
    }
    public void setPeriod(String period) {
        this.period = period;
    }
    public String getRank() {
        return rank;
    }
    public void setRank(String rank) {
        this.rank = rank;
    }
    
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public Date getStarttime() {
        return starttime;
    }
    public void setStarttime(Date starttime) {
        this.starttime = starttime;
    }
    public Date getCreatetime() {
        return createtime;
    }
    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }
    public Boolean getIsOpen() {
        return isOpen;
    }
    public void setIsOpen(Boolean isOpen) {
        this.isOpen = isOpen;
    }
    public Boolean getIsFinish() {
        return isFinish;
    }
    public void setIsFinish(Boolean isFinish) {
        this.isFinish = isFinish;
    }
    
    
}
