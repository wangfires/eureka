package com.baizhi.service;

import com.baizhi.entity.ProductCategory;

public interface CategoryService {
    ProductCategory findByType(Integer type);
}
