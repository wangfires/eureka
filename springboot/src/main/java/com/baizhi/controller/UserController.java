package com.baizhi.controller;

import com.baizhi.entity.User;
import com.baizhi.service.UserService;
import com.baizhi.util.ImageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;

@Controller
@RequestMapping("user")

public class UserController {
    @Autowired
    private UserService userService;
@RequestMapping("save")
    public String add(User user,String code,HttpServletRequest request){
    Object code1 = request.getSession().getAttribute("code");
    if (!code1.equals(code)){
        String message ="验证码不正确!!!";
        request.getSession().setAttribute("message",message);
        return "login";
    }
        userService.save(user);
        return "login";
}
@RequestMapping("login")

    public String login(String code,User user, HttpServletRequest request, HttpServletResponse response){


    try {
        User login = userService.login(user.getUsername(), user.getPassword());
        request.getSession().setAttribute("login",login);
        return "redirect:/emp/findAll";
    }catch (Exception e){
        String message=e.getMessage();
        response.setContentType("text/html;charset=utf-8");
        request.setAttribute("message",message);
        return "login";
    }
}
    @RequestMapping("getImage")
    public void getImage(HttpSession session, HttpServletResponse response) throws IOException {
        char[] char1 = ImageUtil.getRandomChar();
        String code =String.copyValueOf(char1);

        BufferedImage image = ImageUtil.getImage(char1);
        ServletOutputStream outputStream = response.getOutputStream();
        ImageIO.write(image, "png", outputStream);
        outputStream.close();
        session.setAttribute("code", code);
    }
}
