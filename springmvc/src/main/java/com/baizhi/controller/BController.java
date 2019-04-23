package com.baizhi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
@RequestMapping("B")
public class BController {
    @RequestMapping("aaa")
    public String aaa(){
        System.out.println("b控制器");
        return "redirect:/A/hello";
    }
}
