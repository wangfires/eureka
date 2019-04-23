package com.baizhi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Food {
    private String id;
    private String name;
    private Double price;
    private String description;
    private String icon;
}
