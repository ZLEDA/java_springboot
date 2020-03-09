package com.example.demo.bean;

//学生培养方案类
public class StuManage {
    //学号 姓名 年级 院系 专业 班级 学年 培养方案
    String sno;
    String name;
    String grade;
    String department;
    String major;
    String stuclass;
    String year;
    String manage;
    public StuManage(String sno,String name,String grade,String department,String major,String stuclass,String year,String manage){
        this.sno = sno;
        this.name = name;
        this.grade = grade;
        this.year = year;
        this.department = department;
        this.major = major;
        this.stuclass = stuclass;
        this.manage = manage;
    }
    public String getSno(){
        return this.sno;
    }
    public String getName(){
        return this.name;
    }
    public String getGrade(){
        return this.grade;
    }
    public String getYear(){
        return this.year;
    }
    public String getDepartment(){
        return this.department;
    }
    public String getMajor(){
        return this.major;
    }
    public String getStuclass(){
        return this.stuclass;
    }
    public String getManage(){
        return this.manage;
    }
    public void setSno(String sno){
        this.sno = sno;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setGrade(String grade){
        this.grade = grade;
    }
    public void setYear(String year){
        this.year = year;
    }
    public void setDepartment(String department){
        this.department = department;
    }
    public void setMajor(String major){
        this.manage = major;
    }
    public void setStuclass(String stuclass){
        this.stuclass = stuclass;
    }
    public void setManage(String manage){
        this.manage = manage;
    }
}
