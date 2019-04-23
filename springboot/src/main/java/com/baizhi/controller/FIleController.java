package com.baizhi.controller;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;

@Controller
@RequestMapping("file")
public class FIleController {
    @RequestMapping("up")
    public String add(MultipartFile aaa, HttpServletRequest request) throws IOException {
        System.out.println("文件原始名称："+aaa.getOriginalFilename());
        System.out.println("文件类型："+aaa.getContentType());
        String realPath = request.getSession().getServletContext().getRealPath("/upload");
        System.out.println("通过相对路径获取的绝对路径："+realPath);
        //将文件放入服务器指定位置
        aaa.transferTo(new File(realPath+"/"+aaa.getOriginalFilename()));
        return "file";
    }
    @RequestMapping("down")
    public void aaa(String name, HttpServletRequest request, HttpServletResponse response) throws IOException {
        //根据相对路径获取绝对路径
        String realPath = request.getSession().getServletContext().getRealPath("/upload");
        //根据获取的文件名读取指定目录文件
        FileInputStream fis = new FileInputStream(new File(realPath, name));
        //指定浏览器以附件形式下载
        response.setHeader("content-disposition","attachment;fileName="+ URLEncoder.encode(name,"utf-8"));
        //动态获取文件类型
        String extension = FilenameUtils.getExtension(name);
        String mimeType = request.getSession().getServletContext().getMimeType("." + extension);
        System.out.println("动态获取文件类型："+mimeType);
        ServletOutputStream os = response.getOutputStream();
        IOUtils.copy(fis,os);
        fis.close();
        os.close();
    }
}
