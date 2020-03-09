package com.example.demo.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.*;
import com.example.demo.bean.*;

import java.util.List;

@RestController
@RequestMapping(value = "/Manage")
public class ManageController {
    @RequestMapping(value = "/findAll", method = RequestMethod.POST)
    public List<StuManage> finAll(){
        List<StuManage> lsm = ManageDao.findAll();
        return lsm;
    }

    @RequestMapping(value = "/find", method = RequestMethod.POST)
    public List<StuManage> findBy(@RequestParam(value = "keyname",required = true)String keyname,@RequestParam(value = "keyvalue",required = true)String keyvalue){
        List<StuManage> lsm = ManageDao.findBy(keyname,keyvalue);
        return lsm;
    }
}
