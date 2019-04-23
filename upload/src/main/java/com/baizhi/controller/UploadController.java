package com.baizhi.controller;

import org.apache.commons.io.FilenameUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;

@Controller
@RequestMapping("upload")
public class UploadController {
    @RequestMapping("upload")
    public String upload(HttpServletRequest request, MultipartFile aaa) throws IOException {

        System.out.println("文件的原始名称: "+aaa.getOriginalFilename());
        //通过当前项目中相对路径获取当前目录在服务器中绝对路径  /upload
        String realPath = request.getSession().getServletContext().getRealPath("/upload");
        System.out.println("通过相对获取的绝对路径: "+realPath );
        //将接受的文件放入服务器中指定位置
        aaa.transferTo(new File(realPath+"/"+aaa.getOriginalFilename()));

        return "index";
    }
    @RequestMapping("download")
    public void download(String fileName,HttpServletRequest request, HttpServletResponse response) throws IOException {
        //根据相对路径获取绝对路径
        String realPath = request.getSession().getServletContext().getRealPath("/upload");
        //根据获取的文件名读取指定目录文件
        FileInputStream fis = new FileInputStream(new File(realPath, fileName));
        //指定浏览器以附件形式下载 inline 默认值  在线打开 attachment：附件
        response.setHeader("content-disposition","attachment;fileNmae="+ URLEncoder.encode(fileName,"utf-8"));
        //动态获取文件类型
        String extension = FilenameUtils.getExtension(fileName);
        System.out.println(extension);
        String mimeType = request.getSession().getServletContext().getMimeType("." + extension);
        System.out.println("动态获取文件类型："+mimeType);
        response.setContentType(mimeType);
        //获取响应输出流
        ServletOutputStream os = response.getOutputStream();
        //文件拷贝
        int len=0;
        byte[] b =new byte[1024];
        while (true){
            len=fis.read(b);
            if(len==-1)break;
                os.write(b,0,len);

        }
        fis.close();
        os.close();


    }


}
