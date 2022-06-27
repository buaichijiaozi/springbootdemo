package com.dz.springboard.controller;

import com.dz.springboard.entity.District;
import com.dz.springboard.service.IDistrictService;
import com.dz.springboard.util.JsonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/districts")
public class DistrictController extends BaseController{

    @Resource
    private IDistrictService districtService;

    @RequestMapping({"/",""})
    private JsonResult<List<District>> getByParent(String parent){
        List<District> list = districtService.getByParent(parent);
        return new JsonResult<>(OK,"OK",list);
    }
}
