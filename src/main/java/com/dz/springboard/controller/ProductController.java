package com.dz.springboard.controller;

import com.dz.springboard.entity.Product;
import com.dz.springboard.service.ProductService;
import com.dz.springboard.util.JsonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.amqp.RabbitProperties;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

import static com.dz.springboard.controller.BaseController.OK;

@Slf4j
@RestController
@RequestMapping("products")
public class ProductController extends RabbitProperties.BaseContainer {

    @Resource
    private ProductService productService;

    @RequestMapping("hot_list")
    public JsonResult<List<Product>> getHotList(){
        List<Product> list = productService.findHotList();
        return new  JsonResult<>(OK,"OK",list);
    }

    @RequestMapping("details/{id}")
    public JsonResult<Product> getById(@PathVariable("id") Integer id){
        Product data = productService.findById(id);
        return new JsonResult<>(OK,"Ok",data);
    }

}
