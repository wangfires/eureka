package com.baizhi.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class User {
    private String id;
    private String name;
   private String password;
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
   private @DateTimeFormat(pattern = "yyyy-MM-dd") Date bir;
   private String phone;

    public User() {
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", bir=" + bir +
                ", phone='" + phone + '\'' +
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getBir() {
        return bir;
    }

    public void setBir(Date bir) {
        this.bir = bir;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public User(String id, String name, String password, Date bir, String phone) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.bir = bir;
        this.phone = phone;
    }
}
