package com.baizhi.dao;

import com.baizhi.entity.Emp;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EmpDao {
    void addEmp(Emp emp);
    void deleteEmp(String id);
    void updateEmp(Emp emp);
    Emp selectById(String id);
    List<Emp> findAll();
    List<Emp> findByPage(@Param("begin") Integer begin,@Param("pageSize") Integer pageSize);
    Integer findCount();
}
