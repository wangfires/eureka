package com.baizhi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Cart {
    private String id;
    private String name;
    private Integer count;
    private Double price;
    private Double total;
    private String icon;
    private Date createdate;
    private Date updatetime;
}
