package com.example.backend_ksero_orders.microservices.security.entity;

import lombok.Data;

@Data
public class User {
    private Long id;
    private String username;
    private String email;
}