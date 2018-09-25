package com.vport.system.pojo;

import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Table(name="information")
public class Info {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    
    private Long userId;
    private String content;
    private String url;
    private Date time;
    
    @Transient
    private String hisTime;
    
    
    private Integer status;
    
    
    
    
    
    public Integer getStatus() {
        return status;
    }
    public void setStatus(Integer status) {
        this.status = status;
    }
    public Info() {
    }
    public Info(Long userId, String content, String url, Date time,Integer status) {
        this.userId = userId;
        this.content = content;
        this.url = url;
        this.time = time;
        this.status = status;
    }
    
    public String getHisTime() {
        return hisTime;
    }
    public void setHisTime(String hisTime) {
        this.hisTime = hisTime;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Long getUserId() {
        return userId;
    }
    public void setUserId(Long userId) {
        this.userId = userId;
    }
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }
    public Date getTime() {
        return time;
    }
    public void setTime(Date time) {
        this.time = time;
    }
    
    
}
