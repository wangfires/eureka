package com.baizhi.service;

import com.baizhi.dao.UserDao;
import com.baizhi.entity.User;
import org.apache.struts2.ServletActionContext;

public class UserServiceImpl implements UserService {
     private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public User findByName(String name,String password) {
        User user = userDao.findByName(name);
        if(user==null||"".equals(user)){
            throw new RuntimeException("账户不存在！！！");
        }else{
            if(!password.equals(user.getPassword())){
                throw new RuntimeException("密码不正确！！！");
            }else {
                ServletActionContext.getRequest().getSession().setAttribute("login",user);
            }
        }
        return user;
    }
}
