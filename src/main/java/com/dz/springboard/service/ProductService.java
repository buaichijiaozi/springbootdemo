package com.dz.springboard.service;

import com.dz.springboard.entity.Product;

import java.util.List;

public interface ProductService {
    List<Product> findHotList();
    Product findById(Integer id);
}
