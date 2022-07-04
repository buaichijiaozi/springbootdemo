package com.dz.springboard.service;

import com.dz.springboard.entity.Order;

public interface IOrderService {
    Order create(Integer aid, Integer[] cids, Integer uid, String username);
}
