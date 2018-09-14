package com.vport.system.service;

import com.vport.system.exception.MessageException;
import com.vport.system.pojo.person.Reward;
import com.vport.system.pojo.person.User;
import com.vport.system.pojo.person.UserWithReward;

public interface UserService {
    User findByEmailandPassword(User user);
    void register(User user)throws MessageException;
    void updateUser(User user);
    void updateUserSelective(User user);
    User findUserByCode(String code);
    User findUserById(Long id);
    /*void addTrainer(User user);
    void addPlayer(User user);*/
    UserWithReward findUserWithRewardById(Long id);
    void updateReward(Reward reward);
    void deleteReward(Reward reward);
    void addReward(Reward reward);
}
