package com.dz.springboard.mapper;

import com.dz.springboard.entity.Cart;
import com.dz.springboard.vo.CartVO;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Date;
import java.util.List;

public interface CartMapper {

    Integer insert(Cart cart);

    Integer updateNumByCid(Integer cid, Integer num, String modifiedUser, Date modifiedTime);

    Cart findByUidAndPid(@PathVariable("uid") Integer uid, @PathVariable("pid") Integer pid);

    List<CartVO> findVoByUid(Integer uid);

    Cart findByCid(Integer cid);

    List<CartVO> findVoByCid(Integer[] cids);
}
