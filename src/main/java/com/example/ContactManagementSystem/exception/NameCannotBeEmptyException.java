package com.example.ContactManagementSystem.exception;

public class NameCannotBeEmptyException extends ContactManagementException{
    public NameCannotBeEmptyException(String statement){
        super(statement);
    }
}
