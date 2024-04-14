package com.example.ContactManagementSystem.services;

import com.example.ContactManagementSystem.data.model.EditContactResponse;
import com.example.ContactManagementSystem.data.repositories.ContactRepository;
import com.example.ContactManagementSystem.dtos.request.AddContactRequest;
import com.example.ContactManagementSystem.dtos.request.DeleteContactRequest;
import com.example.ContactManagementSystem.dtos.request.EditContactRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContactServicesImpl implements ContactServices{
    @Autowired
    private ContactRepository contactRepository;
    @Override
    public EditContactResponse addContact(AddContactRequest addContactRequest) {
        EditContactResponse contact = new EditContactResponse();
        contact.setFirstName(addContactRequest.getFirstName());
        contact.setLastName(addContactRequest.getLastName());
        contact.setPhoneNumber(addContactRequest.getPhoneNumber());

       return contactRepository.save(contact);

    }

    @Override
    public EditContactResponse deleteContact(DeleteContactRequest deleteContactRequest) {
        EditContactResponse contact = contactRepository.searchContactByFirstName(deleteContactRequest.getFirstName());
        contact.setFirstName(deleteContactRequest.getFirstName());
          contactRepository.delete(contact);

          return contact;

    }

    @Override
    public EditContactResponse searchForContact(String firstName) {
//        if (contactRepository.existsContactsByFirstName(firstName)){
//            return contactRepository.searchContactByFirstName(firstName);
//        }
        return null;
    }

    @Override
    public EditContactResponse editContact(EditContactRequest editContactRequest) {
        EditContactResponse contact = contactRepository.searchContactByPhoneNumber(editContactRequest.getPhoneNumber());
        contact.setFirstName(editContactRequest.getFirstName());
        contact.setLastName(editContactRequest.getLastName());
        return contactRepository.save(contact);
    }

    @Override
    public EditContactResponse viewContact(String firstName) {
        return contactRepository.searchContactByFirstName(firstName);

    }



}
