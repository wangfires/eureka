package com.baizhi.service.impl;

import com.baizhi.dao.UserDao;
import com.baizhi.entity.User;
import com.baizhi.service.UserService;
import com.baizhi.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

public class UserServiceImpl implements UserService {
    @Override
    public User login(String username, String password) {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        User user = userDao.selectUser(username, password);
        MybatisUtil.close();
        return user;
    }
}
