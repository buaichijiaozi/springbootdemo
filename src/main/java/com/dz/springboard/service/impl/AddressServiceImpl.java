package com.dz.springboard.service.impl;

import com.dz.springboard.entity.Address;
import com.dz.springboard.mapper.AddressMapper;
import com.dz.springboard.service.IAddressService;
import com.dz.springboard.service.ex.AddressCountLimitException;
import com.dz.springboard.service.ex.InsertException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

/** 用户模块业务层的实现类 */
@Slf4j
@Service
public class AddressServiceImpl implements IAddressService {

    @Resource
    private AddressMapper addressMapper;

    @Value("${springboard.address.count-limit}")
    private Integer maxCount;

    @Override
    public Address addNewAddress(Integer uid, String username, Address address) {
        Integer count = addressMapper.findByUid(uid);
        if (count >= maxCount) {
            throw new AddressCountLimitException("AddressCountOverLimit");
        }
        Integer isDefault = count == 0 ? 1 : 0;
        address.setUid(uid);
        address.setIsDefault(isDefault);
        addressSet(username, address);

        Integer rows = addressMapper.insert(address);
        if (rows != 1) {
            throw new InsertException("添加用户数据出现未知错误，请联系系统管理员");
        }
        Address newAddress = new Address();
        newAddress = address;
        return newAddress;

    }

    @Override
    public Address ByUid(Integer uid) {
        Address address = addressMapper.ByUid(uid);
        address.setUid(address.getUid());
        return address;
    }

    private static void addressSet(String username, Address address) {
        address.setCreatedUser(username);
        address.setModifiedUser(username);
        address.setCreatedTime(new Date());
        address.setModifiedTime(new Date());
    }
}
