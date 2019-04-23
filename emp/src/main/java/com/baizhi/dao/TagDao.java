package com.baizhi.dao;

import com.baizhi.entity.Tag;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TagDao {
    void addTag(Tag tag);
    void deleteTag(String id);
    List<Tag> findAll();
    void addET(@Param("empid") String empid, @Param("tagid") String tagid);
    void updateCount(String id);
    void updateTag(Tag tag);
    void deleteET(String empid);
    Integer findNumber(String tagid);
}
