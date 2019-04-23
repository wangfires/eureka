package com.baizhi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;
import java.util.Date;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductInfo {
    @Id
    private String productId;

    private String productName;

    private Double productPrice;

    private Integer productStock;

    private String productDescription;

    private String productIcon;

    private Integer categoryType;

    private Date createTime;

    private Date updateTime;

}