package com.baizhi.controller;

import com.baizhi.entity.Cart;
import com.baizhi.entity.OrderMaster;
import com.baizhi.entity.User;
import com.baizhi.service.OrderDetailService;
import com.baizhi.service.OrderMasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("order")
public class OrderController {
    @Autowired
    private HttpServletRequest request;
    @Autowired
    private OrderMasterService orderMasterService;
    @Autowired
    private OrderDetailService orderDetailService;
    @RequestMapping("save")
    public void save(){
        String id = UUID.randomUUID().toString();
        Double price=0.0;
        User u = (User) request.getSession().getAttribute("login");
        Map<String, Cart> cart = (Map<String, Cart>) request.getSession().getAttribute("cart");
        for (Map.Entry<String, Cart> entry : cart.entrySet()) {
            Cart value = entry.getValue();
            price=price+entry.getValue().getTotal();
            orderDetailService.save(value,id);
        }
        OrderMaster orderMaster = new OrderMaster();
        orderMaster.setBuyerAddress(u.getAddress());
        orderMaster.setBuyerIphone(u.getIphone());
        orderMaster.setBuyerName(u.getName());
        orderMaster.setOrderId(id);
        orderMaster.setBuyerOpenid(u.getOpenid());
        orderMaster.setOrderAmount(price);
        orderMasterService.add(orderMaster);
    }
}
