package com.dz.springboard.vo;

import lombok.Data;

import java.io.Serializable;

@Data
public class CartVO implements Serializable {

    private Integer cid;
    private Integer uid;
    private Integer pid;
    private long price;
    private Integer num;
    private String title;
    private String image;
    private long realPrice;

}
