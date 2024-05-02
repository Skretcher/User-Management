package com.dev.usermanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dev.usermanagement.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
