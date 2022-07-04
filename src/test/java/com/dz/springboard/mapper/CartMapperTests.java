package com.dz.springboard.mapper;

import com.dz.springboard.entity.Cart;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.Date;

@Slf4j
@SpringBootTest
@RunWith(SpringRunner.class)
public class CartMapperTests {

    @Resource
    private CartMapper cartMapper;

    @Test
    public void Insert() {
        Cart cart = new Cart();
        cart.setUid(33);
        cart.setPid(1);
        cart.setPrice(1);
        cart.setNum(2);
        Integer insert = cartMapper.insert(cart);
        log.info("insert: {}", insert);
    }

    @Test
    public void updateNumByCid() {
        Integer updateNumByCid = cartMapper.updateNumByCid(1, 4, "admin", new Date());
        log.info("updateNumByCid: {}", updateNumByCid);
    }

    @Test
    public void findByUidAndPid() {
        Cart cart = cartMapper.findByUidAndPid(32, 10000011);
        log.info("cart: {}", cart);
    }

    @Test
    public void findVoByUid(){
        System.out.println(cartMapper.findVoByUid(16));
    }

    @Test
    public void findByCid(){
        System.out.println(cartMapper.findByCid(5));
    }
    @Test
    public void findVoByCid(){
        Integer[] cid={1};
        System.out.println(cartMapper.findVoByCid(cid));
    }

}
