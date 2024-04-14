package com.example.ContactManagementSystem.dtos.request;

import lombok.Data;

@Data
public class AddContactRequest {
//    private String username;
    private String firstName;
    private String lastName;
    private String phoneNumber;
}
