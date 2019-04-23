package com.baizhi.service;

import com.baizhi.entity.Cart;

public interface OrderDetailService {
    void save(Cart productInfo,String orderid);
}
