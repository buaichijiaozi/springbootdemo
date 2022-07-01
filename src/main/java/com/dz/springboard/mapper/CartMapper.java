package com.dz.springboard.mapper;

import com.dz.springboard.entity.Cart;
import com.dz.springboard.vo.CareVo;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Date;
import java.util.List;

public interface CartMapper {

    Integer insert(Cart cart);

    Integer updateNumByCid(Integer cid, Integer num, String modifiedUser, Date modifiedTime);

    Cart findByUidAndPid(@PathVariable("uid") Integer uid, @PathVariable("pid") Integer pid);

    List<CareVo> findVoByUid(Integer uid);
}
