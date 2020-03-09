package com.example.demo.web;

import com.example.demo.dao.LoginDao;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.bean.*;

@RestController
public class LoginController {
    //@RequestMapping(value = "/login")
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public returnbool login(@RequestParam(value = "id",required = true)String id,@RequestParam(value = "passwd",required = true)String passwd){
        boolean flag = LoginDao.Login(id,passwd);
        returnbool rb = new returnbool(flag);
        return rb;
    }
}
