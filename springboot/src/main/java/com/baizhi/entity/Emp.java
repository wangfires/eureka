package com.baizhi.entity;

import java.util.Date;

public class Emp {
    private String id ;
    private String name;
    private Integer age;
    private Date bir;
    private Double salary;
    private String deptid;

    public Emp() {
    }

    @Override
    public String toString() {
        return "Emp{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", bir=" + bir +
                ", salary=" + salary +
                ", deptid='" + deptid + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getBir() {
        return bir;
    }

    public void setBir(Date bir) {
        this.bir = bir;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public String getDeptid() {
        return deptid;
    }

    public void setDeptid(String deptid) {
        this.deptid = deptid;
    }

    public Emp(String id, String name, Integer age, Date bir, Double salary, String deptid) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.bir = bir;
        this.salary = salary;
        this.deptid = deptid;
    }
}
