package com.dz.springboard.service;

import com.dz.springboard.entity.Product;

import java.util.List;

public interface IProductService {
    List<Product> findHotList();
    Product findById(Integer id);
}
