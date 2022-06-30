package com.dz.springboard.service.impl;

import com.dz.springboard.entity.Cart;
import com.dz.springboard.entity.Product;
import com.dz.springboard.mapper.CartMapper;
import com.dz.springboard.mapper.ProductMapper;
import com.dz.springboard.service.ICartService;
import com.dz.springboard.service.ex.InsertException;
import com.dz.springboard.service.ex.UpdateException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

@Slf4j
@Service
public class CartServiceImpl implements ICartService {

    @Resource
    private CartMapper cartMapper;
    @Resource
    private ProductMapper productMapper;

    @Override
    public void addToCart(Integer uid, Integer pid, Integer amount, String username) {
        Cart result = cartMapper.findByUidAndPid(uid, pid);
        Date date = new Date();
        if (result == null) {
            Cart cart = new Cart();
            log.info(String.valueOf(pid));
            Product product = productMapper.findById(pid);
            log.info(String.valueOf(product));
            cart.setUid(uid);
            cart.setPid(pid);
            cart.setNum(amount);
            cart.setPrice(product.getPrice());
            cart.setCreatedUser(username);
            cart.setCreatedTime(date);
            cart.setModifiedUser(username);
            cart.setModifiedTime(date);
            Integer insert = cartMapper.insert(cart);
            if (insert != 1) {
                throw new InsertException("Cart Insert Exception");
            }
            log.info("insert {}", insert);
        } else {
            Integer num = result.getNum() + amount;
            Integer insert = cartMapper.updateNumByCid(result.getCid(), num, username, date);
            if (insert != 1) {
                throw new UpdateException("Cart Update Exception");
            }
            log.info("Update {}", insert);
        }
    }
}
