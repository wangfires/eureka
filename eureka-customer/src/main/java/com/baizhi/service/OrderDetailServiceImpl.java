package com.baizhi.service;

import com.baizhi.dao.OrderDetailMapper;
import com.baizhi.entity.Cart;
import com.baizhi.entity.OrderDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;
@Service
public class OrderDetailServiceImpl implements OrderDetailService {
    @Autowired
    private OrderDetailMapper orderDetailMapper;
    @Override
    public void save(Cart productInfo,String orderid) {
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setDetailId(UUID.randomUUID().toString());
        orderDetail.setProductQuantity(productInfo.getCount());
        orderDetail.setProductId(productInfo.getId());
        orderDetail.setCreateTime(productInfo.getCreatedate());
        orderDetail.setProdcutName(productInfo.getName());
        orderDetail.setProductIcon(productInfo.getIcon());
        orderDetail.setProductPrice(productInfo.getPrice());
        orderDetail.setUpdateTime(productInfo.getUpdatetime());
        orderDetail.setOrderId(orderid);
        orderDetailMapper.insertSelective(orderDetail);
    }
}
