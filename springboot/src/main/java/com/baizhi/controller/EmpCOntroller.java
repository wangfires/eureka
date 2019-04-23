package com.baizhi.controller;

import com.baizhi.entity.Emp1;
import com.baizhi.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@RequestMapping("emp")
public class EmpCOntroller {
    @Autowired
    private EmpService empService;
    @RequestMapping("findAll")
    public String find(HttpServletRequest request, HttpServletResponse response){
        response.setContentType("text/html;charset=utf-8");
        List<Emp1> list=empService.findAll();
        request.setAttribute("list",list);
        return "emplist";
    }
    @RequestMapping("add")
    public String add(Emp1 emp){
        empService.add(emp);
        return "redirect:/emp/findAll";
    }
    @RequestMapping("del")
    public String del(String id){
        empService.delete(id);
        return "redirect:/emp/findAll";
    }
    @RequestMapping("findOne")
    public String findOne(String id,HttpServletRequest request){
        Emp1 emp = empService.findOne(id);
        request.setAttribute("emp",emp);
        return "updateEmp";
    }
    @RequestMapping("update")
    public String update(Emp1 emp){
        empService.update(emp);
        return "redirect:/emp/findAll";
    }
}
