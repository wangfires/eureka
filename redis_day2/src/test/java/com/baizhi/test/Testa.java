package com.baizhi.test;

import com.baizhi.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest(classes = Application.class)
@RunWith(SpringRunner.class)
public class Testa {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Test
    public void aa(){
        //stringRedisTemplate.opsForValue().set("clazz","150");
        String clazz = stringRedisTemplate.opsForValue().get("clazz");
        System.out.println(clazz);
    }
}
