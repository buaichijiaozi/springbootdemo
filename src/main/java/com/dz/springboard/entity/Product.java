package com.dz.springboard.entity;

import lombok.Data;

@Data
public class Product extends BaseEntity{
    private Integer id;
    private Integer categoryId;
    private String itemType;
    private String title;
    private String sellPoint;
    private long price;
    private Integer num;
    private String image;
    private Integer status;
    private Integer priority;
}
