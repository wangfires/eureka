package com.baizhi.controller;

import com.baizhi.entity.Files;
import com.baizhi.service.FilesService;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
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
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("file")
public class FIlesController {
    @Autowired
    private FilesService filesService;
    @RequestMapping("addFile")
    public String addFile(HttpServletRequest request, MultipartFile aaa) throws IOException {
        Date date1 = new Date();
        String path="/files/"+new SimpleDateFormat("yyyy-MM-dd").format(date1);
        String realPath = request.getSession().getServletContext().getRealPath(path);
        System.out.println(realPath);
        File f = new File(realPath);
        if(!f.exists()){
            f.mkdirs();
        }
        String s = UUID.randomUUID().toString();
        aaa.transferTo(new File(realPath+"/"+s+"."+FilenameUtils.getExtension(aaa.getOriginalFilename())));
        Files files = new Files();
        files.setNum(0);
        files.setOldname(aaa.getOriginalFilename());
        files.setType(aaa.getContentType());
        files.setSize(aaa.getSize());

        Date date = new Date();
//        User login= (User) request.getSession().getAttribute("login");
//        login.setId("111");
//        System.out.println(login);
//        login.setId(login.getId());

        files.setUserid("111");
        files.setPath("files/"+new SimpleDateFormat("yyyy-MM-dd").format(date));

        files.setSuffix(FilenameUtils.getExtension(aaa.getOriginalFilename()));
        files.setNewname(s+"."+files.getSuffix());
        System.out.println(files);
        filesService.addFile(files);
        return "redirect:/file/findAll";
    }
    @RequestMapping("findAll")
    public String findAll(HttpServletRequest request){
//        User login= (User) request.getSession().getAttribute("login");
//        login.setId("111");
        List<Files> list = filesService.findAll("111");
        request.setAttribute("list",list);
        System.out.println(list);
        return "findAll";
    }
    @RequestMapping("download")
    public String download(String id){
        filesService.updateNum(id);
        return "redirect:/file/findAll";
    }
    @RequestMapping("/down")
    public void download(String path,String newname,String id,HttpServletRequest request, HttpServletResponse response) throws IOException {
        //0.根据相对路径获取绝对路径
        String realPath = request.getSession().getServletContext().getRealPath(path);
        //1.根据获取的文件名读取指定目录中文件
        FileInputStream is = new FileInputStream(new File(realPath, newname));

        //1.5 指定浏览器以附件形式下载  inline: 默认值 在线打开  attachment: 附件
        if(id!=null) {
            response.setHeader("content-disposition", "attachment;fileName=" + URLEncoder.encode(newname, "UTF-8"));
            filesService.updateNum(id);
        }else{
            response.setHeader("content-disposition", "inline;fileName=" + URLEncoder.encode(newname, "UTF-8"));
        }
        //1.8动态获取文件类型
        String extension = FilenameUtils.getExtension(newname);//获取文件名后缀 没有"."
        String contentType = request.getSession().getServletContext().getMimeType("."+extension);
        System.out.println("动态获取文件类型: "+contentType);
        response.setContentType(contentType);

        //2.获取响应输出流
        ServletOutputStream os = response.getOutputStream();
        //3.文件拷贝   1028
        int len = 0;
        byte[] b = new byte[1024];
        while (true){
            len = is.read(b);
            if (len==-1)break;
            os.write(b,0,len);
        }
        is.close();
        os.close();
    }
    @RequestMapping("remove")
    public String remove(String id,String path,String newname,HttpServletRequest request){
        String realPath = request.getSession().getServletContext().getRealPath(path+"/"+newname);
            File file = new File(realPath);
        System.out.println(realPath);
        System.out.println(path+"/"+newname);
        System.out.println("111"+file.isFile());
        if(file.isFile()) {
            file.delete();
        }
        filesService.deleteFile(id);
        return "redirect:/file/findAll";
    }

}
