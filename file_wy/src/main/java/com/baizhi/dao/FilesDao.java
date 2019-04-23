package com.baizhi.dao;

import com.baizhi.entity.Files;

import java.util.List;

public interface FilesDao {

    void addFile(Files files);
    List<Files> findAll(String userid);
    void deleteFile(String id);
    void updateNum(String id);
}
