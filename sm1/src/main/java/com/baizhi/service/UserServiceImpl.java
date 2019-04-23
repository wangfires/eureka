package com.baizhi.service;

import com.baizhi.dao.UserDao;

public class UserServiceImpl implements UserService {
  private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public void delete(String id) {
        userDao.delete(id);

    }
}
