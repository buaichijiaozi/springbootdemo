package com.dz.springboard.service;

import com.dz.springboard.entity.User;

/**用户模块业务层接口*/
public interface IUserService {
    /**
     * 用户注册方法
     *
     * @param user 用户的数据对象
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

    /**
     * 根据用户id来更新用户的数据
     * @param uid 用户id
     * @param username 用户名
     * @param oldPassword 001
     * @param newPassword 用户的新密码
     */
    Integer updatePasswordByUid(Integer uid,String username, String oldPassword, String newPassword);

    User getByUid(Integer uid);

    Integer updateInfoByUid(Integer uid, String username, User user);

    Integer updateAvatarByUid(Integer uid,String avatar , String username);
}
