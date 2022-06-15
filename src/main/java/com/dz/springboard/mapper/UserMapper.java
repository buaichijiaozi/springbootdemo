package com.dz.springboard.mapper;

import com.dz.springboard.entity.User;

/**
 * 用户模块的持久层接口
 */
public interface UserMapper {
    /**
     * 插入用户的数据
     * @param user 用户的数据
     * @return 受影啊的行巍数（增、删、改）
     */
    Integer insert(User user);

    /**
     * 根据用户名来查询用户的数据
     * @param username 用户名
     * @return 如果找到对应的用户则返回这个用户的数据，如果没有找到则返回null值
     */
    User findByUsername(String username);


    Integer del(int uid);



}
