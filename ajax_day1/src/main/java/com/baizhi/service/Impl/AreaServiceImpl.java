package com.baizhi.service.Impl;

import com.baizhi.dao.AreaDao;
import com.baizhi.entity.Area;
import com.baizhi.service.AreaService;
import com.baizhi.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.ArrayList;
import java.util.List;

public class AreaServiceImpl implements AreaService {
    @Override
    public List<Area> findArea(String cityCode) {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        AreaDao areaDao = sqlSession.getMapper(AreaDao.class);
        List<Area> list = new ArrayList<Area>();
        try{
            list=areaDao.findByCityCode(cityCode);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            MybatisUtil.close();
        }
        return list;
    }
}
