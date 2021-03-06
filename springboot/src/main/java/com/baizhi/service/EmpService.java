package com.baizhi.service;

import com.baizhi.entity.Emp1;

import java.util.List;

public interface EmpService {
    void add(Emp1 emp);
    void delete(String id);
    void update(Emp1 emp);
    List<Emp1> findAll();
    Emp1 findOne(String id);
}
