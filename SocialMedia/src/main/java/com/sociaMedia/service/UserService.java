package com.sociaMedia.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.sociaMedia.dto.UserRegistrationDto;
import com.sociaMedia.entity.User;

// implements the UserDetailsService interface, which is used by Spring Security to load user details during authentication

public interface UserService extends UserDetailsService {
	User findByEmail(String email);

	User save(UserRegistrationDto registration);
}
