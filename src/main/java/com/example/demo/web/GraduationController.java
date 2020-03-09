package com.example.demo.web;

import com.example.demo.dao.GradesDao;
import com.example.demo.dao.GraduationDao;
import com.example.demo.dao.LoginDao;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.bean.*;

import java.util.List;

@RestController
@RequestMapping(value = "/Graduation")
public class GraduationController {
    //查找
    @RequestMapping(value = "/find", method = RequestMethod.POST)
    public List<StuGraduation> findBy(@RequestParam(value = "keyname",required = false)String keyname, @RequestParam(value = "keyvalue",required = false)String keyvalue){
        List<StuGraduation> lsg = GraduationDao.findBy(keyname,keyvalue);
        return lsg;
    }
    //毕业
    @RequestMapping(value = "/graduate", method = RequestMethod.POST)
    public returnbool graduate(@RequestParam(value = "sno",required = false)String sno){
        boolean flag = GraduationDao.graduate(sno);
        returnbool rb = new returnbool(flag);
        return rb;
    }
}
