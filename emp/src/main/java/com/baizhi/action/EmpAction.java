package com.baizhi.action;

import com.alibaba.fastjson.JSONObject;
import com.baizhi.entity.Emp;
import com.baizhi.entity.Tag;
import com.baizhi.service.EmpService;
import com.baizhi.service.TagService;
import com.opensymphony.xwork2.Action;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class EmpAction {


    private Integer number;

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    private Integer page;
    private Integer count;

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    private List<String> tagids;

    public List<String> getTagids() {
        return tagids;
    }

    public void setTagids(List<String> tagids) {
        this.tagids = tagids;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    private String id ;
    private Emp emp;
    private List<Emp> emps;
    private TagService ts;
    private List<Tag> tags;
    public TagService getTs() {
        return ts;
    }

    public void setTs(TagService ts) {
        this.ts = ts;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Emp getEmp() {
        return emp;
    }

    public void setEmp(Emp emp) {
        this.emp = emp;
    }

    public List<Emp> getEmps() {
        return emps;
    }

    public void setEmps(List<Emp> emps) {
        this.emps = emps;
    }

    public EmpService getEs() {
        return es;
    }

    public void setEs(EmpService es) {
        this.es = es;
    }

    private EmpService es;
    //-----------------------------------------------------------------------------------------------------------
    public String findAll(){

        for (Tag tag : ts.findAll()) {
            tag.setCount(ts.findNumber(tag.getId()));
            ts.updateTag(tag);
        }
        tags=ts.findAll();
        emps=es.findAll();
        return Action.SUCCESS;
    }
    public String saveEmp(){
        String empid= UUID.randomUUID().toString();
        emp.setId(empid);
        es.addEmp(emp);

        for (String tagid : tagids) {

            ts.addET(empid,tagid);
        }

        return Action.SUCCESS;
    }
    public String removeEmp(){
        es.deleteEmp(id);
        List<Tag> list=new ArrayList<Tag>();
        for(Tag tag:ts.findAll()){
            tag.setCount(ts.findNumber(tag.getId()));

            list.add(tag);

        }
        tags=list;
        return Action.SUCCESS;
    }
    public String updateEmp(){
        ts.deleteET(emp.getId());
        System.out.println(emp.getId());
        System.out.println(tagids);
        for (String tagid : tagids){
            ts.addET(emp.getId(),tagid);
        }
        es.updateEmp(emp);

        return Action.SUCCESS;
    }
    public String findOne() throws IOException {
        emp=es.selectById(id);
        System.out.println(emp);
        HttpServletResponse response = ServletActionContext.getResponse();
        response.setContentType("application/json;charset=utf-8");
        PrintWriter writer = response.getWriter();
        String s = JSONObject.toJSONString(emp);
        writer.write(s);
        return Action.NONE;
    }
    public String findByPage(){

        for(Tag tag:ts.findAll()){
            tag.setCount(ts.findNumber(tag.getId()));

            ts.updateTag(tag);
        }
        tags=ts.findAll();

        if(page==null){
            page=1;
        }
        emps = es.findByPage(page, 3);
        Integer c =es.findCount();
        if(c%3==0){
            count=c/3;
        }else{
            count=c/3+1;
        }
        System.out.println(count);
        return Action.SUCCESS;
    }
}
