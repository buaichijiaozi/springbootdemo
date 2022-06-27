package com.dz.springboard.mapper;

import com.dz.springboard.entity.District;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;


@SpringBootTest
@RunWith(SpringRunner.class)
public class DistrictMapperTests {

    @Resource
    private DistrictMapper districtMapper;

    @Test
    public void findByParent() {
        List<District> districts = districtMapper.findByParent("210100");
        System.out.println(districts);
    }
}
