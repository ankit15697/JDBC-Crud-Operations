package com.java.crud;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Select implements Operations {
    private String sql;
    private String id;
    private String name;
    private String city;
    private String age;
    private String departmentName;
    public void doOerations() throws SQLException {
        sql = "select * from employeedemo.employee";
        ResultSet rs = ConnectionDetails.statement.executeQuery(sql);
        while (rs.next()){
            id = rs.getString("id");
            name = rs.getString("name");
            city = rs.getString("city");
            age = rs.getString("age");
            departmentName = rs.getString("departmentname");
            System.out.println("Record " + id + " is " + name + " " + city + " " + age + " " + departmentName);
        }
    }
}
