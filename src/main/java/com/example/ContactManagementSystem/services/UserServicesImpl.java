package com.example.ContactManagementSystem.services;

import com.example.ContactManagementSystem.data.model.User;
import com.example.ContactManagementSystem.data.repositories.UserRepository;
import com.example.ContactManagementSystem.dtos.request.AddContactRequest;
import com.example.ContactManagementSystem.dtos.request.DeleteContactRequest;
import com.example.ContactManagementSystem.dtos.request.EditContactRequest;
import com.example.ContactManagementSystem.dtos.response.*;
import com.example.ContactManagementSystem.exception.ContactNotFoundException;
import com.example.ContactManagementSystem.exception.InvalidPhoneNumberException;
import com.example.ContactManagementSystem.exception.NameCannotBeEmptyException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServicesImpl implements UserServices {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ContactServices contactServices;

    @Override
    public AddContactResponse addContact(AddContactRequest addContactRequest) {

        AddContactResponse addContactResponse = new AddContactResponse();

        User user = new User();
        user.setFirstName(addContactRequest.getFirstName());
        user.setLastName(addContactRequest.getLastName());
        if(!addContactRequest.getPhoneNumber().matches("[0-9]+"))throw new InvalidPhoneNumberException("Invalid " +
                "Phone Number");
        user.setPhoneNumber(addContactRequest.getPhoneNumber());
        User savedUser = userRepository.save(user);
//        Contact contact = contactServices.addContact(addContactRequest);

        addContactResponse.setId(savedUser.getId());
        addContactResponse.setFirstName(savedUser.getFirstName());
        addContactResponse.setLastName(savedUser.getLastName());
        addContactResponse.setPhoneNumber(savedUser.getPhoneNumber());




        return addContactResponse;

    }

    @Override
    public DeleteContactResponse deleteContact(DeleteContactRequest deleteContactRequest) {
//        if (!deleteContactRequest.getPhoneNumber().matches("[0-9]+"))throw new InvalidPhoneNumberException("Invalid " +
//                "Phone Number");
        User contactManagement =
                userRepository.searchByFirstName(deleteContactRequest.getFirstName());

       DeleteContactResponse deleteContactResponse = new DeleteContactResponse();

//        Contact contact = contactServices.searchForContact(deleteContactRequest.getFirstName());
//        if(contact == null)throw new ContactNotFoundException("Contact not found!");
//        List<Contact> contacts = contactManagement.getContacts();
//        contacts.remove(contact);
        if (contactManagement == null)throw new ContactNotFoundException("Contact Not Found");
        userRepository.delete(contactManagement);
//        contactServices.deleteContact(deleteContactRequest);

        deleteContactResponse.setDeleted(true);
//        deleteContactResponse.setId();

        return deleteContactResponse;
    }

    @Override
    public SearchForContactResponse searchForContact(String firstName) {
      User user = userRepository.searchByFirstName(firstName);
              contactServices.searchForContact(firstName);

       SearchForContactResponse searchForContactResponse = new SearchForContactResponse();

//        if(contactServices.searchForContact(firstName) == null) throw new NameCannotBeEmptyException("Enter name!");
        User contactManagement = userRepository.searchByFirstName(firstName);
       if(firstName.isEmpty()) throw new NameCannotBeEmptyException("Enter name!");
       if(firstName.isBlank()) throw new NameCannotBeEmptyException("Enter name!");
       if(userRepository.searchByFirstName(firstName)==null) throw new ContactNotFoundException("No contact found!");

       searchForContactResponse.setFirstName(contactManagement.getFirstName());
        userRepository.save(user);
       return searchForContactResponse;
    }

    @Override
    public EditContactResponse editContact(EditContactRequest editContactRequest) {
        com.example.ContactManagementSystem.dtos.response.EditContactResponse editContactResponse = new com.example.ContactManagementSystem.dtos.response.EditContactResponse();

        User contactManagement =
                userRepository.findByPhoneNumber(editContactRequest.getPhoneNumber());
        if(contactManagement==null) throw new ContactNotFoundException("No contact found!");

        if (editContactRequest.getFirstName() != null) contactManagement.setFirstName(editContactRequest.getFirstName());
        if (editContactRequest.getLastName() != null) contactManagement.setLastName(editContactRequest.getLastName());
        if (editContactRequest.getPhoneNumber() != null)contactManagement.setPhoneNumber(editContactRequest.getPhoneNumber());

        userRepository.searchByFirstName(editContactRequest.getExistingFirstName());
        editContactResponse.setFirstName(contactManagement.getFirstName());
        editContactResponse.setLastName(contactManagement.getLastName());
        editContactResponse.setPhoneNumber(contactManagement.getPhoneNumber());

//        return contactServices.editContact(editContactRequest);
        return editContactResponse;
    }

    @Override
    public ViewContactResponse viewContact(String firstName) {
        ViewContactResponse viewContactResponse = new ViewContactResponse();
        contactServices.viewContact(firstName);

        viewContactResponse.setFirstName(viewContactResponse.getFirstName());

        return viewContactResponse;

    }

    @Override
    public long count() {
        return userRepository.count();
    }
}
