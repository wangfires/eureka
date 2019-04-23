package com.baizhi.service;

import com.baizhi.dao.FilesDao;
import com.baizhi.entity.Files;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service("filesService")
public class FilesServiceImpl implements FilesService{
    @Autowired
    private FilesDao filesDao;

    @Override
    @Transactional
    public void addFile(Files files) {
        files.setId(UUID.randomUUID().toString());

        filesDao.addFile(files);
    }

    @Override
    @Transactional
    public void deleteFile(String id) {
        filesDao.deleteFile(id);
    }

    @Override
    @Transactional
    public void updateNum(String id) {
        filesDao.updateNum(id);
    }

    @Override
    public List<Files> findAll(String userid) {
        return filesDao.findAll(userid);
    }
}
