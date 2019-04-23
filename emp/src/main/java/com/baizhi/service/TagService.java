package com.baizhi.service;

import com.baizhi.entity.Tag;

import java.util.List;

public interface TagService {
   void addTag(Tag tag);
   void delete(String id);
   List<Tag> findAll();
   void addET(String empid,String tagid);
   void updateCount(String id);
   void deleteET(String empid);
   Integer findNumber(String tagid);
   void updateTag(Tag tag);
}
