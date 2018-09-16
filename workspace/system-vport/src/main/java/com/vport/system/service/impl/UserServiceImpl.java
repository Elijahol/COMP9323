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

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    
    @Autowired
    private MailUtils mailutils;
    
    
    @Override
    public User findByEmailandPassword(User user) {
        
        return userMapper.findUserByEmailAndPassword(user);
    }

    @Override
    public void register(User user) throws MessageException {
        user.setStatus(0);//未激活
        String code = UUIDUtils.getUUID()+UUIDUtils.getUUID();
        user.setCode(code);
        user.setCreatetime(new Date());
        mailutils.sendMail(user.getEmail(), user.getName(), code);
        userMapper.insert(user);
    }
    
    @Override
    public void updateUserSelective(User user) {
        user.setUpdatetime(new Date());
        userMapper.updateByPrimaryKeySelective(user);
        
    }

    @Override
    public User findUserByCode(String code) {
        
        return userMapper.findUserByCode(code);
    }

    @Override
    public User findUserById(Long id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public void updateUser(User user) {
        user.setUpdatetime(new Date());
        userMapper.updateByPrimaryKey(user);
        
    }

    @Override
    public UserWithReward findUserWithRewardById(Long id) {
        // TODO Auto-generated method stub
        return userMapper.findUserWithRewardById(id);
    }

    @Override
    public void updateReward(Reward reward) {
        reward.setUpdateTime(new Date());
        userMapper.updateReward(reward);
        
    }

    @Override
    public void deleteReward(Reward reward) {
        userMapper.deleteReward(reward.getId());
        
    }

    @Override
    public void addReward(Reward reward) {
        reward.setCreateTime(new Date());
        userMapper.addReward(reward);
        
    }

    @Override
    public List<User> findUserByRole(long role) {
        return userMapper.findUserByRole(role);
    }

   /* @Override
    public void addTrainer(User user) {
        userMapper.insertTrainer(user.getId());
        
    }

    @Override
    public void addPlayer(User user) {
        userMapper.insertPlayer(user.getId());
        
    }*/
    
    

}
