package com.dz.springboard.controller;

import com.dz.springboard.entity.User;
import com.dz.springboard.service.IUserService;
import com.dz.springboard.util.JsonResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/** 处理用户相关请求的控制器类 */
@RestController
@RequestMapping("users")
public class UserController extends BaseController{
    @Resource
    private IUserService userService;

    @RequestMapping("reg")
    public JsonResult<Void> reg(User user) {
        userService.reg(user);
        return new JsonResult<>(OK);
    }

    @RequestMapping("login")
    public JsonResult<User> login(String username, String password, HttpSession session){
        User dara = userService.login(username,password);
        session.setAttribute("uid",dara.getUid());
        session.setAttribute("username",dara.getUsername());
        System.out.println(getuidFromSession(session));
        System.out.println(getUsernameFromSession(session));

        return new JsonResult<>(OK,dara);
    }
}
