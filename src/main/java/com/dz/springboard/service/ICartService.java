package com.dz.springboard.service;

import com.dz.springboard.entity.Cart;

public interface ICartService {
    void addToCart(Integer uid, Integer pid, Integer amount, String username);
}
