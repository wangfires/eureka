package com.baizhi.dao;

import com.baizhi.entity.Comments;

import java.util.List;

public interface CommentsDao {
    List<Comments> findAll();
    void addComments(Comments comments);
    void update(String id);
}
