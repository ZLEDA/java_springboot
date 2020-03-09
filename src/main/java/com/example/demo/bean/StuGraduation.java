package com.example.demo.bean;

public class StuGraduation {
    String sno;
    String name;
    String department;
    String major;
    String stuclass;
    int bcredit;        //已修必修学分
    int zxcredit;       //已修专选学分
    int xxcredit;       //已修校选学分
    int request_bcredit;    //要求必修学分
    int request_zxcredit;   //要求专选学分
    int request_xxcredit;   //要求校选学分
    int graduate;        //能否毕业

    public StuGraduation(String sno,String name,String department,String major,String stuclass,int bcredit,int zxcredit,int xxcredit,int request_bcredit,int request_zxcredit,int request_xxcredit){
        this.sno = sno;
        this.name = name;
        this.department = department;
        this.major = major;
        this.stuclass = stuclass;
        this.bcredit = bcredit;
        this.zxcredit = zxcredit;
        this.xxcredit = xxcredit;
        this.request_bcredit = request_bcredit;
        this.request_zxcredit = request_zxcredit;
        this.request_xxcredit = request_xxcredit;
        if(this.bcredit >= this.request_bcredit && this.zxcredit >= this.request_zxcredit && this.xxcredit >= this.request_xxcredit)
            this.graduate = 1;      //可以毕业
        else
            this.graduate = 0;
    }
    public String getSno(){
        return this.sno;
    }
    public String getName(){
        return this.name;
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
    public int getBcredit(){
        return this.bcredit;
    }
    public int getZxcredit(){
        return this.zxcredit;
    }
    public int getXxcredit(){
        return this.xxcredit;
    }
    public int getRequest_bcredit(){
        return this.request_bcredit;
    }
    public int getRequest_zxcredit(){
        return this.request_zxcredit;
    }
    public int getRequest_xxcredit(){
        return this.request_xxcredit;
    }
    public int getGraduate(){
        return this.graduate;
    }
    public void setSno(String sno){
        this.sno = sno;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setDepartment(String department){
        this.department = department;
    }
    public void setMajor(String major){
        this.major = major;
    }
    public void setStuclass(String stuclass){
        this.stuclass = stuclass;
    }
    public void setBcredit(int bcredit){
        this.bcredit = bcredit;
    }
    public void setZxcredit(int zxcredit){
        this.zxcredit = zxcredit;
    }
    public void setXxcredit(int xxcredit){
        this.xxcredit = xxcredit;
    }
    public void setRequest_bcredit(int request_bcredit){
        this.request_bcredit = request_bcredit;
    }
    public void setRequest_zxcredit(int request_zxcredit){
        this.request_zxcredit = request_zxcredit;
    }
    public void setRequest_xxcredit(int request_xxcredit){
        this.request_xxcredit = request_xxcredit;
    }
    public void setGraduate(){
        if(this.bcredit >= this.request_bcredit && this.zxcredit >= this.request_zxcredit && this.xxcredit >= this.request_xxcredit)
            this.graduate = 1;      //可以毕业
        else
            this.graduate = 0;
    }
}
