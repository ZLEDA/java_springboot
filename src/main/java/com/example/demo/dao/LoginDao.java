package com.example.demo.dao;

import java.sql.*;

public class LoginDao {
    static String dbname = new String("SManage");

    public static boolean Login(String id,String passwd){
        boolean flag = false;
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = ConnectSQL.getConnection(dbname);
            pstmt = conn.prepareStatement("select * from account where id = ? and passwd = ?");
            pstmt.setString(1,id);
            pstmt.setString(2,passwd);
            rs = pstmt.executeQuery();
            if(rs.next()){
                flag = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            ConnectSQL.endSQL(conn,pstmt,rs);
        }
        return flag;
    }
}
