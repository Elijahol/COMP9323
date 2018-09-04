package com.vport.system.pojo;

import java.util.List;

import com.vport.system.bean.Student;

public class TrainingClassInfo extends TrainingClass{

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    
    private Boolean isChief;
    
    private List<Student> students;
    
    private List<TrainingPlan> plans;
    
    
    public List<TrainingPlan> getPlans() {
        return plans;
    }

    public void setPlans(List<TrainingPlan> plans) {
        this.plans = plans;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public Boolean getIsChief() {
        return isChief;
    }

    public void setIsChief(Boolean isChief) {
        this.isChief = isChief;
    }
    

}
