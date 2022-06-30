package com.dz.springboard.entity;

import lombok.Data;

@Data
public class Cart extends BaseEntity{
    private Integer cid;
    private Integer uid;
    private Integer pid;
    private long price;
    private Integer num;
}


