package com.baizhi.service;

import com.baizhi.entity.Emp;
import com.baizhi.entity.User;

import java.util.List;

public interface UserService {
    List<User> findAll();


    void delete(User user);


    void update( User user);


    User findOne(User user);

    void add(User user);
}


