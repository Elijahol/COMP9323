package com.vport.system.service;

import com.vport.system.pojo.User;

public interface UserService {
    User findByEmailandPassword(User user);
    void register(User user);
    void updateUser(User user);
}
