package com.java.crud;
// Factory for creating Operators
public class OperationGenerator {
    public static Operations generate(String type) {
        if(type.equals("Delete")) {
            return  new Delete();
        }
        if(type.equals("Insert")) {
            return  new Insert();
        }
        if(type.equals("Update")) {
            return  new Update();
        }
        return new Select();
    }
}
