package com.dev.usermanagement.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.dev.usermanagement.Entity.User;
import com.dev.usermanagement.Services.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public User registerUser(@RequestBody User user) {
        return userService.save(user);
    }

    @GetMapping("/{username}")
    public User getUserByUsername(@PathVariable String username) {
        return userService.findByUsername(username);
    }

    // Other CRUD endpoints
}

