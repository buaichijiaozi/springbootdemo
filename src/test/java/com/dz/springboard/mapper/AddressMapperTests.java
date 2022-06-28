package com.dz.springboard.mapper;

import com.dz.springboard.entity.Address;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.Date;

@SpringBootTest
@RunWith(SpringRunner.class)
@Slf4j
public class AddressMapperTests {

    @Resource
    private AddressMapper addressMapper;

    @Test
    public void insert() {
        Address address = new Address();
        address.setUid(16);
        address.setName("admin");
        address.setPhone("17858802974");
        address.setAddress("雁塔区小寨赛格");
        Integer rows = addressMapper.insert(address);
        System.out.println("rows=" + rows);
    }

    @Test
    public void countByUid() {
        Integer address = addressMapper.countByUid(16);
        System.out.println(address);
    }

    @Test
    public void findByUid(){
        for (Address address : addressMapper.findByUid(16)) {
            System.out.println(address);
        }
    }

    @Test
    public void findByAid(){
        Address address = addressMapper.findByAid(1);
        System.out.println(address);

    }

    @Test
    public void updateNonDefault(){
        Integer integer = addressMapper.updateNonDefault(16);
        System.out.println(integer);
        Address address = addressMapper.findByAid(1);
        System.out.println(address.getIsDefault());
        Address address2 = addressMapper.findByAid(2);
        System.out.println(address2.getIsDefault());

    }

    @Test
    public void updateDefaultByAid(){
        Date date = new Date();
        Integer integer = addressMapper.updateDefaultByAid(1, "001", date);
        System.out.println(integer);
        Address address = addressMapper.findByAid(1);
        System.out.println(address);

    }
}
