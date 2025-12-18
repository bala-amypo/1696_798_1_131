package com.example.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.entity.AuthService;  // your renamed AppUser entity
import com.example.demo.repository.AuthRepository; // assume you have this repo
import com.example.demo.service.AuthService as AuthServiceInterface;

@Service
public class AuthServiceImpl implements AuthServiceInterface {

    @Autowired
    private AuthRepository authRepo;

    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Override
    public boolean register(String username, String password) {
        if(authRepo.existsByUsername(username)) {
            return false; // user already exists
        }
        AuthService user = new AuthService();
        user.setUsername(username);
        user.setPassword(passwordEncoder.encode(password));
        authRepo.save(user);
        return true;
    }

    @Override
    public boolean login(String username, String password) {
        AuthService user = authRepo.findByUsername(username);
        if(user == null) return false;
        return passwordEncoder.matches(password, user.getPassword());
    }
}
