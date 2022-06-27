package com.dz.springboard.entity;

import lombok.Data;

@Data
public class District{
    private Integer id;
    private String parent;
    private String code;
    private String name;

}
