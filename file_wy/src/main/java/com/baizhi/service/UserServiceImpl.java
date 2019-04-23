package com.baizhi.service;

import com.baizhi.dao.UserDao;
import com.baizhi.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    @Override
    public User login(User user) {
        User login = userDao.login(user.getUsername());
        if (login==null){
            throw new RuntimeException("该账户不存在！！！");
        }else{
            if(!user.getPassword().equals(login.getPassword())){
                throw new RuntimeException("密码不正确！！！");
            }else{
                return login;
            }
        }
    }
}
