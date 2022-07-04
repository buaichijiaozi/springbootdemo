package com.dz.springboard.service.impl;

import com.dz.springboard.entity.Cart;
import com.dz.springboard.entity.Product;
import com.dz.springboard.mapper.CartMapper;
import com.dz.springboard.mapper.ProductMapper;
import com.dz.springboard.service.ICartService;
import com.dz.springboard.service.ex.AccessDeniedException;
import com.dz.springboard.service.ex.CartNotFoundException;
import com.dz.springboard.service.ex.InsertException;
import com.dz.springboard.service.ex.UpdateException;
import com.dz.springboard.vo.CartVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

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
            Product product = productMapper.findById(pid);
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
        } else {
            Integer num = result.getNum() + amount;
            Integer insert = cartMapper.updateNumByCid(result.getCid(), num, username, date);
            if (insert != 1) {
                throw new UpdateException("Cart Update Exception");
            }
            log.info("insert {} Update {}", insert, insert);
        }
    }

    @Override
    public List<CartVO> findVoByUid(Integer uid) {
        return cartMapper.findVoByUid(uid);
    }

    @Override
    public Integer addNum(Integer cid, Integer uid, String modifiedUser) {
        log.info("addNum cid: {}, uid: {}, modifiedUser: {}", cid, uid, modifiedUser);
        Cart result = cartMapper.findByCid(cid);
        if (result == null) {
            throw new CartNotFoundException("Cart Not Found Exception");
        }
        if (!result.getUid().equals(uid)) {
            throw new AccessDeniedException("Access Denied Exception");
        }
        Integer num = result.getNum() + 1;
        Integer insert = cartMapper.updateNumByCid(cid, num, modifiedUser, new Date());
        if (insert != 1) {
            throw new UpdateException("Cart Update Exception");
        }
        return num;
    }

    @Override
    public Integer reduceNum(Integer cid, Integer uid, String modifiedUser) {
        log.info("reduceNum cid {} uid {} modifiedUser {}", cid, uid, modifiedUser);
        Cart result = cartMapper.findByCid(cid);
        if (result == null) {
            throw new CartNotFoundException("Cart Not Found Exception");
        }
        if (!result.getUid().equals(uid)) {
            throw new AccessDeniedException("Access Denied Exception");
        }
        Integer num = result.getNum() - 1;
        Integer insert = cartMapper.updateNumByCid(cid, num, modifiedUser, new Date());
        if (insert != 1) {
            throw new UpdateException("Cart Update Exception");
        }
        return num;
    }

    @Override
    public List<CartVO> getVoByCid(Integer uid, Integer[] cids) {
        List<CartVO> list = cartMapper.findVoByCid(cids);
        Iterator<CartVO> iterator = list.iterator();
        while (iterator.hasNext()){
            CartVO next = iterator.next();
            if (!next.getUid().equals(uid)){
                list.remove(next);
            }
        }
        /*list.removeIf(next -> !next.getUid().equals(uid));*/
        return list;
    }
}
