package com.example.client1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class QueryJDBC {

    public static void main(String[] args) {

        try {

            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/charity","root", "comsc");

            Statement statement = conn.createStatement();  // Create blank SQL statement that will have user dater added.

            ResultSet resultSet = statement.executeQuery("select * from userquery");

            while (resultSet.next()) {
                System.out.println(resultSet.getInt("ID"));
                System.out.println(resultSet.getString("firstname"));
                System.out.println(resultSet.getString("lastname"));
                System.out.println(resultSet.getString("email"));
                System.out.println(resultSet.getString("message"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
