package com.dz.springboard.controller;

import com.dz.springboard.entity.Address;
import com.dz.springboard.service.IAddressService;
import com.dz.springboard.util.JsonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/address")
public class AddressController extends BaseController{

    @Resource
    private IAddressService addressService;

    @RequestMapping("add_new_address")
    public JsonResult<Address> addNewAddress(Address address, HttpSession session){
        Integer uid = getuidFromSession(session);
        String username = getUsernameFromSession(session);
        addressService.addNewAddress(uid, username, address);
        log.info("ADD NEW ADDRESS: {}", address);
        return new JsonResult<>(OK,"OK",address);
    }

    @RequestMapping({"","/"})
    public JsonResult<List<Address>> getByUid(HttpSession session){
        Integer uid = getuidFromSession(session);
        List<Address> list = addressService.getByUid(uid);
        return new JsonResult<>(OK,"OK",list);
    }

    @RequestMapping("/set_default/{aid}")
    public JsonResult<Void> setDefault(@PathVariable("aid") Integer aid, HttpSession session){
        log.info("SET DEFAULT ADDRESS: {}", aid);
        Integer uid = getuidFromSession(session);
        String username = getUsernameFromSession(session);
        addressService.setDefault(aid, uid, username);
        return new JsonResult<>(OK,"OK");
    }

    @RequestMapping("/delete/{aid}")
    public JsonResult<Void> delete(@PathVariable("aid") Integer aid, HttpSession session){
        log.info("DELETE ADDRESS: {}", aid);
        Integer uid = getuidFromSession(session);
        String username = getUsernameFromSession(session);
        addressService.delete(aid, uid, username);
        return new JsonResult<>(OK,"OK");
    }

}
