package com.vport.system.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.github.abel533.mapper.Mapper;
import com.vport.system.pojo.person.Reward;
import com.vport.system.pojo.person.User;
import com.vport.system.pojo.person.UserWithReward;

/**
 * UserMapper is dynamic mapper which can be implemented by the framework mybatis.
 * This project applied the plugin jar "com.github.abel533.mapper" which is general mapper
 * encapsulating a series of functions to interact with database 
 * 
 * The github of "com.github.abel533.mapper" is an open source site
 * Gitbub address of the plugin is https://github.com/abel533/Mapper
 * 
 * @author Chaoyi Zhou
 */
public interface UserMapper extends Mapper<User>{
    User findUserByEmailAndPassword(User user);

    User findUserByCode(String code);

    UserWithReward findUserWithRewardById(Long id);

    void updateReward(Reward reward);

    void deleteReward(Long rewardId);

    void addReward(Reward reward);

    List<User> findUserByRole(long role);

    void insertRecoverCode(@Param("userId")Long id, @Param("code")String code);

    User findUserByRecoverCode(String code);
}
