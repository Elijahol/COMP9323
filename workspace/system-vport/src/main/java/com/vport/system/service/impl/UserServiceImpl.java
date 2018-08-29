package com.vport.system.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.abel533.entity.Example;
import com.github.abel533.entity.Example.Criteria;
import com.vport.system.mapper.UserMapper;
import com.vport.system.pojo.User;
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
    public void register(User user) {
        user.setStatus(0);//未激活
        String code = UUIDUtils.getUUID()+UUIDUtils.getUUID();
        user.setCode(code);
        user.setCreatetime(new Date());
        mailutils.sendMail(user.getEmail(), user.getName(), code);
        userMapper.insert(user);
    }

    @Override
    public void updateUser(User user) {
        user.setUpdatetime(new Date());
        userMapper.updateByPrimaryKey(user);
        
    }
    
    

}
