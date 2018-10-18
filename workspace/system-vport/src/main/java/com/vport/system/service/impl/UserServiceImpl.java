package com.vport.system.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.abel533.entity.Example;
import com.github.abel533.entity.Example.Criteria;
import com.vport.system.exception.MessageException;
import com.vport.system.mapper.UserMapper;
import com.vport.system.pojo.person.Reward;
import com.vport.system.pojo.person.User;
import com.vport.system.pojo.person.UserWithReward;
import com.vport.system.service.UserService;
import com.vport.system.utils.MailUtils;
import com.vport.system.utils.UUIDUtils;
/**
 * UserServiceImpl is an implementation of the interface UserService.
 * it complete the business logic of functions relating user account management.
 * it depends on the dynamic mapper "userMapper" to interact with database.
 * Also the util tool mailutils is injected into this class to complete the mail function. 
 * 
 * 
 * @author Chaoyi Zhou
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    
    @Autowired
    private MailUtils mailutils;
    
    /**
     * Find the user by using the email
     */
    @Override
    public User findUserByEmail(User user) {
        Example example = new Example(User.class);
        example.createCriteria().andEqualTo("email", user.getEmail());
        return userMapper.selectByExample(example).get(0);
    }
    /**
     * Find the user by using the email and password
     */
    @Override
    public User findByEmailandPassword(User user) {
        
        return userMapper.findUserByEmailAndPassword(user);
    }
    /**
     * Complete the register logic:
     *  1.set the status of the user to 0 representing unactivated;
     *  2.generate the unique code for user to activate;
     *  3.set the default icon;
     *  4.send the activation email to the user asynchronously
     *  5.save the user into the database
     */
    @Override
    public void register(User user) throws MessageException {
        user.setStatus(0);//未激活
        String code = UUIDUtils.getUUID()+UUIDUtils.getUUID();
        user.setCode(code);
        user.setIcon("moren.jpg");
        user.setCreatetime(new Date());
        mailutils.sendMail(user.getEmail(), user.getName(), code,"reg");
        userMapper.insert(user);
    }
    
    /**
     * update the user information selectively
     */
    @Override
    public void updateUserSelective(User user) {
        user.setUpdatetime(new Date());
        userMapper.updateByPrimaryKeySelective(user);
        
    }
    /**
     * find the user by the unique code 
     * in order to activate the user account
     */
    @Override
    public User findUserByCode(String code) {
        
        return userMapper.findUserByCode(code);
    }
    
    /**
     * find the user by using the id
     */
    @Override
    public User findUserById(Long id) {
        return userMapper.selectByPrimaryKey(id);
    }
    /**
     * update the full user information
     */
    @Override
    public void updateUser(User user) {
        user.setUpdatetime(new Date());
        userMapper.updateByPrimaryKey(user);
        
    }
    /**
     * find the user information containing the reward info by the user id
     */
    @Override
    public UserWithReward findUserWithRewardById(Long id) {
        // TODO Auto-generated method stub
        return userMapper.findUserWithRewardById(id);
    }
    /**
     * update the reward information of the user
     */
    @Override
    public void updateReward(Reward reward) {
        reward.setUpdateTime(new Date());
        userMapper.updateReward(reward);
        
    }
    /**
     * delete one reward info from the user
     */
    @Override
    public void deleteReward(Reward reward) {
        userMapper.deleteReward(reward.getId());
        
    }
    /**
     * add one reward info to the user
     */
    @Override
    public void addReward(Reward reward) {
        reward.setCreateTime(new Date());
        userMapper.addReward(reward);
        
    }
    /**
     * find the users according to their role
     *  1. the users whose role == 1 are the instructors
     *  2. the users whose role == 2 are the players
     *  3. the users whose role ==3 are the administrators
     */
    @Override
    public List<User> findUserByRole(long role) {
        return userMapper.findUserByRole(role);
    }
    /**
     * Find all instructors
     */
    @Override
    public List<User> findTrainer() {
        Example example = new Example(User.class);
        example.createCriteria().andNotEqualTo("role", 2L);
        
        
        return userMapper.selectByExample(example);
    }
    /**
     * send the password recover email with the reseting code
     */
    @Override
    public void sendRecoverEmail(User user) throws MessageException {
        String code = UUIDUtils.getUUID();
        userMapper.insertRecoverCode(user.getId(),code);
        mailutils.sendMail(user.getEmail(), user.getName(), code,"rec");
    }
    
    /**
     * find the user by using the reseting code
     */
    @Override
    public User findUserbyRecoverCode(String code) {
        
        return userMapper.findUserByRecoverCode(code);
    }

    
    
    
    

}
