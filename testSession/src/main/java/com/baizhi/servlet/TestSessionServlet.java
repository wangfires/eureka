package com.baizhi.servlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TestSessionServlet extends HttpServlet {
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        List<String> list = (List<String>) req.getSession().getAttribute("list");
        if (list==null){
            list=new ArrayList<String>();
            req.getSession().setAttribute("list",list);
        }
        list.add("hello");
        resp.getWriter().print("count:"+list.size());
        resp.getWriter().println(req.getSession().getId());
    }
}
