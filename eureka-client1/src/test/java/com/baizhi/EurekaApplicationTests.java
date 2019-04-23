package com.baizhi;

import com.baizhi.dao.ProductCategoryMapper;
import com.baizhi.dao.ProductInfoMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EurekaApplicationTests {
@Autowired
private ProductCategoryMapper productCategoryMapper;
@Autowired
private ProductInfoMapper productInfoMapper;
    @Test
    public void contextLoads() {


        System.out.println(productInfoMapper.findBytype(11));
    }
}
