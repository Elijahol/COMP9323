package com.vport.system.pojo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.vport.system.utils.DateUtil;

@Table(name = "training_schema")
public class TrainingPlan implements Serializable{
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    
    private Long chiefTainer;
    private Long classId;
    private Long assistantTrainer;
    private Date trainingTime;
    private Date created;
    private Date updated;
    @Transient
    private String trainingDate;
    
    
    
    public Long getClassId() {
        return classId;
    }
    public void setClassId(Long classId) {
        this.classId = classId;
    }
    public String getTrainingDate() {
        return trainingDate;
    }
    public void setTrainingDate(String trainingDate) {
        this.trainingDate = trainingDate;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    

    public Long getChiefTainer() {
        return chiefTainer;
    }
    public void setChiefTainer(Long chiefTainer) {
        this.chiefTainer = chiefTainer;
    }
    public Long getAssistantTrainer() {
        return assistantTrainer;
    }
    public void setAssistantTrainer(Long assistantTrainer) {
        this.assistantTrainer = assistantTrainer;
    }
    public Date getTrainingTime() {
        return trainingTime;
    }
    public void setTrainingTime(Date trainingTime) {
        this.trainingTime = trainingTime;
        this.trainingDate = DateUtil.dateToString(trainingTime);
    }
    public Date getCreated() {
        return created;
    }
    public void setCreated(Date created) {
        this.created = created;
    }
    public Date getUpdated() {
        return updated;
    }
    public void setUpdated(Date updated) {
        this.updated = updated;
    }
    
    
    
}
