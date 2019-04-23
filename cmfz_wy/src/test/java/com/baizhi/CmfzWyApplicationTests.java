package com.baizhi;

import com.baizhi.dao.ChapterMapper;
import com.baizhi.entity.Chapter;
import com.baizhi.entity.Slideshow;
import com.baizhi.service.FrontService;
import com.baizhi.service.SlideshowService;
import com.baizhi.util.MessageUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CmfzWyApplicationTests {
    @Autowired
    private SlideshowService slideshowService;
    @Autowired
    private ChapterMapper chapterMapper;
    @Autowired
    private FrontService frontService;

//    public void contextLoads() {
////        Slideshow slideshow = new Slideshow(null,"111","111" +
////                "+11","321",null,null);
////        slideshowService.add(slideshow);
//    }
//    @Test
//    public void delete(){
//        slideshowService.delete("5f11c50e-1bb7-47be-921d-9960287840d3");
//    }
//    @Test
//    public void update(){
//       // Slideshow slideshow = new Slideshow("1","22","22","22",0,new Date());
//        //slideshowService.update(slideshow);
//
//    }
    @Test
    public void findAll(){
        List<Slideshow> all = slideshowService.findAll();
    }
//    @Test
//    public void findBypage(){
//        PageInfo<Slideshow> byPage = slideshowService.findByPage(0, 2);
//        System.out.println(byPage);
//    }
    @Test
    public void findAllc(){
        List<Chapter> chapters = chapterMapper.findAll();
        System.out.println(chapters);
    }
    @Test
    public void setSlideshowService(){
        chapterMapper.updatedown("07e9f4b5-c1a7-4c04-a292-db1c3ef527df");
    }
    @Test
    public void aaa(){
        Map<String, Object> all = frontService.getFirstPage("111", "all");
        System.out.println(all);
    }
    @Test
    public void get() {
        MessageUtil.getMessage("18438610399");
    }


}
