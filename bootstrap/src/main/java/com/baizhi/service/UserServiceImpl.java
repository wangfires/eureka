package com.baizhi.service;

import com.baizhi.dao.UserDao;
import com.baizhi.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    @Override
    @Transactional
    public void add(User user) {
        user.setId(UUID.randomUUID().toString());
        userDao.add(user);
    }

    @Override
    @Transactional
    public void delete(String id) {
        userDao.delete(id);
    }

    @Override
    @Transactional
    public void update(User user) {
        userDao.update(user);
    }

    @Override
    public User findOne(String id) {
        return userDao.findOne(id);
    }

    @Override
    public List<User> find(String name, String phone) {
        return userDao.find(name,phone);
    }

    @Override
    public List<User> findByPage(String name, String phone, Integer start, Integer rows) {
        return userDao.findByPage(name,phone,start,rows);
    }

    @Override
    public Long findTotals(String name, String phone) {
        return userDao.findTotals(name,phone);
    }
}
