package com.baizhi.service;

import com.baizhi.dao.UserDao;
import com.baizhi.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    @Override

    public void save(User user) {
        user.setId(UUID.randomUUID().toString());
        userDao.add(user);
    }

    @Override
    @Transactional
    public User login(String username, String password) {
        User login=userDao.login(username);
        if(login==null){
            throw new RuntimeException("该账号不存在！！");
        }else {
            if (!password.equals(login.getPassword())){
                throw new RuntimeException("密码不正确！！！");
            }
        }
        return login;
    }
}
