package com.dz.springboard.mapper;

import com.dz.springboard.entity.Cart;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Date;

public interface CartMapper {

    Integer insert(Cart cart);

    Integer updateNumByCid(Integer cid, Integer num, String modifiedUser, Date modifiedTime);

    Cart findByUidAndPid(@PathVariable("uid") Integer uid, @PathVariable("pid") Integer pid);

}
