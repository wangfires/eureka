package com.baizhi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import tk.mybatis.spring.annotation.MapperScan;

@EnableEurekaClient
@SpringBootApplication
@EnableFeignClients
@MapperScan(basePackages = "com.baizhi.dao")
public class EurekaCustomer {
    public static void main(String[] args) {
        SpringApplication.run(EurekaCustomer.class,args);
    }
}