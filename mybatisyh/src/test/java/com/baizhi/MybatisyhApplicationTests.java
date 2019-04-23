package com.baizhi;

import com.baizhi.dao.UserMapper;
import com.baizhi.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MybatisyhApplicationTests {
@Autowired
private UserMapper userMapper;
    @Test
    public void contextLoads() {
        List<User> users = userMapper.selectAll();
        System.out.println(users);
    }

}
