package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;
import com.example.demo.service.AppUserService;
import com.example.demo.entity.AppUser;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AppUserService userService;

    // Constructor injection (Spring will automatically inject the service bean)
    public AuthController(AppUserService userService) {
        this.userService = userService;
    }

    // Example endpoint
    @GetMapping("/user/{username}")
    public AppUser getUser(@PathVariable String username) {
        return userService.findByUsername(username);
    }
}
