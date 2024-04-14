package com.example.ContactManagementSystem.dtos.response;

import lombok.Data;

@Data
public class EditContactResponse {
    private String firstName;
    private String lastName;
    private String phoneNumber;
}
