package com.baizhi.dao;

import com.baizhi.entity.User;
import org.apache.ibatis.annotations.Param;

public interface UserDao {
    User selectUser(@Param("username") String username, @Param("password") String password);
}
