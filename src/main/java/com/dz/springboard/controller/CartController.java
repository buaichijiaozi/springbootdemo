package com.dz.springboard.controller;

import com.dz.springboard.entity.Cart;
import com.dz.springboard.service.ICartService;
import com.dz.springboard.util.JsonResult;
import com.dz.springboard.vo.CareVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/carts")
public class CartController extends BaseController {

    @Resource
    private ICartService cartService;

    @RequestMapping("add_to_cart")
    public JsonResult<Void> addToCart(Integer pid, Integer amount, HttpSession session){
        Integer uid = getuidFromSession(session);
        String username = getUsernameFromSession(session);
        cartService.addToCart(uid,pid,amount,username);
        return new JsonResult<>(OK,"OK");
    }

    @RequestMapping({"","/"})
    public JsonResult<List<CareVo>> getVoByUid(HttpSession session){
        Integer uid = getuidFromSession(session);
        List<CareVo> list = cartService.findVoByUid(uid);
        return new JsonResult<>(OK,"OK",list);
    }

    @RequestMapping("/add_num/{cid}")
    public JsonResult<Integer> addNum(@PathVariable("cid") Integer cid, HttpSession session){
        Integer uid = getuidFromSession(session);
        String username = getUsernameFromSession(session);
        Integer integer = cartService.addNum(cid, uid, username);
        return new JsonResult<>(OK,"OK",integer);
    }

    @RequestMapping("/reduce_num/{cid}")
    public JsonResult<Integer> reduceNum(@PathVariable("cid") Integer cid, HttpSession session){
        Integer uid = getuidFromSession(session);
        String username = getUsernameFromSession(session);
        Integer integer = cartService.reduceNum(cid, uid, username);
        return new JsonResult<>(OK,"OK",integer);
    }

    @RequestMapping("list")
    public JsonResult<List<CareVo>> getVoByCid(Integer[] cids, HttpSession session){
        Integer uid = getuidFromSession(session);
        List<CareVo> list = cartService.getVoByCid(uid,cids);
        return new JsonResult<>(OK,"OK",list);
    }
}
