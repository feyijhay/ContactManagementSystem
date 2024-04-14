package com.example.ContactManagementSystem.exception;

public class ContactNotFoundException extends ContactManagementException{
    public ContactNotFoundException(String statement){
        super(statement);
    }
}
