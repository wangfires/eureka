package com.baizhi.dao;

import com.baizhi.entity.ProductInfo;
import java.util.List;

public interface ProductInfoMapper {
    void update(String id);

    ProductInfo selectByPrimaryKey(String productId);
    List<ProductInfo> findBytype(Integer type);
    List<ProductInfo> selectAll();

}