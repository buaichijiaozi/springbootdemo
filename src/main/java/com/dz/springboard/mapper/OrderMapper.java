package com.dz.springboard.mapper;

import com.dz.springboard.entity.Order;
import com.dz.springboard.entity.OrderItem;

public interface OrderMapper {
    Integer insertOrder(Order order);
    Integer insertOrderItem(OrderItem orderItem);
}
