package com.vport.system.pojo.training;

import java.util.List;

import com.vport.system.bean.Student;

public class TrainingClassInfo extends TrainingClass{

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    
    private Boolean isChief;
    
    private List<Student> students;
    
    private List<TrainingPlan> plansHistory;
    private List<TrainingPlan> futurePlans;
    
    

    public List<TrainingPlan> getFuturePlans() {
        return futurePlans;
    }

    public void setFuturePlans(List<TrainingPlan> futurePlans) {
        this.futurePlans = futurePlans;
    }

    public Boolean getIsChief() {
        return isChief;
    }

    public void setIsChief(Boolean isChief) {
        this.isChief = isChief;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public List<TrainingPlan> getPlansHistory() {
        return plansHistory;
    }

    public void setPlansHistory(List<TrainingPlan> plansHistory) {
        this.plansHistory = plansHistory;
    }
    
   

}
