package com.example.demo.dao;

import com.example.demo.bean.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class GradesDao {
    static String dbname = new String("SManage");
    //增
    public static boolean addStuGrade(StuGrades stu){
        boolean flag = false;
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try{
            conn = ConnectSQL.getConnection(dbname);
            pstmt = conn.prepareStatement("select * from course where cno = ?");
            pstmt.setString(1,stu.getCno());
            rs = pstmt.executeQuery();
            if(!rs.next()){
                addcno(stu.getCno(),stu.getCname(),stu.getCredit(),stu.getNature());
            }
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            ConnectSQL.endSQL(conn,pstmt,rs);
        }

        try {
            conn = ConnectSQL.getConnection(dbname);
            pstmt = conn.prepareStatement("insert into score values(?,?,?,?,?,?,?,1)");
            pstmt.setString(1,stu.getSno());
            pstmt.setString(2,stu.getName());
            pstmt.setString(3,stu.getYear());
            pstmt.setInt(4,stu.getTerm());
            pstmt.setString(5,stu.getCno());
            pstmt.setInt(6,stu.getGrades());
            pstmt.setString(7,stu.getExam());
            pstmt.execute();
            flag = true;

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            ConnectSQL.endSQL(conn,pstmt);
        }
        return flag;
    }

/*    public static boolean updateStuGrade(StuGrades stu){
        boolean flag = false;
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = ConnectSQL.getConnection(dbname);
            pstmt = conn.prepareStatement("UPDATE grade set year=?,term=?,grade=? " +
                    "where sno = ? and cno=?");
            pstmt.setString(4,stu.getSno());
            pstmt.setString(1,stu.getYear());
            pstmt.setInt(2,stu.getTerm());
            pstmt.setString(5,stu.getCno());
            pstmt.setInt(3,stu.getGrades());
            pstmt.execute();
            flag = true;

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            ConnectSQL.endSQL(conn,pstmt);
        }
        return flag;
    }
    */
    //查询
    //学号、姓名、学年、学期、课程号、课程名、性质
    public static List<StuGrades> findAll(){
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<StuGrades> allstugrade= new ArrayList<StuGrades>();
        try {
            conn = ConnectSQL.getConnection(dbname);
            pstmt = conn.prepareStatement("select * from score");
            rs = pstmt.executeQuery();

            while(rs.next()){
                //学号 姓名 学年 学期 课程号 课程名 学分 成绩 性质
                StuGrades sg = new StuGrades(rs.getString("sno"),rs.getString("sname"),
                        rs.getString("year"),rs.getInt("term"),
                        rs.getString("cno"),rs.getString("cname"),rs.getInt("credit"),
                        rs.getInt("grade"),rs.getString("nature"),rs.getString("exam"));
                allstugrade.add(sg);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            ConnectSQL.endSQL(conn,pstmt,rs);
        }
        return allstugrade;
    }
    public static List<StuGrades> findBy(String keyname,String keyvalue,String year,int term){
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<StuGrades> allstugrade= new ArrayList<StuGrades>();
        try {
            conn = ConnectSQL.getConnection(dbname);
            pstmt = conn.prepareStatement("select * from grade where "+keyname+"= ? and year =? and term = ?");
            pstmt.setString(1,keyvalue);
            pstmt.setString(2,year);
            pstmt.setInt(3,term);
            rs = pstmt.executeQuery();

            while(rs.next()){
                //学号 姓名 学年 学期 课程号 课程名 学分 成绩 性质
                StuGrades sg = new StuGrades(rs.getString("sno"),rs.getString("sname"),
                        rs.getString("year"),rs.getInt("term"),
                        rs.getString("cno"),rs.getString("cname"),rs.getInt("credit"),
                        rs.getInt("grade"),rs.getString("nature"),rs.getString("exam"));
                allstugrade.add(sg);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            ConnectSQL.endSQL(conn,pstmt,rs);
        }
        return allstugrade;
    }
    public static boolean addcno(String cno,String cname,double credit,String nature){
        boolean flag = false;
        PreparedStatement pstmt = null;
        Connection conn = null;
        try{
            conn = ConnectSQL.getConnection(dbname);
            pstmt = conn.prepareStatement("insert into course values(?,?,?,?)");
            pstmt.setString(1,cno);
            pstmt.setString(2,cname);
            pstmt.setDouble(3,credit);
            pstmt.setString(4,nature);
            pstmt.execute();
            flag = true;
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            ConnectSQL.endSQL(conn,pstmt);
        }
        return flag;
    }
}
