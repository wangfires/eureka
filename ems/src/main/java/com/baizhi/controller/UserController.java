package com.baizhi.controller;

import com.baizhi.entity.User;
import com.baizhi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService service;
    @RequestMapping("login")
    public String login(User user){
        System.out.println(user);
        User userFromDb = service.findOne(user);
        if (userFromDb!=null){
            return "redirect:/emp/findAll";
        }else {
            return "redirect:/login.jsp";
        }
    }
    @RequestMapping("add")
    public String add(User user){
        service.add(user);
        return "redirect:/login.jsp";
    }
}
