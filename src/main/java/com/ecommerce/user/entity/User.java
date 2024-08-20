package com.ecommerce.user.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "user")
@Data
public class User {
    @Column(name="email")
    private String email;

    @Column(name="password")
    private String password;

    public User() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    public User(String email, String password) {
        this.email = email;
        this.password = password;

    }
}