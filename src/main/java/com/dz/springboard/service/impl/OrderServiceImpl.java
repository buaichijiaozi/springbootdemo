package com.dz.springboard.service.impl;

import com.dz.springboard.entity.Address;
import com.dz.springboard.entity.Order;
import com.dz.springboard.entity.OrderItem;
import com.dz.springboard.mapper.OrderMapper;
import com.dz.springboard.service.IAddressService;
import com.dz.springboard.service.ICartService;
import com.dz.springboard.service.IOrderService;
import com.dz.springboard.service.ex.InsertException;
import com.dz.springboard.vo.CartVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Slf4j
@Service
public class OrderServiceImpl implements IOrderService {

    @Resource
    private OrderMapper orderMapper;
    @Resource
    private IAddressService addressService;
    @Resource
    private ICartService cartService;


    @Transactional
    @Override
    public Order create(Integer aid, Integer[] cids, Integer uid, String username) {
        Date now = new Date();
        List<CartVO> carts = cartService.getVoByCid(uid, cids);
        long totalPrice = 0;;
        for (CartVO cart : carts) {
            log.info(String.valueOf(cart.getNum()));
            totalPrice += cart.getRealPrice() * cart.getNum();
        }
        Order order = new Order();
        order.setUid(uid);
        Address address = addressService.getByAid(aid, uid);
        order.setRecvName(address.getName());
        order.setRecvPhone(address.getPhone());
        order.setRecvProvince(address.getProvinceName());
        order.setRecvCity(address.getCityName());
        order.setRecvArea(address.getAreaName());
        order.setRecvAddress(address.getAddress());
        order.setTotalPrice(totalPrice);
        order.setStatus(0);
        order.setOrderTime(now);
        order.setCreatedUser(username);
        order.setCreatedTime(now);
        order.setModifiedUser(username);
        order.setModifiedTime(now);
        Integer rows1 = orderMapper.insertOrder(order);
        if (rows1 != 1) {
            throw new InsertException("插入订单数据时出现未知错误，请联系系统管理员");
        }
        for (CartVO cart : carts) {
            OrderItem item = new OrderItem();
            item.setOid(order.getOid());
            item.setPid(cart.getPid());
            item.setTitle(cart.getTitle());
            item.setImage(cart.getImage());
            item.setPrice(cart.getRealPrice());
            item.setNum(cart.getNum());
            item.setCreatedUser(username);
            item.setCreatedTime(now);
            item.setModifiedUser(username);
            item.setModifiedTime(now);
            Integer rows2 = orderMapper.insertOrderItem(item);
            if (rows2 != 1) {
                throw new InsertException("插入订单商品数据时出现未知错误，请联系系统管理员");
            }
        }
        return order;
    }
}
