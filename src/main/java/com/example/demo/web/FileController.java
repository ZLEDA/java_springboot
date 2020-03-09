package com.example.demo.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.*;
import com.example.demo.bean.*;

import java.util.List;

@RestController
@RequestMapping(value = "/File")
public class FileController {
    //增改+退学
    // //学号   姓名    性别  身份证号   出生日期   民族   政治面貌   入学日期  籍贯  年级  学院   专业   班级    学制
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public returnbool addFile(@RequestParam(value = "sno",required = false)String sno,@RequestParam(value = "sname",required = false)String sname,
                              @RequestParam(value = "sex",required = false)String sex,@RequestParam(value = "id",required = false)String id,
                              @RequestParam(value = "birth",required = false)String birth,@RequestParam(value = "nation",required = false)String nation,
                              @RequestParam(value = "political",required = false)String political,
                              @RequestParam(value = "admissiontime",required = false)String admissiontime,
                              @RequestParam(value = "native",required = false)String stunative,
                              @RequestParam(value = "grade",required = false)String grade,
                              @RequestParam(value = "department",required = false)String department,
                              @RequestParam(value = "major",required = false)String major,
                              @RequestParam(value = "stuclass",required = false)String stuclass,
                              @RequestParam(value = "xuezhi",required = false)int xuezhi){
        StuFiles sf = new StuFiles(sno,sname,sex,id,birth,nation,political,admissiontime,stunative,grade,department,major,stuclass,xuezhi);
        boolean flag = FilesDao.addStuFile(sf);
        returnbool rb = new returnbool(flag);
        return rb;
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public returnbool deleteFile(@RequestParam(value = "sno",required = true)String sno){
        boolean flag = FilesDao.deleteStuFile(sno);
        returnbool rb = new returnbool(flag);
        return rb;
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public returnbool updateFile(@RequestParam(value = "sno",required = false)String sno,@RequestParam(value = "sname",required = false)String sname,
                                 @RequestParam(value = "sex",required = false)String sex,@RequestParam(value = "id",required = false)String id,
                                 @RequestParam(value = "birth",required = false)String birth,@RequestParam(value = "nation",required = false)String nation,
                                 @RequestParam(value = "political",required = false)String political,
                                 @RequestParam(value = "admissiontime",required = false)String admissiontime,
                                 @RequestParam(value = "native",required = false)String stunative,
                                 @RequestParam(value = "grade",required = false)String grade,
                                 @RequestParam(value = "department",required = false)String department,
                                 @RequestParam(value = "major",required = false)String major,
                                 @RequestParam(value = "stuclass",required = false)String stuclass,
                                 @RequestParam(value = "xuezhi",required = false)int xuezhi){
        StuFiles sf = new StuFiles(sno,sname,sex,id,birth,nation,political,admissiontime,stunative,grade,department,major,stuclass,xuezhi);
        boolean flag = FilesDao.updateStuFile(sf);
        returnbool rb = new returnbool(flag);
        return rb;
    }

    @RequestMapping(value = "/find", method = RequestMethod.POST)
    public List<StuFiles> findBy(@RequestParam(value = "keyname",required = true)String keyname,@RequestParam(value = "keyvalue",required = true)String keyvalue){
        List<StuFiles> lsf = FilesDao.findBy(keyname,keyvalue);
        return lsf;
    }

    @RequestMapping(value = "/findAll", method = RequestMethod.POST)
    public List<StuFiles> finAll(){
        List<StuFiles> lsf = FilesDao.findAll();
        return lsf;
    }
    @RequestMapping(value = "/test")
    public String test(){
        return "Test Successful";
    }
}
