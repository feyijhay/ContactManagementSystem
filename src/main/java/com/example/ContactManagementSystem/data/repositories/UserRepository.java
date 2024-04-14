package com.example.ContactManagementSystem.data.repositories;

import com.example.ContactManagementSystem.data.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {

    boolean existsByFirstName(String firstName);
    User searchByFirstName(String firstName);
    User findByPhoneNumber(String phoneNumber);
}
