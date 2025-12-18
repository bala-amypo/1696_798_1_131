package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.AuthService;
import com.example.demo.service.AuthService as AuthServiceInterface;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthServiceInterface authService;

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody AuthService user) {
        boolean success = authService.register(user.getUsername(), user.getPassword());
        if(success) return ResponseEntity.ok("Registration successful");
        else return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("User already exists");
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody AuthService user) {
        boolean success = authService.login(user.getUsername(), user.getPassword());
        if(success) return ResponseEntity.ok("Login successful");
        else return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
    }
}
