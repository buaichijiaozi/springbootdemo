package com.dz.springboard.mapper;


import com.dz.springboard.entity.District;

import java.util.List;

public interface DistrictMapper {

    List<District> findByParent(String parent);

}
