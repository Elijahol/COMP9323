package com.vport.system.mapper;

import com.github.abel533.mapper.Mapper;
import com.vport.system.pojo.User;

public interface UserMapper extends Mapper<User>{
    User findUserByEmailAndPassword(User user);

    User findUserByCode(String code);

    /*void insertTrainer(Long id);

    void insertPlayer(Long id);*/
}
