package com.baizhi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderDetail {
    private String detailId;

    private String orderId;

    private String productId;

    private String prodcutName;

    private Double productPrice;

    private String productIcon;

    private Integer productQuantity;

    private Date createTime;

    private Date updateTime;
}