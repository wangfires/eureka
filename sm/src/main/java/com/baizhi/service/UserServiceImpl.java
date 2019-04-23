package com.baizhi.service;

import com.baizhi.dao.UserDao;
import com.baizhi.entity.User;

public class UserServiceImpl implements UserService {
    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void save(User user) {
        user.setId("666");
        user.setName("wangwang");
        userDao.save(user);
    }
}
