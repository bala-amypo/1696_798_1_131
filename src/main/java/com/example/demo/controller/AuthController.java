package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.AppUser; // Entity representing user
import com.example.demo.service.AuthService; // Service interface

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService; // Service interface

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody AppUser user) {
        boolean success = authService.register(user) != null;
        if(success) return ResponseEntity.ok("Registration successful");
        else return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("User already exists");
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody AppUser user) {
        boolean success = authService.login(user.getUsername(), user.getPassword()) != null;
        if(success) return ResponseEntity.ok("Login successful");
        else return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
    }
}
