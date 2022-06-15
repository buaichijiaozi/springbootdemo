package com.dz.springboard.entity;


import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class BaseEntity implements Serializable {

    /**
     * 日志-创建人
     * 日志-创建时间
     * 日志-最后修改执行人
     * 日志-最后修改时间
     * */
    private String createdUser;
    private Date createdTime;
    private String modifiedUser;
    private Date modifiedTime;

}
