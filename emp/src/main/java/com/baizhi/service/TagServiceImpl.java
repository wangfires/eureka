package com.baizhi.service;

import com.baizhi.dao.TagDao;
import com.baizhi.entity.Tag;

import java.util.List;
import java.util.UUID;

public class TagServiceImpl implements TagService {
    private TagDao tagDao;

    public void setTagDao(TagDao tagDao) {
        this.tagDao = tagDao;
    }

    public void addTag(Tag tag) {
        tag.setId(UUID.randomUUID().toString());
        tag.setCount(0);
        tagDao.addTag(tag);
    }

    public void delete(String id) {
        tagDao.deleteTag(id);
    }

    public List<Tag> findAll() {

        return tagDao.findAll();
    }

    @Override
    public void addET(String empid, String tagid) {
        tagDao.addET(empid,tagid);

    }

    @Override
    public void updateCount(String id) {
        tagDao.updateCount(id);
    }

    @Override
    public void deleteET(String empid) {
        tagDao.deleteET(empid);
    }

    @Override
    public Integer findNumber(String tagid) {
        return tagDao.findNumber(tagid);
    }

    @Override
    public void updateTag(Tag tag) {
        tagDao.updateTag(tag);
    }

}
