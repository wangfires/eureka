package com.baizhi.dao;


import com.baizhi.entity.Area;

import java.util.List;

public interface AreaDao {
    List<Area> findByCityCode(String cityCode);
}
