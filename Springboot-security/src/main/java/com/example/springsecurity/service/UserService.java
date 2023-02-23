package com.example.springsecurity.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.example.springsecurity.dto.UserRegistrationDto;
import com.example.springsecurity.model.User;

public interface UserService extends UserDetailsService {
   User findByEmail(String email);
   User save(UserRegistrationDto registration);
}