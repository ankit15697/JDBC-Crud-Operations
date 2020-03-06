// This class will be responsible for creating the connections
package com.java.crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionDetails {
   public static String url;
   public static String user;
   public static Connection connection;
   public static Statement statement;
   public static String password;
   public static void createConnection() {
         url = "jdbc:mysql://localhost:3306/employeedemo?autoReconnect=true&useSSL=false";
         user = "root";
         password = "admin";
       try {
           connection = DriverManager.getConnection(url, user, password);
       } catch (SQLException e) {
           e.printStackTrace();
       }
       try {
           statement= connection.createStatement();
       } catch (SQLException e) {
           e.printStackTrace();
       }
   }
}
