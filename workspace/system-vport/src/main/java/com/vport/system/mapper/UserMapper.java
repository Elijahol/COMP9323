package com.vport.system.mapper;

import com.github.abel533.mapper.Mapper;
import com.vport.system.pojo.person.Reward;
import com.vport.system.pojo.person.User;
import com.vport.system.pojo.person.UserWithReward;

public interface UserMapper extends Mapper<User>{
    User findUserByEmailAndPassword(User user);

    User findUserByCode(String code);

    UserWithReward findUserWithRewardById(Long id);

    void updateReward(Reward reward);

    void deleteReward(Long rewardId);

    void addReward(Reward reward);

    /*void insertTrainer(Long id);

    void insertPlayer(Long id);*/
}
