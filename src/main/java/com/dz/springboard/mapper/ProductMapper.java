package com.dz.springboard.mapper;

import com.dz.springboard.entity.Product;


import java.util.List;

public interface ProductMapper {
    List<Product> findHotList();
    Product findById(Integer id);
}
