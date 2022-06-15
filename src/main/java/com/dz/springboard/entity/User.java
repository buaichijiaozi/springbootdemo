package com.dz.springboard.entity;


import lombok.Data;

import java.io.Serializable;
/**
 * 用户的实体类
 * */
@Data
public class User extends BaseEntity implements Serializable {

  /**
   * 用户id
   * 用户名
   * 密码
   * 盐值
   * 电话号码
   * 电子邮箱
   * 性别:0-女，1-男
   * 头像
   * 是否删除：0-未删除，1-已删除
   */
  private Integer uid;
  private String username;
  private String password;
  private String salt;
  private String phone;
  private String email;
  private Integer gender;
  private String avatar;
  private Integer isDelete;

}
