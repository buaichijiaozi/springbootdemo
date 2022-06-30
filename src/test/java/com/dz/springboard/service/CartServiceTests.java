package com.dz.springboard.service;


import com.dz.springboard.entity.Cart;
import com.dz.springboard.entity.Product;
import com.dz.springboard.mapper.CartMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@Slf4j
@SpringBootTest
@RunWith(SpringRunner.class)
public class CartServiceTests {

    @Resource
    private ICartService cartService;

    @Test
    public void addToCart(){
        cartService.addToCart(35, 10000011, 4, "admin");
    }
}
