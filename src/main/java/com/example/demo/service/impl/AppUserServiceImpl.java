package com.example.demo.service.impl;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.entity.AppUser;
import com.example.demo.repository.AppUserRepository;
import com.example.demo.service.AppUserService;

@Service
public class AppUserServiceImpl implements AppUserService {

    @Autowired
    private AppUserRepository repo;

    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    @Override
    public AppUser register(String email, String password, String role) {

        AppUser user = new AppUser();
        user.setEmail(email);
        user.setPassword(encoder.encode(password));
        user.setRoles(Set.of(role));
        user.setActive(true);

        return repo.save(user);
    }

    @Override
    public String login(String email, String password) {

        AppUser user = repo.findByEmail(email).orElse(null);

        if (user != null && encoder.matches(password, user.getPassword())) {
            return "Login Successful";
        }
        return "Invalid Credentials";
    }
}
