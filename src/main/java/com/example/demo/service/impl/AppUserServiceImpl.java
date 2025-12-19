package com.example.demo.service.impl;

import org.springframework.stereotype.Service;
import com.example.demo.service.AppUserService;
import com.example.demo.entity.AppUser;
import com.example.demo.repository.AppUserRepository;

@Service  // <-- This annotation is required
public class AppUserServiceImpl implements AppUserService {

    private final AppUserRepository userRepo;

    public AppUserServiceImpl(AppUserRepository userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public AppUser findByUsername(String username) {
        return userRepo.findByUsername(username).orElse(null);
    }
}
