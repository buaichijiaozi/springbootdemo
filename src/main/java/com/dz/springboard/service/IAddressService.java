package com.dz.springboard.service;

import com.dz.springboard.entity.Address;

public interface IAddressService {
    void addNewAddress(Integer uid, String username, Address address);

    Address ByUid(Integer uid);
}
