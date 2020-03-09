package com.example.demo.web;

import com.example.demo.dao.GradesDao;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.*;
import com.example.demo.bean.*;

import java.util.List;

@RestController
@RequestMapping(value = "/Grade")
public class GradeController {
    //增删改
    //{"sno":sno,"sname":sname,"year":year,"term":term,"cno":cno,"cname":cname,"credit":credit,"grade":grade,"nature":nature}
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public returnbool addGrade(@RequestParam(value = "sno",required = true)String sno, @RequestParam(value = "sname",required = true)String sname,@RequestParam(value = "year",required = true)String year,@RequestParam(value = "term",required = true)int term,@RequestParam(value = "cno",required = true)String cno,@RequestParam(value = "cname",required = true)String cname,@RequestParam(value = "credit",required = true)int credit,@RequestParam(value = "grade",required = true)int grade,@RequestParam(value = "nature",required = true)String nature,@RequestParam(value = "exam",required = true)String exam){
        StuGrades sg = new StuGrades(sno,sname,year,term,cno,cname,credit,grade,nature,exam);
        boolean flag = GradesDao.addStuGrade(sg);
        returnbool rb = new returnbool(flag);
        return rb;
    }


    @RequestMapping(value = "/find", method = RequestMethod.POST)
    public List<StuGrades> findBy(@RequestParam(value = "keyname",required = true)String keyname,@RequestParam(value = "keyvalue",required = true)String keyvalue,@RequestParam(value = "year",required = true)String year,@RequestParam(value = "term",required = true)int term){
        List<StuGrades> lsg = GradesDao.findBy(keyname,keyvalue,year,term);
        return lsg;
    }

    @RequestMapping(value = "/findAll", method = RequestMethod.POST)
    public List<StuGrades> findAll(){
        List<StuGrades> lsg = GradesDao.findAll();
        return lsg;
    }

    @RequestMapping(value = "/test")
    public String test(){
        return "Test Successful";
    }
}
