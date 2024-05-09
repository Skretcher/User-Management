package com.dev.usermanagement.service;


import com.dev.usermanagement.model.User;

import java.util.List;

public interface UserService {
    User getUser(Long id);
    List<User> getAllUsers();
    void createUser(User user);
    void updateUser(User user);
    void deleteUser(Long id);
}
