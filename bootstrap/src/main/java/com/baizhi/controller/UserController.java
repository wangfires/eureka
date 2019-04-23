package com.baizhi.controller;

import com.baizhi.entity.User;
import com.baizhi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@Scope("prototype")
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService userService;
    @RequestMapping("save")
    @ResponseBody
    public String save(User user){
        System.out.println(user);
        String message;
        try {
            userService.add(user);
            message="success";
        }catch (Exception e){
            message="error";
        }

    return message;
    }
    @RequestMapping("findOne")
    @ResponseBody
    public User findOne(String id){

        return userService.findOne(id);
    }
    @RequestMapping("update")
    @ResponseBody
    public String update(User user){
        String message;
        try {
            System.out.println(user);
            userService.update(user);

            return message="success";
        }catch (Exception e){
            return message="error";
        }
    }
    @ResponseBody
    @RequestMapping("findByPage")
    public Map<String,Object> find(Integer page,Integer rows,String name,String phone){
        page = page==null?1:page;
        rows = rows==null?2:rows;
        Map<String,Object> map= new HashMap<String, Object>();
        List<User> users=userService.findByPage(name,phone,(page-1)*rows,rows);
        Long totals=userService.findTotals(name,phone);
        Long totalPage=totals%rows==0?totals/rows:totals/rows+1;
        map.put("users",users);
        map.put("totalPage",totalPage);
        map.put("page",page);
        map.put("rows",rows);
        return map;
    }
    @ResponseBody
    @RequestMapping("remove")
    public String remove(String id){
        String message;
        try {
            userService.delete(id);
            return message= "success";
        }catch (Exception e){
            return message="error";
        }

    }


}
