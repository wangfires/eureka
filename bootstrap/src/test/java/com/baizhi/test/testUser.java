package com.baizhi.test;

import com.baizhi.dao.UserDao;
import com.baizhi.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:spring.xml")
public class testUser {
    @Autowired
    private UserDao userDao;
    @Test
    public void add(){
        User user= new User("2","wangwang","123456",new Date(),"65487195312");
        userDao.add(user);
        System.out.println("添加成功！");

    }
    @Test
    public void delete(){
        userDao.delete("2");
        System.out.println("删除成功");
    }
    @Test
    public void update(){
        User user= new User("2","wangwang123","123456",new Date(),"65487195312");
        userDao.update(user);
    }
    @Test
    public void findOne(){
        User one = userDao.findOne("1");
        System.out.println(one);
    }
    @Test
    public void findByPage(){
        List<User> w = userDao.findByPage("w", null, 0, 2);
        System.out.println(w);
    }
    @Test
    public void find(){
        Long w = userDao.findTotals("w", null);
        System.out.println(w);
    }
}
