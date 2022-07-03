package com.dz.springboard.controller;

import com.dz.springboard.controller.ex.*;
import com.dz.springboard.service.ex.*;
import com.dz.springboard.util.JsonResult;
import org.jetbrains.annotations.NotNull;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpSession;

public class BaseController {
    public static final int OK = 200;
    public static final Integer USERNAME_DUPLICATE = 4000;
    public static final Integer INSERT_FAIL = 5000;


    public static final String USERNAME_DUPLICATE_MSG = "用户名已经被占用";
    public static final String INSERT_FAIL_MSG = "注册失败，请联系系统管理员";


    @ExceptionHandler({ServiceException.class, FileUploadException.class})
    public JsonResult<Void> handleException(Throwable e) {
        JsonResult<Void> result = new JsonResult<>(e);
        if (e instanceof UsernameDuplicateException) {
            result.setState(USERNAME_DUPLICATE);
            result.setMessage(USERNAME_DUPLICATE_MSG);
        } else if (e instanceof AddressCountLimitException) {
            result.setState(4003);
            result.setMessage("用户的收货地址超出上限的异常");
        } else if (e instanceof AddressNotFoundException) {
            result.setState(4004);
            result.setMessage("Tel not found");
        } else if (e instanceof AccessDeniedException) {
            result.setState(4005);
            result.setMessage("Tel date Access denied");
        } else if (e instanceof ProductNotFoundException) {
            result.setState(4006);
            result.setMessage("Product date not found");
        } else if (e instanceof CartNotFoundException) {
            result.setState(4007);
            result.setMessage("Cart date not found");
        } else if (e instanceof UsernameNotFoundException) {
            result.setState(5001);
            result.setMessage("Username not found");
        } else if (e instanceof PasswordNotMatchException) {
            result.setState(5002);
            result.setMessage("Password not match");
        } else if (e instanceof InsertException) {
            result.setState(INSERT_FAIL);
            result.setMessage(INSERT_FAIL_MSG);
        } else if (e instanceof UpdateException) {
            result.setState(5001);
            result.setMessage("UpdateException");
        } else if (e instanceof FileEmptyException) {
            result.setState(6000);
        } else if (e instanceof FileSizeException) {
            result.setState(6001);
        } else if (e instanceof FileTypeException) {
            result.setState(6002);
        } else if (e instanceof FileStateException) {
            result.setState(6003);
        } else if (e instanceof FileUploadIOException) {
            result.setState(6004);
        }
        return result;
    }

    protected final Integer getuidFromSession(@NotNull HttpSession session) {
        return Integer.valueOf(session.getAttribute("uid").toString());
    }

    protected final String getUsernameFromSession(HttpSession session) {
        return session.getAttribute("username").toString();
    }
}
