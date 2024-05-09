package com.dev.usermanagement.repository;

import org.springframework.data.repository.CrudRepository;

import com.dev.usermanagement.model.User;


public interface UserRepository extends CrudRepository<User, Long> {
    User findByUsername(String username);
    User findByEmail(String email);
}

