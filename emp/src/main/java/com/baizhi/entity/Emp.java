package com.baizhi.entity;


import java.util.Date;
import java.util.List;

public class Emp {
    private String id;
    private String name;
    private Integer age;
    private Date bir;
    private Double salary;
    private List<Tag> tags;


    public Emp() {
    }

    public Emp(String id, String name, Integer age, Date bir, Double salary, List<Tag> tags) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.bir = bir;
        this.salary = salary;
        this.tags = tags;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", bir=" + bir +
                ", salary=" + salary +
                ", tags=" + tags +
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

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }
}
