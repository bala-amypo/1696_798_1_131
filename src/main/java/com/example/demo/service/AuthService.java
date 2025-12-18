package com.example.demo.service;

public interface AuthService {
    boolean login(String username, String password);
    boolean register(String username, String password);
}
