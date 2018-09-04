package com.vport.system.bean;

import java.io.Serializable;

import com.vport.system.pojo.User;

public class Student implements Serializable{
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private Long id;
    private String name;
    private String gender;
    private Integer height;
    private Double weight;
    private String phone;
    private Integer age;
    
    
    public Student(User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.gender = user.getGender();
        this.height = user.getHeight();
        this.age = user.getAge();
        this.phone = user.getPhone();
        this.weight = user.getWeight();
    }
    public Student(){}
    
    public Integer getAge() {
        return age;
    }
    public void setAge(Integer age) {
        this.age = age;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    public Integer getHeight() {
        return height;
    }
    public void setHeight(Integer height) {
        this.height = height;
    }
    public Double getWeight() {
        return weight;
    }
    public void setWeight(Double weight) {
        this.weight = weight;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    
    
}
