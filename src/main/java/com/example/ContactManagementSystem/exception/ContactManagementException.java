package com.example.ContactManagementSystem.exception;

public class ContactManagementException extends RuntimeException{
    public ContactManagementException (String statement){
        super(statement);
    }
}
