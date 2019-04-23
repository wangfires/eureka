package com.baizhi.service;

import com.baizhi.entity.Comments;

import java.util.List;

public interface CommentsService {
    List<Comments> findAll();
    void saveComments(Comments comments);
    void update(String id);
}
