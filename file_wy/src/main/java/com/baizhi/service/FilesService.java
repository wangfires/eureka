package com.baizhi.service;

import com.baizhi.entity.Files;

import java.util.List;

public interface FilesService {
    void addFile(Files files);
    void deleteFile(String id);
    void updateNum(String id);
    List<Files> findAll(String userid);
}
