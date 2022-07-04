package com.dz.springboard.service;

import com.dz.springboard.entity.Order;
import com.dz.springboard.service.ex.ServiceException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@SpringBootTest
@RunWith(SpringRunner.class)
public class OrderServiceTests {
    @Resource
    private IOrderService orderService;

    @Test
    public void create() {
        try {
            Integer aid = 3;
            Integer[] cids = {4};
            Integer uid = 15;
            String username = "订单管理员";
            Order order = orderService.create(aid,cids,uid,username);
            System.out.println(order);
        } catch (ServiceException e) {
            System.out.println(e.getClass().getSimpleName());
            System.out.println(e.getMessage());
        }
    }
}
