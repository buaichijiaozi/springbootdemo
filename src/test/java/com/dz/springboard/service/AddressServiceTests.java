package com.dz.springboard.service;

import com.dz.springboard.entity.Address;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
@Slf4j
public class AddressServiceTests {

    @Resource
    private IAddressService addressService;


    @Test
    public void addNewAddress() {
        Integer uid = 32;
        String username = "admin";
        Address address = new Address();
        address.setUid(uid);
        address.setName(username);
        address.setPhone("17858802974");
        address.setAddress("雁塔区小寨赛格");
        addressService.addNewAddress(uid, username, address);
    }

    @Test
    public void getByUid(){
        for (Address address : addressService.getByUid(16)) {
            System.out.println(address);
        }

    }

    @Test
    public void setDefault(){
        addressService.setDefault(1,16,"002");
        List<Address> address = addressService.getByUid(16);
        for (Address address1 : address) {
            System.out.println(address1);
        }
    }

    @Test
    public void delete(){
        addressService.delete(20,32,"002");
        List<Address> address = addressService.getByUid(32);
        for (Address address1 : address) {
            System.out.println(address1);
        }
    }

}
