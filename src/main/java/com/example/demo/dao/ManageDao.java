package com.example.demo.dao;

import com.example.demo.bean.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

//学生学籍培养方案相关的数据库操作
public class ManageDao {
    static String dbname = new String("SManage");


    public static List<StuManage> findAll(){
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<StuManage> allstumanage= new ArrayList<StuManage>();
        try {
            conn = ConnectSQL.getConnection(dbname);
            pstmt = conn.prepareStatement("select * from avg");
            rs = pstmt.executeQuery();

            while(rs.next()){
                String manage = "?";
                int count = rs.getInt("count");
                int grade = rs.getInt("avg");
                if(count==1) manage = "试读";
                else if(count>=2) manage = "退学";
                else if(grade>=85) manage ="优秀";
                else manage = "合格";
                StuManage sm = new StuManage(rs.getString("sno"),rs.getString("sname"),
                        rs.getString("grade"), rs.getString("department"),
                        rs.getString("major"),
                        rs.getString("stuclass"),
                        rs.getString("year"),manage);
                allstumanage.add(sm);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            ConnectSQL.endSQL(conn,pstmt,rs);
        }
        return allstumanage;
    }

    public static List<StuManage> findBy(String keyname,String keyvalue){
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<StuManage> allstumanage= new ArrayList<StuManage>();
        try {
            conn = ConnectSQL.getConnection(dbname);
            pstmt = conn.prepareStatement("select * from avg where "+keyname+" = ?");
            pstmt.setString(1,keyvalue);
            rs = pstmt.executeQuery();

            while(rs.next()){
                String manage = "?";
                int count = rs.getInt("count");
                int grade = rs.getInt("avg");
                if(count ==1) manage = "试读";
                else if(count>=2) manage = "退学";
                else if(grade>=85) manage ="优秀";
                else manage = "合格";
                StuManage sm = new StuManage(rs.getString("sno"),rs.getString("sname"),
                        rs.getString("grade"), rs.getString("department"),
                        rs.getString("major"),
                        rs.getString("stuclass"),
                        rs.getString("year"),manage);
                allstumanage.add(sm);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            ConnectSQL.endSQL(conn,pstmt,rs);
        }
        return allstumanage;
    }
}
