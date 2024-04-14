package com.example.ContactManagementSystem.controllers;


import com.example.ContactManagementSystem.dtos.request.AddContactRequest;
import com.example.ContactManagementSystem.dtos.request.DeleteContactRequest;
import com.example.ContactManagementSystem.dtos.request.EditContactRequest;
import com.example.ContactManagementSystem.dtos.response.*;
import com.example.ContactManagementSystem.exception.ContactManagementException;
import com.example.ContactManagementSystem.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.CREATED;
@RequestMapping("/api/User")
@RestController
public class UserControllers {
    @Autowired
    private UserServices contactManagementServices;

    @PostMapping("/addContact")
    public ResponseEntity<?> addContact(@RequestBody AddContactRequest addContactRequest) {
        try {
            AddContactResponse result = contactManagementServices.addContact(addContactRequest);
            return new ResponseEntity<>(new ApiResponse(true, result), CREATED );
        }
        catch (ContactManagementException e){
            return new ResponseEntity<>(new ApiResponse(false,  e.getMessage()), BAD_REQUEST);
        }
    }

    @PostMapping("/deleteContact")
    public ResponseEntity<?> deleteContact(@RequestBody DeleteContactRequest deleteContactRequest){
        try {
            DeleteContactResponse result = contactManagementServices.deleteContact(deleteContactRequest);
            return new ResponseEntity<>(new ApiResponse(true, result), CREATED );
        }
        catch (ContactManagementException e){
            return new ResponseEntity<>(new ApiResponse(false,  e.getMessage()), BAD_REQUEST);
        }
    }

    @PostMapping ("/searchContact")
    public ResponseEntity<?> searchContact(@RequestBody String firstName){
        try {
            SearchForContactResponse result = contactManagementServices.searchForContact(firstName);
            return new ResponseEntity<>(new ApiResponse(true, result), CREATED );
        }
        catch (ContactManagementException e){
            return new ResponseEntity<>(new ApiResponse(false,  e.getMessage()), BAD_REQUEST);
        }
    }

    @PostMapping("/editContact")
    public ResponseEntity<?> editContact(@RequestBody EditContactRequest editContactRequest){
        try {
            EditContactResponse result = contactManagementServices.editContact(editContactRequest);
            return new ResponseEntity<>(new ApiResponse(true, result), CREATED );
        }
        catch (ContactManagementException e){
            return new ResponseEntity<>(new ApiResponse(false,  e.getMessage()), BAD_REQUEST);
        }
    }

    @GetMapping("/viewContact")
    public ResponseEntity<?> viewContact(@RequestBody String firstName){
        try {
            ViewContactResponse result = contactManagementServices.viewContact(firstName);
            return new ResponseEntity<>(new ApiResponse(true, result), CREATED );
        }
        catch (ContactManagementException e){
            return new ResponseEntity<>(new ApiResponse(false,  e.getMessage()), BAD_REQUEST);
        }
    }



}
