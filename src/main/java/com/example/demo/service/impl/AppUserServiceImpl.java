package com.example.demo.service.impl;

import com.example.demo.entity.AppUser;
import com.example.demo.repository.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AppUserServiceImpl {

    @Autowired
    private AppUserRepository userRepo;

    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    // Create a new user
    public AppUser createUser(AppUser user) {
        // encode password
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepo.save(user);
    }

    // Get all users
    public List<AppUser> getAllUsers() {
        return userRepo.findAll();
    }

    // Get user by ID
    public AppUser getUserById(Long id) {
        Optional<AppUser> userOpt = userRepo.findById(id);
        return userOpt.orElse(null);
    }

    // Update user
    public AppUser updateUser(Long id, AppUser userDetails) {
        Optional<AppUser> userOpt = userRepo.findById(id);
        if (userOpt.isPresent()) {
            AppUser user = userOpt.get();
            user.setUsername(userDetails.getUsername());
            user.setEmail(userDetails.getEmail());
            if (userDetails.getPassword() != null && !userDetails.getPassword().isEmpty()) {
                user.setPassword(passwordEncoder.encode(userDetails.getPassword()));
            }
            return userRepo.save(user);
        }
        return null;
    }

    // Delete user
    public boolean deleteUser(Long id) {
        if (userRepo.existsById(id)) {
            userRepo.deleteById(id);
            return true;
        }
        return false;
    }

    // Find user by username (optional)
    public AppUser findByUsername(String username) {
        Optional<AppUser> userOpt = userRepo.findByUsername(username);
        return userOpt.orElse(null);
    }
}
