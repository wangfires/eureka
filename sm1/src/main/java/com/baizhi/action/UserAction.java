package com.baizhi.action;

import com.baizhi.service.UserService;
import com.baizhi.service.UserServiceImpl;
import com.opensymphony.xwork2.Action;

public class UserAction {
    private UserService us = new UserServiceImpl();

    public void setUs(UserService us) {
        this.us = us;
    }

    public String delete(){
        us.delete("666");
        return Action.SUCCESS;
    }
}
