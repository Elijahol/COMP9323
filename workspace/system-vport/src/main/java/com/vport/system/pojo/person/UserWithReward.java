package com.vport.system.pojo.person;

import java.util.List;

public class UserWithReward extends User{

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private List<Reward> rewards;
    public List<Reward> getRewards() {
        return rewards;
    }
    public void setRewards(List<Reward> rewards) {
        this.rewards = rewards;
    }
    
    
    
    
}
