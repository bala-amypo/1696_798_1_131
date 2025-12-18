package com.example.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.AppUser; // Your user entity
import com.example.demo.repository.AppUserRepository; // Repository
import com.example.demo.service.AuthService; // Service interface

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private AppUserRepository userRepository;

    @Override
    public AppUser register(AppUser user) {
        if(userRepository.existsByUsername(user.getUsername())) {
            return null; // User already exists
        }
        return userRepository.save(user);
    }

    @Override
    public AppUser login(String username, String password) {
        AppUser user = userRepository.findByUsername(username);
        if(user != null && user.getPassword().equals(password)) {
            return user;
        }
        return null;
    }
}
