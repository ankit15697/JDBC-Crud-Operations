// This class will be responsible for controlling the whole logic
package com.java.controller;

import com.java.crud.ConnectionDetails;
import com.java.crud.OperationGenerator;
import com.java.crud.Operations;

import java.sql.SQLException;
import java.util.Scanner;

public class Controller {
    int option;
    Operations operations;
    public Controller() {
        ConnectionDetails.createConnection();
    }
    public void performOperations()  {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("Press for the appropriate functionality\n 1.Select\n 2.Insert\n 3.Update\n 4.Delete\n -1.Stop");
            option = sc.nextInt();
            switch (option) {
                case 1:
                     operations = OperationGenerator.generate("Select");
                     break;
                case 2:
                    operations = OperationGenerator.generate("Insert");
                    break;
                case 3:
                    operations = OperationGenerator.generate("Update");
                    break;
                case 4:
                    operations = OperationGenerator.generate("Delete");
                    break;
                default:
                    try {
                        ConnectionDetails.connection.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
            }
            try {
                operations.doOerations();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
