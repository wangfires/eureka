package com.baizhi.service;

import com.baizhi.dao.EmpMapper;
import com.baizhi.entity.Emp;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
@Service
@Transactional
public class EmpServiceImpl implements EmpService{
    @Resource
    private EmpMapper empMapper;
    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<Emp> findAll() {
        return empMapper.selectAll();
    }

    @Override
    public void delete(Emp emp) {
        empMapper.delete(emp);
    }

    @Override
    public void update(Emp emp) {
        empMapper.updateByPrimaryKeySelective(emp);
    }

    @Override
    public void add(Emp emp) {
        empMapper.insert(emp);
    }
}
