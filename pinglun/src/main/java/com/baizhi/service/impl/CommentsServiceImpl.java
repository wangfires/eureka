package com.baizhi.service.impl;

import com.baizhi.dao.CommentsDao;
import com.baizhi.entity.Comments;
import com.baizhi.service.CommentsService;
import com.baizhi.util.MybatisUtil;

import java.util.List;

public class CommentsServiceImpl implements CommentsService {
    @Override
    public List<Comments> findAll() {
        CommentsDao commentsDao = MybatisUtil.getSqlSession().getMapper(CommentsDao.class);
        List<Comments> list = commentsDao.findAll();
        MybatisUtil.close();
        return list;
    }

    @Override
    public void saveComments(Comments comments) {
        CommentsDao commentsDao = MybatisUtil.getSqlSession().getMapper(CommentsDao.class);
        try {
            commentsDao.addComments(comments);
            MybatisUtil.commit();
        }catch (Exception e){
            e.printStackTrace();
            MybatisUtil.rollback();
        }finally{
            MybatisUtil.close();
        }
    }

    @Override
    public void update(String id) {
        CommentsDao commentsDao = MybatisUtil.getSqlSession().getMapper(CommentsDao.class);
        try {
            commentsDao.update(id);
            MybatisUtil.commit();
        }catch (Exception e){
            e.printStackTrace();
            MybatisUtil.rollback();
        }finally{
            MybatisUtil.close();
        }
    }
    }

