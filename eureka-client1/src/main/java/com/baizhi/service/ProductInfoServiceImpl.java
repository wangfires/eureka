package com.baizhi.service;

import com.baizhi.dao.ProductInfoMapper;
import com.baizhi.entity.ProductInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductInfoServiceImpl implements ProductInfoService {
    @Autowired
    private ProductInfoMapper productInfoMapper;
    @Override
    public List<ProductInfo> findByType(Integer type) {
        return productInfoMapper.findBytype(type);
    }

    @Override
    public void update(String id) {
        productInfoMapper.update(id);
    }

    @Override
    public ProductInfo findOne(String id) {
        return productInfoMapper.selectByPrimaryKey(id);
    }
}
