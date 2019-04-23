package com.baizhi.service;

import com.baizhi.entity.Dept;
import com.baizhi.entity.Emp;

import java.util.List;

public interface EmpService {
    void add(Emp emp);
    void delete(String id);
    void update(Emp emp);
    List<Emp> findByPage(Integer start,Integer rows);
    Long findTotals();
    List<Dept> findAll();
}
