package com.example.demo.service;

import com.example.demo.bean.*;
import com.example.demo.dao.*;

public class GradeService {
    //增删改
    public static boolean addStuGrade(StuGrades stu){
        boolean flag = false;
        try{
            GradesDao.addStuGrade(stu);
            flag = true;
        }catch(Exception e){
            e.printStackTrace();
        }
        return flag;
    }
    public static boolean updateStuGrade(StuGrades stu){
        boolean flag = false;
        try{
            GradesDao.updateStuGrade(stu);
            flag = true;
        }catch(Exception e){
            e.printStackTrace();
        }
        return flag;
    }
 /*   public static boolean deleteStuGrade(StuGrades stu){
        boolean flag = false;
        try{
            GradesDao.deleteStuGrade(stu);
            flag = true;
        }catch(Exception e){
            e.printStackTrace();
        }
        return flag;
    }*/
    //查询
}
