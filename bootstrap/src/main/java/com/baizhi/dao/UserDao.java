package com.baizhi.dao;

import com.baizhi.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserDao {
    void add(User user);
    void delete(String id);
    void update(User user);
    User findOne(String id);
    List<User> find(@Param("name") String name, @Param("phone") String phone);
    List<User> findByPage(@Param("name") String name, @Param("phone") String phone,@Param("start") Integer start,@Param("rows") Integer rows);
    Long findTotals(@Param("name") String name, @Param("phone") String phone);
}
