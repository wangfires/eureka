package com.baizhi.service;

import com.baizhi.entity.User;

public interface UserService {
    User findByName(String name,String password);
}
