package com.dev.usermanagement.Entity;

import javax.persistence.Entiy;


@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    private String password;

    // Getters and setters
}
