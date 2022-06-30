package com.dz.springboard.controller;

import com.dz.springboard.entity.Cart;
import com.dz.springboard.service.ICartService;
import com.dz.springboard.util.JsonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@Slf4j
@RestController
@RequestMapping("/carts")
public class CartController extends BaseController {

    @Resource
    private ICartService cartService;

    @RequestMapping("add_to_cart")
    public JsonResult<Void> addToCart(Integer pid, Integer amount, HttpSession session){
        Integer uid = getuidFromSession(session);
        String username = getUsernameFromSession(session);
        cartService.addToCart(uid,pid,amount,username);
        return new JsonResult<>(OK,"OK");
    }
}
