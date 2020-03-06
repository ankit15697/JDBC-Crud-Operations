package com.java.crud;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

// Delete operations
public class Delete implements Operations {
    private String sql;
    private String name;
    PreparedStatement statement = null;
    public void doOerations() throws SQLException {
        takeInput();
        sql = "DELETE FROM employeedemo.employee WHERE name=?";
        statement = ConnectionDetails.connection.prepareStatement(sql);
        statement.setString(1,name);
        int rowsDeleted = statement.executeUpdate();
        if (rowsDeleted > 0) {
            System.out.println("A user was deleted successfully!");
        }
        else {
            System.out.println("Something wrong has happened!!!");
        }
    }
    private void takeInput() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter user name which you want to delete !!!");
        name = sc.nextLine();
    }
}
