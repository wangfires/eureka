package com.baizhi.action;

import com.baizhi.entity.User;
import com.baizhi.service.UserService;

public class UserAction {
    private UserService us;
    private User user;
    private String message;

    public UserService getUs() {
        return us;
    }

    public void setUs(UserService us) {
        this.us = us;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String login(){

        try{
            user = us.findByName(user.getUsername(), user.getPassword());
            return "ok";
        }catch (Exception e){
            message=e.getMessage();
            System.out.println(message);
            return "error";
        }

    }
}
