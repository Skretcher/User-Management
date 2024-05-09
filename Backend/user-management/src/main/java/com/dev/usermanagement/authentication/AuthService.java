package com.dev.usermanagement.authentication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dev.usermanagement.model.User;
import com.dev.usermanagement.repository.UserRepository;



@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    public void register(User user) {
        // Check if email already exists
        User existingUser = userRepository.findByEmail(user.getEmail());
        if (existingUser != null) {
            throw new RuntimeException("Email already exists");
        }

        // Save the user if email is unique
        userRepository.save(user);
    }

    public User login(String email, String password) {
        // Check if user with provided email exists
        User user = userRepository.findByEmail(email);
        if (user == null) {
            throw new RuntimeException("User not found. Please register.");
        }

        // Check if provided password matches the user's password
        if (!user.getPassword().equals(password)) {
            throw new RuntimeException("Incorrect password.");
        }

        // Authentication successful
        return user;
    }
}
