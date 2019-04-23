package com.baizhi.service.Impl;

import com.baizhi.dao.CityDao;
import com.baizhi.entity.City;
import com.baizhi.service.CityService;
import com.baizhi.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.ArrayList;
import java.util.List;

public class CityServiceImpl implements CityService {
    @Override
    public List<City> findCity(String provinceCode) {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        CityDao cityDao = sqlSession.getMapper(CityDao.class);
        List<City> list = new ArrayList<City>();
        try{
            list=cityDao.findByProvinceCode(provinceCode);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            MybatisUtil.close();
        }
        return list;
    }
}
