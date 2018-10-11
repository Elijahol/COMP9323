package com.vport.system.pojo;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import com.vport.system.pojo.person.User;
import com.vport.system.pojo.training.TrainingClass;

public class TrainingClassToDisPlay {
    
    private TrainingClass trainingClass;
    private User trainer;
    private List<String> pics;
    private List<User> students;
    
    private String startTime;
    private String deadLine;
    
    
    
    
    
    public String getStartTime() {
        return startTime;
    }
    public void setStartTime(Date startTime) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd MMMM yyyy",Locale.ENGLISH);
        this.startTime = sdf.format(startTime);
    }
    public String getDeadLine() {
        return deadLine;
    }
    public void setDeadLine(Date deadLine) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy",Locale.ENGLISH);
        this.deadLine = sdf.format(deadLine);
    }
    public List<User> getStudents() {
        return students;
    }
    public void setStudents(List<User> students) {
        this.students = students;
    }
    public TrainingClass getTrainingClass() {
        return trainingClass;
    }
    public void setTrainingClass(TrainingClass trainingClass) {
        this.trainingClass = trainingClass;
    }
    public User getTrainer() {
        return trainer;
    }
    public void setTrainer(User trainer) {
        this.trainer = trainer;
    }
    public List<String> getPics() {
        return pics;
    }
    public void setPics(List<String> pics) {
        this.pics = pics;
    }
    
    
    

}
