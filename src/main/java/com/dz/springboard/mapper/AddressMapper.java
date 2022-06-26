package com.dz.springboard.mapper;

import com.dz.springboard.entity.Address;
import com.dz.springboard.entity.User;

public interface AddressMapper {

    Integer insert(Address address);
    Integer findByUid(Integer uid);
    Address ByUid(Integer uid);

}
