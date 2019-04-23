package com.baizhi.service;

import com.baizhi.entity.User;

public interface UserService {
    User login(String username, String password);
}
