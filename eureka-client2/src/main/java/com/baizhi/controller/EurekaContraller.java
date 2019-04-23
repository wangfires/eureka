package com.baizhi.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("aa")
public class EurekaContraller {
    @RequestMapping("aa")
    public String aa(String name){
        return "client2:"+name;
    }
}
