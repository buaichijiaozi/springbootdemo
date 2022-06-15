package com.dz.springboard.service;

import com.dz.springboard.entity.User;

/**用户模块业务层接口*/
public interface IUserService {
    /**
     * 用户注册方法
     *
     * @param user 用户的数据对象
     * @return
     */
    void reg(User user);

    User login(String username, String password);
}
