package com.example.ContactManagementSystem.dtos.response;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class DeleteContactResponse {
    @Id
//    private String id;
//    private String firstName;
    private boolean isDeleted;
}
