package com.baizhi.service;

import com.baizhi.entity.User;

import java.util.List;

public interface UserService {
    void add(User user);
    void delete(String id);
    void update(User user);
    User findOne(String id);
    List<User> find(String name, String phone);
    List<User> findByPage(String name, String phone,Integer start,Integer rows);
    Long findTotals(String name,String phone);
}
