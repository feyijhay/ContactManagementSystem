package com.example.ContactManagementSystem.dtos.request;

import lombok.Data;

@Data
public class EditContactRequest {
    private String existingFirstName;
    private String firstName;
    private String lastName;
    private String phoneNumber;
}
