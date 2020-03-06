package com.java.crud;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
// Insert Operation
public class Insert implements Operations {
    private String sql;
    private int id;
    private int age;
    private String name;
    private String city;
    private String departmentName;
    public Insert() {
    }

    public void doOerations() throws SQLException{
        sql = "INSERT INTO employeedemo.employee(id, name, city, age, departmentname) VALUES (?, ?, ?, ?,?)";
        PreparedStatement statement = null;
        try {
            statement = ConnectionDetails.connection.prepareStatement(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        takeInput();
        statement.setString(1,Integer.toString(id));
        statement.setString(2,name);
        statement.setString(3, city);
        statement.setString(4,Integer.toString(age));
        statement.setString(5, departmentName);

        int rowsInserted = statement.executeUpdate();
        if (rowsInserted > 0) {
            System.out.println("A new user was inserted successfully!");
        }
    }
    private void takeInput() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the id : ");
        id = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter the name : ");
        name = sc.nextLine();

        System.out.println("Enter the city : ");
        city = sc.nextLine();
        System.out.println("Enter the age : ");
        age = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter the Department name : ");
        departmentName = sc.nextLine();
    }
}

