package com.vport.system.pojo.training;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "skill_detail")
public class SkillDetail implements Serializable{
    
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String isLimitedTime;
    
    private String isContinuous;
    
    private String isMoved;
    
    private String isMultiple;
    
    private Integer groupNum;
    
    private Integer countNumOfGroup;
    
    private Integer numOfSuccess;
    
    private Integer requiredTime;
    
    private String isTarget;
    
    private String isCombined;
    
    private Long typeOfSkill;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIsLimitedTime() {
        return isLimitedTime;
    }

    public void setIsLimitedTime(String isLimitedTime) {
        this.isLimitedTime = isLimitedTime;
    }

    public String getIsContinuous() {
        return isContinuous;
    }

    public void setIsContinuous(String isContinuous) {
        this.isContinuous = isContinuous;
    }

    public String getIsMoved() {
        return isMoved;
    }

    public void setIsMoved(String isMoved) {
        this.isMoved = isMoved;
    }

    public String getIsMultiple() {
        return isMultiple;
    }

    public void setIsMultiple(String isMultiple) {
        this.isMultiple = isMultiple;
    }

    public Integer getGroupNum() {
        return groupNum;
    }

    public void setGroupNum(Integer groupNum) {
        this.groupNum = groupNum;
    }

    public Integer getCountNumOfGroup() {
        return countNumOfGroup;
    }

    public void setCountNumOfGroup(Integer countNumOfGroup) {
        this.countNumOfGroup = countNumOfGroup;
    }

    public Integer getNumOfSuccess() {
        return numOfSuccess;
    }

    public void setNumOfSuccess(Integer numOfSuccess) {
        this.numOfSuccess = numOfSuccess;
    }

    public Integer getRequiredTime() {
        return requiredTime;
    }

    public void setRequiredTime(Integer requiredTime) {
        this.requiredTime = requiredTime;
    }

    public String getIsTarget() {
        return isTarget;
    }

    public void setIsTarget(String isTarget) {
        this.isTarget = isTarget;
    }

    public String getIsCombined() {
        return isCombined;
    }

    public void setIsCombined(String isCombined) {
        this.isCombined = isCombined;
    }

    public Long getTypeOfSkill() {
        return typeOfSkill;
    }

    public void setTypeOfSkill(Long typeOfSkill) {
        this.typeOfSkill = typeOfSkill;
    }

    @Override
    public String toString() {
        return "SkillDetail [id=" + id + ", isLimitedTime=" + isLimitedTime + ", isContinuous=" + isContinuous
                + ", isMoved=" + isMoved + ", isMultiple=" + isMultiple + ", groupNum=" + groupNum
                + ", countNumOfGroup=" + countNumOfGroup + ", numOfSuccess=" + numOfSuccess
                + ", requiredTime=" + requiredTime + ", isTarget=" + isTarget + ", isCombined=" + isCombined
                + ", typeOfSkill=" + typeOfSkill + "]";
    }
    
    
}
