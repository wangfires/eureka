package com.baizhi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import tk.mybatis.spring.annotation.MapperScan;

@EnableEurekaClient
@SpringBootApplication
@EnableFeignClients
@EnableHystrix
@MapperScan(basePackages = "com.baizhi.dao")
public class EurekaClient1 {
    public static void main(String[] args) {
        SpringApplication.run(EurekaClient1.class,args);
    }
}

