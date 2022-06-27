package com.dz.springboard.service;

import com.dz.springboard.entity.District;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

@Slf4j
@SpringBootTest
@RunWith(SpringRunner.class)
public class DistrictServiceTests {

    @Resource
    private IDistrictService districtService;

    @Test
    public void getByParent(){
        List<District> list = districtService.getByParent("86");
        for (District district : list) {
            System.out.println(district);
        }
    }

    @Test
    public void getNameByCode(){
        String code = districtService.getNameByCode("630000");
        System.out.println(code);
    }
}
