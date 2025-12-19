package com.example.demo.service;

import com.example.demo.entity.AppUser;

public interface AppUserService {
    AppUser findByUsername(String username);
}
