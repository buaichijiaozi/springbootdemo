package com.dz.springboard.service;

import com.dz.springboard.vo.CareVo;

import java.util.List;

public interface ICartService {
    void addToCart(Integer uid, Integer pid, Integer amount, String username);
    List<CareVo> findVoByUid(Integer uid);

    Integer addNum(Integer cid, Integer uid, String modifiedUser);
    Integer reduceNum(Integer cid, Integer uid, String modifiedUser);

    List<CareVo> getVoByCid(Integer uid, Integer[] cids);
}
