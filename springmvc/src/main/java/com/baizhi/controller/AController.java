package com.baizhi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("A")
public class AController {
    @RequestMapping("hello")
    public String hello(){
        System.out.println("hello!!!!!");
        return "index";
    }
}
