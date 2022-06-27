package com.dz.springboard.service;

import com.dz.springboard.entity.District;

import java.util.List;

public interface IDistrictService {

    List<District> getByParent(String parent);

    String getNameByCode(String code);

}
