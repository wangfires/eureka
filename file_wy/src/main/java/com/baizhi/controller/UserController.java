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
    @RequestMapping("login")
    public String login(HttpServletRequest request, User user){
        try {
            User login = userService.login(user);
            request.getSession().setAttribute("login",login);
            return "redirect:/file/findAll";
        }catch (Exception e){
            String message =e.getMessage();
            request.setAttribute("message",message);
            return "login";
        }
    }
    @RequestMapping("getImage")
    public void getImage(HttpSession session, HttpServletResponse response) throws IOException {
        char[] char1 = com.baizhi.util.ImageUtil.getRandomChar();
        String code =String.copyValueOf(char1);
        session.setAttribute("code", code);
        BufferedImage image = ImageUtil.getImage(char1);
        ServletOutputStream outputStream = response.getOutputStream();
        ImageIO.write(image, "png", outputStream);
        outputStream.close();
    }
}
