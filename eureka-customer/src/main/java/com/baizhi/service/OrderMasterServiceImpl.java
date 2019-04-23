package com.baizhi.service;

import com.baizhi.dao.OrderMasterMapper;
import com.baizhi.entity.OrderMaster;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class OrderMasterServiceImpl implements OrderMasterService {
    @Autowired
    private OrderMasterMapper orderMasterMapper;

    @Override
    public void add(OrderMaster orderMaster) {
        orderMaster.setCreateTime(new Date());
        orderMaster.setUpdateTime(new Date());
        orderMaster.setOrderStatus("已生成");
        orderMaster.setPayStayus("未付款");
        orderMasterMapper.insertSelective(orderMaster);
    }
}
