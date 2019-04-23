package com.baizhi.service;

public class ClazzServiceImpl implements CLazzService{

    @Override
    public void save(String name) {
        System.out.println("添加一个：name"+name);
    }

    @Override
    public void delete(String name) {
        System.out.println("删除一个：name"+name);
    }

    @Override
    public void update(String name) {
        System.out.println("修改一个：name"+name);
    }

    @Override
    public String find(String name) {
        System.out.println("查询一个：name"+name);
        return name;
    }
}
