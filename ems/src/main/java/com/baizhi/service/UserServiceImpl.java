package com.baizhi.service;

import com.baizhi.dao.UserDao;
import com.baizhi.entity.Emp;
import com.baizhi.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Resource
    private UserDao userDao;
    @Override
    public List<User> findAll() {
        return userDao.selectAll();
    }

    @Override
    public void delete(User user) {
        userDao.delete(user);
    }

    @Override
    public void update(User user) {
        userDao.updateByPrimaryKeySelective(user);
    }

    @Override
    public User findOne(User user) {
        return userDao.selectOne(user);
    }

    @Override
    public void add(User user) {
        user.setId(UUID.randomUUID().toString());
        userDao.insert(user);
    }
}
