package com.vport.system.pojo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

import com.vport.system.utils.DateUtil;

public class User implements Serializable{
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String password;
    private String email;
    private String phone;
    private Date birthday;
    private String gender;
    private Integer height;
    private Double weight;
    private String city;
    private String icon;
    private String experience;
    private String award;
    private Integer status; //1.已经激活 0.未激活
    private Integer role; //1.教练 2.成年人 3.未成年人
    private String code;
    private Date createtime;
    private Date updatetime;
    
    @Transient
    private Integer age;
    
    
    public String getExperience() {
        return experience;
    }
    public void setExperience(String experience) {
        this.experience = experience;
    }
    public Integer getAge() {
        return age;
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
        this.name = name==null?null:name.trim();
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password==null?null:password.trim();
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email==null?null:email.trim();
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone==null?null:phone.trim();
    }
    public Date getBirthday() {
        return birthday;
    }
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
        this.age = DateUtil.getAgeByBirth(birthday);
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
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city==null?null:city.trim();;
    }
    public String getIcon() {
        return icon;
    }
    public void setIcon(String icon) {
        this.icon = icon==null?null:icon.trim();;
    }
    public String getExprience() {
        return experience;
    }
    public void setExprience(String experience) {
        this.experience = experience==null?null:experience.trim();;
    }
    public String getAward() {
        return award;
    }
    public void setAward(String award) {
        this.award = award==null?null:award.trim();;
    }
    public Integer getStatus() {
        return status;
    }
    public void setStatus(Integer status) {
        this.status = status;
    }
    public Integer getRole() {
        return role;
    }
    public void setRole(Integer role) {
        this.role = role;
    }
    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }
    public Date getCreatetime() {
        return createtime;
    }
    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }
    public Date getUpdatetime() {
        return updatetime;
    }
    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }
    @Override
    public String toString() {
        return "User [id=" + id + ", name=" + name + ", password=" + password + ", email=" + email
                + ", phone=" + phone + ", birthday=" + birthday + ", gender=" + gender + ", height=" + height
                + ", weight=" + weight + ", city=" + city + ", icon=" + icon + ", experience=" + experience
                + ", award=" + award + ", status=" + status + ", role=" + role + ", code=" + code
                + ", createtime=" + createtime + ", updatetime=" + updatetime + "]";
    }
    
    
    
}
