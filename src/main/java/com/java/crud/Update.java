package com.java.crud;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Update implements Operations {
    private String sql;
    private int id;
    private int age;
    private String name;
    private String city;
    private String departmentName;
    public Update() {
    }

    public void doOerations() throws SQLException{
        sql ="UPDATE employeedemo.employee SET name=?, city=?, age=?, departmentname=? WHERE id=?";
        PreparedStatement statement = null;
        try {
            statement = ConnectionDetails.connection.prepareStatement(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        takeInput();

        statement.setString(1,name);
        statement.setString(2, city);
        statement.setString(3,Integer.toString(age));
        statement.setString(4, departmentName);
        statement.setString(5,Integer.toString(id));

        int rowsInserted = statement.executeUpdate();
        if (rowsInserted > 0) {
            System.out.println("User has been update successfully");
        }
        else{
            System.out.println("Something wrong has happened !!!!");
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

