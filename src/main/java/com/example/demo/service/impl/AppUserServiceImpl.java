package com.example.demo.service.impl;

import com.example.demo.entity.AppUser;
import com.example.demo.exception.BadRequestException;
import com.example.demo.repository.AppUserRepository;
import com.example.demo.service.AppUserService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class AppUserServiceImpl implements AppUserService {

    private final AppUserRepository appUserRepository;
    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    // Constructor injection (single dependency – test safe)
    public AppUserServiceImpl(AppUserRepository appUserRepository) {
        this.appUserRepository = appUserRepository;
    }

    @Override
    public String register(String email, String password, String role) {

        if (appUserRepository.findByEmail(email) != null) {
            throw new BadRequestException("email unique");
        }

        AppUser user = AppUser.builder()
                .email(email)
                .password(passwordEncoder.encode(password))
                .roles(Set.of(role))
                .active(true)
                .build();

        appUserRepository.save(user);
        return "User registered successfully";
    }

    @Override
    public String login(String email, String password) {

        AppUser user = appUserRepository.findByEmail(email);
        if (user == null) {
            throw new BadRequestException("not found");
        }

        if (!passwordEncoder.matches(password, user.getPassword())) {
            throw new BadRequestException("invalid credentials");
        }

        return "Login successful";
    }
}
