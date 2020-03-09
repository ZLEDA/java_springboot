package com.example.demo.bean;

//学生成绩类
public class StuGrades {
    //学号 姓名 学年 学期 课程号 课程名 学分 成绩 性质 考试性质
    String sno;
    String name;
    String year;
    int term;
    String cno;
    String cname;
    int credit;
    int grades;
    String nature;
    String exam;

    public StuGrades(String sno,String name,String year,int term,String cno,
                     String cname,int credit,int grades,String nature,String exam){
        this.sno = sno;
        this.name = name;
        this.year = year;
        this.term = term;
        this.cno = cno;
        this.cname = cname;
        this.credit = credit;
        this.grades = grades;
        this.nature =  nature;
        this.exam = exam;
    }

    public String getSno(){
        return this.sno;
    }
    public String getName(){
        return this.name;
    }
    public String getYear(){
        return this.year;
    }
    public int getTerm(){
        return this.term;
    }
    public String getCno(){
        return this.cno;
    }
    public String getCname(){
        return this.cname;
    }
    public int getCredit(){
        return this.credit;
    }
    public int getGrades(){
        return this.grades;
    }
    public String getNature(){
        return this.nature;
    }
    public String getExam(){
        return this.exam;
    }

    public void setSno(String sno){
        this.sno = sno;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setYear(String year){
        this.year = year;
    }
    public void setTerm(int term){
        this.term = term;
    }
    public void setCno(String cno){
        this.cno = cno;
    }
    public void setCname(String cname){
        this.cname = cname;
    }
    public void setCredit(int credit){
        this.credit = credit;
    }
    public void setGrades(int grades){
        this.grades = grades;
    }
    public void setNature(String nature){
        this.nature = nature;
    }
    public void setExam(String exam){
        this.exam = exam;
    }
}
