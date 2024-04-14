package com.example.ContactManagementSystem.services;

import com.example.ContactManagementSystem.dtos.response.EditContactResponse;
import com.example.ContactManagementSystem.dtos.request.AddContactRequest;
import com.example.ContactManagementSystem.dtos.request.DeleteContactRequest;
import com.example.ContactManagementSystem.dtos.request.EditContactRequest;
import com.example.ContactManagementSystem.dtos.response.*;

public interface UserServices {

    AddContactResponse addContact(AddContactRequest addContactRequest);
    DeleteContactResponse deleteContact(DeleteContactRequest deleteContactRequest);
    SearchForContactResponse searchForContact(String firstName);
    EditContactResponse editContact(EditContactRequest editContactRequest);

    ViewContactResponse viewContact(String firstName);

    long count();
}
