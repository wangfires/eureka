package com.baizhi.dao;

import com.baizhi.entity.Dept;
import com.baizhi.entity.Emp;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EmpDao {
    void add(Emp emp);
    void delete(String id);
    void update(Emp emp);
    List<Emp> findByPage(@Param("start") Integer start, @Param("rows") Integer rows);
    Long findTotals();
    List<Dept> findAll();
}
