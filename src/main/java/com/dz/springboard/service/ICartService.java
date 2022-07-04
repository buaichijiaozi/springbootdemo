package com.dz.springboard.service;

import com.dz.springboard.vo.CartVO;

import java.util.List;

public interface ICartService {
    void addToCart(Integer uid, Integer pid, Integer amount, String username);
    List<CartVO> findVoByUid(Integer uid);

    Integer addNum(Integer cid, Integer uid, String modifiedUser);
    Integer reduceNum(Integer cid, Integer uid, String modifiedUser);

    List<CartVO> getVoByCid(Integer uid, Integer[] cids);
}
