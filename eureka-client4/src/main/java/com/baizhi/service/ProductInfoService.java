package com.baizhi.service;

import com.baizhi.entity.ProductInfo;

import java.util.List;

public interface ProductInfoService {
    List<ProductInfo> findByType(Integer type);
    void update(String id);
    ProductInfo findOne(String id);
}
