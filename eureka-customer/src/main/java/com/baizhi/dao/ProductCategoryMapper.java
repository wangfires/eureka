package com.baizhi.dao;

import com.baizhi.entity.ProductCategory;
import java.util.List;

public interface ProductCategoryMapper {
    int deleteByPrimaryKey(Integer categoryId);

    int insert(ProductCategory record);

    ProductCategory selectByPrimaryKey(Integer categoryId);

    List<ProductCategory> selectAll();

    int updateByPrimaryKey(ProductCategory record);
}