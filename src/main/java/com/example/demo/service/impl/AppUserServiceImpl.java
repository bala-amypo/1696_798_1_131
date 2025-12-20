package com.example.demo.service.impl;

import com.example.demo.dto.AuthResponse;
import com.example.demo.entity.AppUser;
import com.example.demo.entity.Role;
import com.example.demo.exception.BadRequestException;
import com.example.demo.repository.AppUserRepository;
import com.example.demo.security.JwtTokenProvider;
import com.example.demo.service.AppUserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service   // ✅ THIS IS CRITICAL
public class AppUserServiceImpl implements AppUserService {

    private final AppUserRepository userRepo;
    private final PasswordEncoder encoder;
    private final JwtTokenProvider tokenProvider;

    public AppUserServiceImpl(
            AppUserRepository userRepo,
            PasswordEncoder encoder,
            JwtTokenProvider tokenProvider) {
        this.userRepo = userRepo;
        this.encoder = encoder;
        this.tokenProvider = tokenProvider;
    }

    @Override
    public AuthResponse register(String email, String password, String role) {

        userRepo.findByEmail(email).ifPresent(u -> {
            throw new BadRequestException("email must be unique");
        });

        Role r = Role.builder().name(role).build();

        AppUser user = AppUser.builder()
                .email(email)
                .password(encoder.encode(password))
                .roles(Set.of(r))
                .active(true)
                .build();

        user = userRepo.save(user);

        String token = tokenProvider.createToken(user);

        return new AuthResponse(
                token,
                user.getId(),
                user.getEmail(),
                role
        );
    }

    @Override
    public AuthResponse login(String email, String password) {

        AppUser user = userRepo.findByEmail(email)
                .orElseThrow(() -> new BadRequestException("Invalid credentials"));

        if (!encoder.matches(password, user.getPassword())) {
            throw new BadRequestException("Invalid credentials");
        }

        String role = user.getRoles().iterator().next().getName();
        String token = tokenProvider.createToken(user);

        return new AuthResponse(
                token,
                user.getId(),
                user.getEmail(),
                role
        );
    }
}