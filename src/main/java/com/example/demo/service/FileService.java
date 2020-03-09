package com.example.demo.service;

import com.example.demo.bean.*;
import com.example.demo.dao.*;

public class FileService {
    //增删改
    public static boolean addStuFile(StuFiles stu){
        boolean flag = false;
        try{
            FilesDao.addStuFile(stu);
            flag = true;
        }catch(Exception e){
            e.printStackTrace();
        }
        return flag;
    }
    public static boolean updateStuFile(StuFiles stu){
        boolean flag = false;
        try{
            FilesDao.updateStuFile(stu);
            flag = true;
        }catch(Exception e){
            e.printStackTrace();
        }
        return flag;
    }
 /*   public static boolean deleteStuFile(StuFiles stu){
        boolean flag = false;
        try{
            FilesDao.deleteStuFile(stu);
            flag = true;
        }catch(Exception e){
            e.printStackTrace();
        }
        return flag;
    }*/
    //查询

}
