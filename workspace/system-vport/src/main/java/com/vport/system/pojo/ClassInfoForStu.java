package com.vport.system.pojo;

import java.util.List;

import com.vport.system.bean.Student;
import com.vport.system.pojo.person.User;
import com.vport.system.pojo.training.TrainingClass;
import com.vport.system.pojo.training.TrainingPlan;

public class ClassInfoForStu extends TrainingClass{
    private User trainer;
    private List<Student> students;
    
    private List<TrainingPlan> plans;
    
    private List<String> daysOfTraining;
    
    
   
    
    public List<String> getDaysOfTraining() {
        return daysOfTraining;
    }
    public void setDaysOfTraining(List<String> daysOfTraining) {
        this.daysOfTraining = daysOfTraining;
    }
    public List<Student> getStudents() {
        return students;
    }
    public void setStudents(List<Student> students) {
        this.students = students;
    }
    public List<TrainingPlan> getPlans() {
        return plans;
    }
    public void setPlans(List<TrainingPlan> plans) {
        this.plans = plans;
    }
    public User getTrainer() {
        return trainer;
    }
    public void setTrainer(User trainer) {
        this.trainer = trainer;
    }
    
    
}
