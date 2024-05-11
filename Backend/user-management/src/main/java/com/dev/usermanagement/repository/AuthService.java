package com.dev.usermanagement.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import com.dev.usermanagement.model.User;
import com.dev.usermanagement.util.JwtUtil;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    @Value("${jwt.secret}")
    private String SECRET_KEY;

    public String generateToken(User user) {
        return JwtUtil.generateToken(user.getEmail(), SECRET_KEY);
    }

    public boolean validateToken(String token) {
        return JwtUtil.validateToken(token, SECRET_KEY);
    }

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
        // Authenticate the user
        User user = userRepository.findByEmailAndPassword(email, password);
        if (user == null) {
            throw new RuntimeException("Invalid credentials");
        }
        return user;
    }
}
