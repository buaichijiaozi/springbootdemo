package com.dz.springboard.service;

import com.dz.springboard.entity.User;

/**用户模块业务层接口*/
public interface IUserService {
    /**
     * 用户注册方法
     *
     * @param user 用户的数据对象
     * @return 如果注册成功，则返回true，否则返回false 如果注册成功，则会在数据库中插入一条数据
     */
    void reg(User user);

    /**
     * 用户登录方法
     * @param username 用户名
     * @param password 密码
     * @return 用户的数据对象
     */
    User login(String username, String password);

    /**
     * 根据用户id来查询用户的数据
     * @param uid 用户id
     * @return 用户的数据对象
     */
    User findByUid(Integer uid);
}
