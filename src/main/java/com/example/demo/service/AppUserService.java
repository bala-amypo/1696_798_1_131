package com.example.demo.service;

import com.example.demo.dto.AuthResponse;

public interface AppUserService {
    AuthResponse register(String email, String password, String role);
    AuthResponse login(String email, String password);
}