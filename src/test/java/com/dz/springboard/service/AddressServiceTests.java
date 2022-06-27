package com.dz.springboard.service;

import com.dz.springboard.entity.Address;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@SpringBootTest
@RunWith(SpringRunner.class)
@Slf4j
public class AddressServiceTests {

    @Resource
    private IAddressService addressService;

    @Test
    public void addNewAddress() {
        Integer uid = 16;
        String username = "admin";
        Address address = new Address();
        address.setUid(uid);
        address.setName(username);
        address.setPhone("17858802974");
        address.setAddress("雁塔区小寨赛格");
        addressService.addNewAddress(uid, username, address);
    }

}
