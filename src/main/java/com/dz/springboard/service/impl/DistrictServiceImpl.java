package com.dz.springboard.service.impl;

import com.dz.springboard.entity.District;
import com.dz.springboard.mapper.DistrictMapper;
import com.dz.springboard.service.IDistrictService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class DistrictServiceImpl implements IDistrictService {

    @Resource
    private DistrictMapper districtMapper;

    @Override
    public List<District> getByParent(String parent) {
        List<District> list = districtMapper.findByParent(parent);
        for(District d : list){
            d.setId(null);
            d.setParent(null);
        }
        return list;
    }

    @Override
    public String getNameByCode(String code) {
        return districtMapper.findNameByCode(code);
    }
}
