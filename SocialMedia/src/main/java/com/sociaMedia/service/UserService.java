package com.sociaMedia.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.sociaMedia.dto.UserRegistrationDto;
import com.sociaMedia.entity.User;


public interface UserService extends UserDetailsService {
	   User findByEmail(String email);
	   User save(UserRegistrationDto registration);
	}
