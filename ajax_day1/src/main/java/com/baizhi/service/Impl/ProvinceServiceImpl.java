package com.baizhi.service.Impl;

import com.baizhi.dao.ProvinceDao;
import com.baizhi.entity.Province;
import com.baizhi.service.ProvinceService;
import com.baizhi.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.ArrayList;
import java.util.List;

public class ProvinceServiceImpl implements ProvinceService {
    @Override
    public List<Province> findProvince() {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        ProvinceDao provinceDao = sqlSession.getMapper(ProvinceDao.class);
        List<Province> list = new ArrayList<Province>();
        try{
            list=provinceDao.findAll();
        }catch (Exception e){
            e.printStackTrace();
        }finally{
            MybatisUtil.close();
        }
        return list;
    }
}
