package com.example.demo.dao;


import com.example.demo.bean.*;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

//学生档案相关的数据库操作
public class FilesDao {
    static String dbname = new String("SManage");

    //增改
    public static boolean addStuFile(StuFiles stu){
        boolean flag = false;
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try{
            conn = ConnectSQL.getConnection(dbname);
            pstmt = conn.prepareStatement("select * from department where major = ?");
            pstmt.setString(1,stu.getMajor());
            rs = pstmt.executeQuery();
            if(!rs.next()){
                ConnectSQL.endSQL(conn,pstmt,rs);
                flag = false;
                return flag;
            }
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            ConnectSQL.endSQL(conn,pstmt,rs);
        }

        try{
            conn = ConnectSQL.getConnection(dbname);
            pstmt = conn.prepareStatement("select * from major where stuclass = ?");
            pstmt.setString(1,stu.getStuclass());
            rs = pstmt.executeQuery();
            if(!rs.next()){
                addclass(stu.getMajor(),stu.getStuclass());
            }
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            ConnectSQL.endSQL(conn,pstmt,rs);
        }


        //插入学生信息表
        try {
            conn = ConnectSQL.getConnection(dbname);
            pstmt = conn.prepareStatement("insert into student values(?,?,?,?,?,?,?,?,?)");
            pstmt.setString(1,stu.getSno());
            pstmt.setString(2,stu.getName());
            pstmt.setString(3,stu.getSex());
            pstmt.setString(4,stu.getId());
            pstmt.setString(5,stu.getBirthday());
            pstmt.setString(6,stu.getNation());
            pstmt.setString(7,stu.getPolitical());
            pstmt.setString(8,stu.getAdmissiontime());
            pstmt.setString(9,stu.getStunative());
            pstmt.execute();


        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            ConnectSQL.endSQL(conn,pstmt);
        }

        //插入学籍信息表
        try {
            conn = ConnectSQL.getConnection(dbname);
            pstmt = conn.prepareStatement("insert into status values(?,?,?,?,?,?)");
            pstmt.setString(1,stu.getSno());
            pstmt.setString(2,stu.getName());
            pstmt.setString(3,stu.getGrade());
            pstmt.setString(4,stu.getStuclass());
            pstmt.setInt(5,stu.getXuezhi());
            pstmt.setInt(6,1);

            pstmt.execute();
            flag = true;

        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            ConnectSQL.endSQL(conn,pstmt);
        }
        return flag;
    }

    public static boolean updateStuFile(StuFiles stu){
        boolean flag = false;
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try{
            conn = ConnectSQL.getConnection(dbname);
            pstmt = conn.prepareStatement("select * from department where major = ?");
            pstmt.setString(1,stu.getMajor());
            rs = pstmt.executeQuery();
            if(!rs.next()){
                ConnectSQL.endSQL(conn,pstmt,rs);
                flag = false;
                return flag;
            }
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            ConnectSQL.endSQL(conn,pstmt,rs);
        }

        try{
            conn = ConnectSQL.getConnection(dbname);
            pstmt = conn.prepareStatement("select * from major where stuclass = ?");
            pstmt.setString(1,stu.getStuclass());
            rs = pstmt.executeQuery();
            if(!rs.next()){
                addclass(stu.getMajor(),stu.getStuclass());
            }
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            ConnectSQL.endSQL(conn,pstmt,rs);
        }


        //更新信息表
        try {
            conn = ConnectSQL.getConnection(dbname);
            pstmt = conn.prepareStatement("UPDATE student set sname=?,sex=?,id = ?," +
                    "birth = ?, nation = ?,political = ?,admissiontime=?,native=? " +
                    "where sno = ?");
            pstmt.setString(9,stu.getSno());
            pstmt.setString(1,stu.getName());
            pstmt.setString(2,stu.getSex());
            pstmt.setString(3,stu.getId());
            pstmt.setString(4,stu.getBirthday());
            pstmt.setString(5,stu.getNation());
            pstmt.setString(6,stu.getPolitical());
            pstmt.setString(7,stu.getAdmissiontime());
            pstmt.setString(8,stu.getStunative());
            pstmt.execute();
            flag = true;

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            ConnectSQL.endSQL(conn,pstmt);
        }

        //更新学籍表
        try {
            conn = ConnectSQL.getConnection(dbname);
            pstmt = conn.prepareStatement("UPDATE status set sname=?,grade = ?,stuclass = ?, " +
                    "xuezhi = ? where sno = ?");
            pstmt.setString(5,stu.getSno());
            pstmt.setString(1,stu.getName());
            pstmt.setString(2,stu.getGrade());
            pstmt.setString(3,stu.getStuclass());
            pstmt.setInt(4,stu.getXuezhi());
            pstmt.execute();
            flag = true;

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            ConnectSQL.endSQL(conn,pstmt);
        }
        return flag;
    }

    //退学
    public static boolean deleteStuFile(String sno){
        boolean flag = false;
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = ConnectSQL.getConnection(dbname);
            pstmt = conn.prepareStatement("UPDATE status SET graduation = ? where sno = ? ");
            pstmt.setInt(1,-1);
            pstmt.setString(2,sno);
            pstmt.execute();
            flag = true;
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            ConnectSQL.endSQL(conn,pstmt);
        }

        return flag;
    }
    //查询
    //学号、姓名、入学时间、院系、专业、班级
    //查询全部
    public static List<StuFiles> findAll(){
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<StuFiles> allstufille= new ArrayList<StuFiles>();
        try {
            conn = ConnectSQL.getConnection(dbname);
            pstmt = conn.prepareStatement("select * from SInfor");
            rs = pstmt.executeQuery();

            while(rs.next()){
                StuFiles sf = new StuFiles(rs.getString("sno"),rs.getString("sname"),
                        rs.getString("sex"),rs.getString("id"),rs.getString("birth"),
                        rs.getString("nation"),rs.getString("political"),
                        rs.getString("admissiontime"),rs.getString("native"),
                        rs.getString("grade"),rs.getString("department"),
                        rs.getString("major"), rs.getString("stuclass"),
                        rs.getInt("xuezhi"));
                allstufille.add(sf);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            ConnectSQL.endSQL(conn,pstmt,rs);
        }
        return allstufille;
    }

    public static List<StuFiles> findBy(String keyname,String keyvalue){
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<StuFiles> allstufille= new ArrayList<StuFiles>();



        try {
            conn = ConnectSQL.getConnection(dbname);
            pstmt = conn.prepareStatement("select * from SInfor where "+keyname+" = ?");
            pstmt.setString(1,keyvalue);
            rs = pstmt.executeQuery();

            while(rs.next()){
                StuFiles sf = new StuFiles(rs.getString("sno"),rs.getString("sname"),
                        rs.getString("sex"),rs.getString("id"),rs.getString("birth"),
                        rs.getString("nation"),rs.getString("political"),
                        rs.getString("admissiontime"),rs.getString("native"),
                        rs.getString("grade"),rs.getString("department"),
                        rs.getString("major"), rs.getString("stuclass"),
                        rs.getInt("xuezhi"));
                allstufille.add(sf);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            ConnectSQL.endSQL(conn,pstmt,rs);
        }
        return allstufille;
    }
    public static boolean addclass(String major,String stuclass){
        boolean flag = false;
        PreparedStatement pstmt = null;
        Connection conn = null;
        try{
            conn = ConnectSQL.getConnection(dbname);
            pstmt = conn.prepareStatement("insert into major value(?,?)");
            pstmt.setString(1,stuclass);
            pstmt.setString(2,major);
            pstmt.execute();
            flag = true;
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            ConnectSQL.endSQL(conn,pstmt);
        }
        return flag;
    }
    public static boolean addmajor(String major,String department){
        boolean flag = false;
        PreparedStatement pstmt = null;
        Connection conn = null;
        try{
            conn = ConnectSQL.getConnection(dbname);
            pstmt = conn.prepareStatement("insert into department value(?,?)");
            pstmt.setString(1,major);
            pstmt.setString(2,department);
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
