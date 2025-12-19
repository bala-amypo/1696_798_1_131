package com.example.demo.service.impl;

import org.springframework.stereotype.Service;
import com.example.demo.service.AppUserService;
import com.example.demo.entity.AppUser;
import com.example.demo.repository.AppUserRepository;

@Service  // <-- This tells Spring to treat this as a bean
public class AppUserServiceImpl implements AppUserService {

    private final AppUserRepository userRepo;

    // Constructor injection (recommended)
    public AppUserServiceImpl(AppUserRepository userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public AppUser findByUsername(String username) {
        return userRepo.findByUsername(username).orElse(null);
    }
}
