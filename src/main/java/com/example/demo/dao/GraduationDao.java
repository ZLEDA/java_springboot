package com.example.demo.dao;

import com.example.demo.bean.*;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GraduationDao {
    static String dbname = new String("SManage");

    //查询
    public static List<StuGraduation> findBy(String keyname,String keyvalue){
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<StuGraduation> allstugraduation= new ArrayList<StuGraduation>();



        try {
            conn = ConnectSQL.getConnection(dbname);
            pstmt = conn.prepareStatement("select * from SInfor where "+keyname+" = ?");
            pstmt.setString(1,keyvalue);
            rs = pstmt.executeQuery();

            while(rs.next()){
                StuGraduation sg = new StuGraduation(rs.getString("sno"),rs.getString("sname"),
                        rs.getString("department"),rs.getString("major"),
                        rs.getString("stuclass"),rs.getInt("bcredit"),rs.getInt("zcredit"),rs.getInt("xcredit"),
                        rs.getInt("bixiu"),rs.getInt("zhuanxuan"),rs.getInt("xiaoxuan"));
                allstugraduation.add(sg);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            ConnectSQL.endSQL(conn,pstmt,rs);
        }
        return allstugraduation;
    }

    //毕业
    public static boolean graduate(String sno){
        boolean flag = false;
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = ConnectSQL.getConnection(dbname);
            pstmt = conn.prepareStatement("UPDATE status set graduation = 0 " +
                    "where sno = ?");
            pstmt.setString(1,sno);
            pstmt.execute();
            flag = true;

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            ConnectSQL.endSQL(conn,pstmt);
        }
        return flag;

    }
}
