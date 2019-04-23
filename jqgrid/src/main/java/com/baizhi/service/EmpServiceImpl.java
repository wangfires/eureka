package com.baizhi.service;

import com.baizhi.dao.EmpDao;
import com.baizhi.entity.Dept;
import com.baizhi.entity.Emp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
public class EmpServiceImpl implements EmpService {
    @Autowired
    private EmpDao empDao;
    @Override
    @Transactional
    public void add(Emp emp) {
        emp.setId(UUID.randomUUID().toString());
        empDao.add(emp);
    }

    @Override
    @Transactional
    public void delete(String id) {
        empDao.delete(id);
    }

    @Override
    @Transactional
    public void update(Emp emp) {
        empDao.update(emp);
    }

    @Override
    public List<Emp> findByPage(Integer start, Integer rows) {
        return empDao.findByPage(start,rows);
    }

    @Override
    public Long findTotals() {
        return empDao.findTotals();
    }

    @Override
    public List<Dept> findAll() {
        return empDao.findAll();
    }
}
