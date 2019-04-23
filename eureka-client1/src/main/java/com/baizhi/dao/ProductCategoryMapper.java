package com.baizhi.dao;

import com.baizhi.entity.ProductCategory;
import java.util.List;

public interface ProductCategoryMapper {

    ProductCategory findBytype(Integer type);
    ProductCategory selectByPrimaryKey(Integer categoryId);

    List<ProductCategory> selectAll();


}