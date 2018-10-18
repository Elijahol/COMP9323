package com.vport.system.pojo.person;

import java.util.Date;

/**
 * Reward informatin maps to the table "reward" of database
 * @author Chaoyi Zhou
 *
 */
public class Reward {
    
    private Long id;
    private Long userId;
    private String title;
    private String content;
    private String rewardTime;
    private Date createTime;
    private Date updateTime;
    
    public Date getUpdateTime() {
        return updateTime;
    }
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
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
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public String getRewardTime() {
        return rewardTime;
    }
    public void setRewardTime(String rewardTime) {
        this.rewardTime = rewardTime;
    }
    public Date getCreateTime() {
        return createTime;
    }
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
    
    
}
