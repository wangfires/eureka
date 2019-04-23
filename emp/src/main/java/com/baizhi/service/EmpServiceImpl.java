package com.baizhi.service;

import com.baizhi.dao.EmpDao;
import com.baizhi.entity.Emp;

import java.util.List;

public class EmpServiceImpl implements EmpService {
    private EmpDao empDao;

    public void setEmpDao(EmpDao empDao) {
        this.empDao = empDao;
    }

    @Override
    public void addEmp(Emp emp) {

        empDao.addEmp(emp);
    }

    @Override
    public void deleteEmp(String id) {
        empDao.deleteEmp(id);
    }

    @Override
    public void updateEmp(Emp emp) {
        empDao.updateEmp(emp);
    }

    @Override
    public Emp selectById(String id) {

        return empDao.selectById(id);
    }

    @Override
    public List<Emp> findAll() {
        return empDao.findAll();
    }

    @Override
    public List<Emp> findByPage(Integer pageNow, Integer pageSize) {
            Integer begin=(pageNow-1)*pageSize;
        return empDao.findByPage(begin,pageSize);
    }

    @Override
    public Integer findCount() {
        return empDao.findCount();
    }
}
