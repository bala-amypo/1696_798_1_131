package com.example.demo.service;

import com.example.demo.entity.AppUser;

public interface AuthService {
    boolean register(String username, String password);
    boolean login(String username, String password);
}
