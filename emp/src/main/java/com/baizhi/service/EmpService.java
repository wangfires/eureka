package com.baizhi.service;

import com.baizhi.entity.Emp;

import java.util.List;

public interface EmpService {
    void addEmp(Emp emp);
    void deleteEmp(String id);
    void updateEmp(Emp emp);
    Emp selectById(String id);
    List<Emp> findAll();
    List<Emp> findByPage(Integer pageNow,Integer pageSize);
    Integer findCount();
}
