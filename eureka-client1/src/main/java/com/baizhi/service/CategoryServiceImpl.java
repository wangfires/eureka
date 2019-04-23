package com.baizhi.service;

import com.baizhi.dao.ProductCategoryMapper;
import com.baizhi.entity.ProductCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private ProductCategoryMapper productCategoryMapper;

    @Override
    public ProductCategory findByType(Integer type) {
        return productCategoryMapper.findBytype(type);
    }
}
