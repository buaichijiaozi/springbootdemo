package com.dz.springboard.service;

import com.dz.springboard.entity.User;
import com.dz.springboard.service.ex.ServiceException;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@SpringBootTest
@RunWith(SpringRunner.class)
@Slf4j
public class UserServiceTests {

    @Resource
    private IUserService userService;

    @Test
    public void reg(){
        try {
            User user = new User();
            user.setUsername("023");
            user.setPassword("123");
            userService.reg(user);
            System.out.println("OK");
        } catch (ServiceException e) {
            System.out.println(e.getClass().getSimpleName());
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void login(){
        String username = "001";
        String password = "123";
        User login = userService.login(username, password);
        System.out.println(login.toString());
    }

    @Test
    public void login2(){
        String username = "$2a$10$aLLovQ7eXLMpwdaOEEpEjO2p1h0YvuUCiTMy6SYx/FXmf2K9HZKBm";
        String username1 = "$2a$10$UixfVooYIYiHoYN363kuMOXzz2p6d378wu6.zdPoeFnvHrnHkVBNa";
        String username2 = "$2a$10$hDArIIQ4lh.OlUMhjn208e7.4wUq7BZED8PuNK4bM9rOyjgAlTiE.";

        int length = username.length();
        int length1 = username1.length();
        int length2 = username2.length();
        log.info("length: {} name: {}", length, username);
        log.info("length: {} name: {}", length1, username1);
        log.info("length: {} name: {}", length2, username2);
    }

    @Test
    public void updatePasswordByUid(){
        Integer integer = userService.updatePasswordByUid(30, "023", "123", "123");
        System.out.println(integer);
        System.out.println(userService.findByUid(28));

    }

    @Test
    public void getByUid(){
        System.err.println(userService.getByUid(30));
    }

    @Test
    public void updateInfoByUid(){
        User user = new User();
        user.setPhone("123456789");
        user.setEmail("123@163.com");
        user.setGender(1);
        Integer integer = userService.updateInfoByUid(30, "022", user);
        System.err.println(integer);
    }




}
