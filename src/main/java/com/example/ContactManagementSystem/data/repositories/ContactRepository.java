package com.example.ContactManagementSystem.data.repositories;

import com.example.ContactManagementSystem.data.model.EditContactResponse;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ContactRepository extends MongoRepository<EditContactResponse, String> {
//    Contact findByFirstName(String firstName);

    EditContactResponse findByLastName(String lastName);

    EditContactResponse findByPhoneNumber(String phoneNumber);

    boolean existsContactsByFirstName(String firstName);

    EditContactResponse searchContactByFirstName(String firstName);
    EditContactResponse searchContactByPhoneNumber(String phoneNumber);


}
