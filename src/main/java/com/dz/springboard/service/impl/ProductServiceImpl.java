package com.dz.springboard.service.impl;

import com.dz.springboard.entity.Product;
import com.dz.springboard.mapper.ProductMapper;
import com.dz.springboard.service.ProductService;
import com.dz.springboard.service.ex.ProductNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Slf4j
@Service
public class ProductServiceImpl implements ProductService {

    @Resource
    private ProductMapper productMapper;

    @Override
    public List<Product> findHotList() {
        return productMapper.findHotList();
    }

    @Override
    public Product findById(Integer id) {
        Product product = productMapper.findById(id);
        if (product == null){
            throw new ProductNotFoundException("Product No");
        }
        return product;
    }
}
