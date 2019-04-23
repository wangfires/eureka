package com.baizhi.dao;

import com.baizhi.entity.ProductInfo;
import java.util.List;

public interface ProductInfoMapper {
    int deleteByPrimaryKey(String productId);

    int insert(ProductInfo record);

    ProductInfo selectByPrimaryKey(String productId);

    List<ProductInfo> selectAll();

    int updateByPrimaryKey(ProductInfo record);
}