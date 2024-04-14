package com.example.ContactManagementSystem.exception;

public class InvalidPhoneNumberException extends ContactManagementException{
    public InvalidPhoneNumberException(String statement){
        super(statement);
    }
}
