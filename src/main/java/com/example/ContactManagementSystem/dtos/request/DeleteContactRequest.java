package com.example.ContactManagementSystem.dtos.request;

import lombok.Data;

@Data
public class DeleteContactRequest {

    private String firstName;
    private String lastName;
    private String phoneNumber;
}
