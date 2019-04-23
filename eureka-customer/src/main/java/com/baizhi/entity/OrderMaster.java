package com.baizhi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderMaster {
    private String orderId;

    private String buyerName;

    private String buyerIphone;

    private String buyerAddress;

    private String buyerOpenid;

    private Double orderAmount;

    private String orderStatus;

    private String payStayus;

    private Date createTime;

    private Date updateTime;

}