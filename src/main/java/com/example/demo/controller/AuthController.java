package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.AppUser;
import com.example.demo.service.AuthService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/auth")
@Tag(name = "Authentication Controller")
public class AuthController {

    @Autowired
    private AuthService authService;

    @Operation(summary = "Register user")
    @PostMapping("/register")
    public AppUser register(@RequestBody AppUser user) {
        return authService.register(user);
    }

    @Operation(summary = "Login user")
    @PostMapping("/login")
    public String login(@RequestBody AppUser user) {
        return authService.login(user);
    }
}
