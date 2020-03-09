package com.example.demo.dao;

import java.sql.*;

public class ConnectSQL {
    public static Connection getConnection(String dbname){
        String driverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
        String dbURL = "jdbc:sqlserver://127.0.0.1:1433;DatabaseName="+dbname;
        String userName = "sa";
        String userPwd = "123";
        Connection dbConn = null;
        try {
            Class.forName(driverName);
            System.out.println("加载驱动成功！");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("加载驱动失败！");
        }
        try {
            dbConn = DriverManager.getConnection(dbURL, userName, userPwd);
            System.out.println("连接数据库成功！");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.print("SQL Server连接失败！");
            System.exit(1);
        }
        return dbConn;
    }
    //关闭连接
    public static void endSQL(Connection conn,PreparedStatement pstmt){
        try{
            if(pstmt != null)
                pstmt.close();
            if(conn != null)
                conn.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    //关闭连接
    public static void endSQL(Connection conn,PreparedStatement pstmt,ResultSet rs){
        try{
            if(rs!=null)
                rs.close();
            if(pstmt != null)
                pstmt.close();
            if(conn != null)
                conn.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
