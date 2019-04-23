package com.baizhi.service;

import com.baizhi.dao.EmpDao;
import com.baizhi.entity.Emp1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;
@Service
@Transactional
public class EmpServiceImpl implements EmpService {

    @Autowired
    private EmpDao empDao;
    @Override
    @Transactional
    public void add(Emp1 emp) {
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
    public void update(Emp1 emp) {
        empDao.update(emp);
    }

    @Override
    @Transactional
    public List<Emp1> findAll() {
        return empDao.findAll();
    }

    @Override
    @Transactional
    public Emp1 findOne(String id) {
        return empDao.findOne(id);
    }
}
