package com.dz.springboard.service.impl;

import com.dz.springboard.entity.User;
import com.dz.springboard.mapper.UserMapper;
import com.dz.springboard.service.IUserService;
import com.dz.springboard.service.ex.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

/**用户模块业务层的实现类*/
@Slf4j
@Service
public class UserServiceImpl implements IUserService {

    @Resource
    private UserMapper userMapper;


    public void reg(User user) {
        String username = user.getUsername();
        User result = userMapper.findByUsername(username);
        if (result != null) {
            throw new UsernameDuplicateException("尝试注册的用户名[" + username + "]已经被占用");
        }
        String password = user.getPassword();
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String newPassword = encoder.encode(password);
        user.setUsername(username);
        user.setPassword(newPassword);

        user.setIsDelete(0);
        user.setCreatedUser(user.getUsername());
        user.setModifiedUser(user.getUsername());
        Date date = new Date();
        user.setCreatedTime(date);
        user.setModifiedTime(date);

        Integer rows = userMapper.insert(user);
        if (rows != 1){
            throw new InsertException("添加用户数据出现未知错误，请联系系统管理员");
        }
    }

    @Override
    public User login(String username, String password) {
        User result = userMapper.findByUsername(username);
        if (result == null){
            throw new UsernameNotFoundException("UserNameNull");
        }

        String oldPassword = result.getPassword();
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        boolean matches = encoder.matches(password, oldPassword);
        log.info(String.valueOf("matches"+matches));
        if (!encoder.matches(password, oldPassword)){
            throw new PasswordNotMatchException("PasswordNotMatch");
        }
        return getUser(result);
    }

    @Override
    public User findByUid(Integer uid) {
        User result = userMapper.findByUid(uid);
        if (result == null){
            throw new UsernameNotFoundException("UserNameNull");
        }
        return getUser(result);
    }

    @Override
    public Integer updatePasswordByUid(Integer uid, String username, String oldPassword, String newPassword) {
        User result = userMapper.findByUid(uid);
        if (result == null || result.getIsDelete().equals(1)){
            throw new UsernameDuplicateException("UserNo");
        }
        String newOldPassword = result.getPassword();
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        if (!encoder.matches(oldPassword, newOldPassword)){
            throw new PasswordNotMatchException("PasswordNotMatch");
        }
        newPassword = encoder.encode(newPassword);
        Integer rows = userMapper.updatePasswordByUid(uid, newPassword, username, new Date());
        if (rows != 1) {
            throw new UpdateException("UpdateException");
        }
        return rows;
    }

    @Override
    public User getByUid(Integer uid) {
        User result = userMapper.findByUid(uid);
        if (result == null || result.getIsDelete().equals(1)){
            throw new UsernameNotFoundException("usernameNoNull");
        }
        User user = new User();
        user.setUsername(result.getUsername());
        user.setPhone(result.getPhone());
        user.setEmail(result.getEmail());
        user.setGender(result.getGender());
        return user;
    }

    @Override
    public Integer updateInfoByUid(Integer uid, String username, User user) {
        User result = userMapper.findByUid(uid);
        if (result == null || result.getIsDelete().equals(1)){
            throw new UsernameNotFoundException("usernameNoNull");
        }
        user.setUid(uid);
        //user.setUsername(username);
        user.setModifiedUser(username);
        user.setModifiedTime(new Date());
        Integer rows = userMapper.updateInfoByUid(user);
        if (rows != 1){
            throw new UpdateException("updateErr");
        }
        return rows;
    }

    @Override
    public Integer updateAvatarByUid(Integer uid, String avatar, String username) {
        User result = userMapper.findByUid(uid);
        if (result == null || result.getIsDelete().equals(1)){
            throw new UsernameNotFoundException("userNoNull");
        }
        Integer rows = userMapper.updateAvatarByUid(uid, avatar, username, new Date());
        if (rows != 1){
            throw new UpdateException("UpdateException");
        }
        return rows;
    }

    private User getUser(User result) {
        if (result.getIsDelete() == 1){
            throw new UsernameNotFoundException("UserNameDel");
        }
        User user = new User();
        user.setUid(result.getUid());
        user.setUsername(result.getUsername());
        user.setAvatar(result.getAvatar());
        return user;
    }
}



















