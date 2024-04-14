package com.example.ContactManagementSystem.dtos.response;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class AddContactResponse {
    @Id
    private String id;
    private String firstName;
    private String lastName;
    private String phoneNumber;
}
