package com.dev.usermanagement.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dev.usermanagement.model.User;


@Repository
public interface UserRepository extends CrudRepository<User, Long> {
   
    User findByEmail(String email);
    User findByEmailAndPassword (String email, String password);
}

