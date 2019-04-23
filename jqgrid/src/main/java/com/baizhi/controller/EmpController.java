package com.baizhi.controller;

import com.baizhi.entity.Dept;
import com.baizhi.entity.Emp;
import com.baizhi.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("emp")
public class EmpController {
    @Autowired
    private EmpService empService;
    @RequestMapping("findDept")
    @ResponseBody
    public void findALl(HttpServletResponse response) throws IOException {
        StringBuilder sb =  new StringBuilder();
        sb.append("<select>");
        List<Dept> depts = empService.findAll();
        //遍历所有部门信息
        for (Dept dept : depts) {
            sb.append("<option value=\"").append(dept.getId()).append("\">")
                    .append(dept.getName()).append("</option>");
        }
        sb.append("</select>");
        response.setContentType("text/html;charset=UTF-8");
        response.getWriter().print(sb.toString());

    }
    @RequestMapping("edit")
    @ResponseBody
    public void edit(Emp emp,String oper){
        if("add".equals(oper)){
            empService.add(emp);
        }if("edit".equals(oper)){
            empService.update(emp);
        }else if("del".equals(oper)){
            empService.delete(emp.getId());
        }
    }
    @RequestMapping("findAll")
    @ResponseBody
    public Map<String,Object> findAll(Integer page,Integer rows){
        HashMap<String,Object> result = new HashMap<>();
        Long totals=empService.findTotals();
        result.put("page",page);
        Long totalPage=totals%rows==0?totals/rows:totals/rows+1;
        result.put("total",totalPage);
        result.put("records",totals);
        Integer start= (page-1)*rows;
        result.put("rows",empService.findByPage(start,rows));
        return result;
    }

}
