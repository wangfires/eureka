package com.baizhi.action;

import com.alibaba.fastjson.JSONObject;
import com.baizhi.entity.Comments;
import com.baizhi.service.CommentsService;
import com.baizhi.service.impl.CommentsServiceImpl;
import com.opensymphony.xwork2.Action;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.UUID;

public class CommentsAction {
    private String content;
    private List<Comments> list;
    private String id;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<Comments> getList() {
        return list;
    }

    public void setList(List<Comments> list) {
        this.list = list;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    CommentsService cs = new CommentsServiceImpl();
    public String findAll(){
        list=cs.findAll();
        System.out.println(list);
        return Action.SUCCESS;
    }
    public String addContent() throws IOException {
        HttpServletResponse response = ServletActionContext.getResponse();
        response.setContentType("application/json;charset=utf-8");
        PrintWriter writer = response.getWriter();
        Comments comments = new Comments();
        comments.setId(UUID.randomUUID().toString());
        comments.setCount(1);
        comments.setUserId(UUID.randomUUID().toString());
        comments.setMatters(content);

        cs.saveComments(comments);

        String s = JSONObject.toJSONString(comments);
        writer.write(s);
        return Action.NONE;
    }
    public String updateCount() throws IOException {

        HttpServletResponse response = ServletActionContext.getResponse();
        response.setContentType("application/json;charset=utf-8");
        PrintWriter writer = response.getWriter();
        cs.update(id);
        return Action.NONE;
    }
}
