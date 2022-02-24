package com.example.client1;

//import java.sql.*;
//
//public class DailyQuotes {
//
//    static Connection con = null;
//    static Statement stm = null;
//
//    public static String DailyQuotes(int id) {
//
//        try {
//            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/charity", "root", "comsc");
//            stm = con.createStatement();
//
//            ResultSet ps2 = stm.executeQuery("SELECT quotes FROM daily_quotes");
//
//            ps2.next();
//
//            return ps2.getString("quotes");
//        }
//
//        catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
//
//        return null;
//    }
//}
