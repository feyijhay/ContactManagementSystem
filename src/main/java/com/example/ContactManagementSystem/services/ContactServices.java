package com.example.ContactManagementSystem.services;

import com.example.ContactManagementSystem.data.model.EditContactResponse;
import com.example.ContactManagementSystem.dtos.request.AddContactRequest;
import com.example.ContactManagementSystem.dtos.request.DeleteContactRequest;
import com.example.ContactManagementSystem.dtos.request.EditContactRequest;

public interface ContactServices {

    EditContactResponse addContact(AddContactRequest addContactRequest);
    EditContactResponse deleteContact(DeleteContactRequest deleteContactRequest);
    EditContactResponse searchForContact(String firstName);
    EditContactResponse editContact(EditContactRequest editContactRequest);

    EditContactResponse viewContact(String firstName);


}
