package com.example.demo.bean;


//学生档案类
public class StuFiles {
    //学号   姓名    性别  身份证号   出生日期   民族   政治面貌   入学日期  籍贯  年级  学院   专业   班级    学制
    String sno;
    String name;
    String sex;
    String id;
    String birthday;
    String nation;
    String political;
    String admissiontime;
    String stunative;
    String grade;
    String department;
    String major;
    String stuclass;
    int xuezhi;

    public StuFiles(String sno,String name,String sex,String id,String birthday,
            String nation,String political,String admissiontime,String stunative,
            String grade,String department,String major,String stuclass,int xuezhi){
        this.sno = sno;
        this.name = name;
        this.sex = sex;
        this.admissiontime = admissiontime;
        this.department = department;
        this.major = major;
        this.stuclass = stuclass;
        this.id = id;
        this.birthday = birthday;
        this.nation = nation;
        this.political = political;
        this.stunative = stunative;
        this.grade = grade;
        this.xuezhi = xuezhi;
    }

    public String getSno(){
        return this.sno;
    }
    public String getName(){
        return this.name;
    }
    public String getSex(){
        return this.sex;
    }
    public String getAdmissiontime(){
        return this.admissiontime;
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
    public String getId(){
        return this.id;
    }
    public String getBirthday(){
        return this.birthday;
    }
    public String getNation(){
        return this.nation;
    }
    public String getPolitical(){
        return this.political;
    }
    public String getStunative(){
        return this.stunative;
    }
    public String getGrade(){
        return this.grade;
    }
    public int getXuezhi(){
        return this.xuezhi;
    }

    public void setSno(String sno){
        this.sno = sno;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setSex(String sex){
        this.sex = sex;
    }
    public void setAdmissiontime(String admissiontime){
        this.admissiontime = admissiontime;
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
    public void setId(String id){
        this.id = id;
    }
    public void setBirthday(String birthday){
        this.birthday = birthday;
    }
    public void setNation(String nation){
        this.nation = nation;
    }
    public void setPolitical(String political){
        this.political = political;
    }
    public void setStunative(String stunative){
        this.stunative = stunative;
    }
    public void setGrade(String grade){
        this.grade = grade;
    }
    public void setXuezhi(int xuezhi){
        this.xuezhi = xuezhi;
    }
}
