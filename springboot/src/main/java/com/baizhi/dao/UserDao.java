package com.baizhi.dao;

import com.baizhi.entity.User;

public interface UserDao {
    void add(User user);
    User login(String name);
}
