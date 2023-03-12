package com.sociaMedia.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.sociaMedia.dto.UserRegistrationDto;
import com.sociaMedia.entity.User;

// implements the UserService interface, which is used by Spring Security to load user details during authentication

public interface UserService extends UserDetailsService {
	User findByEmail(String email);

	User save(UserRegistrationDto registration);

	User getUserById(Long id);

	List<User> findAll();

	User findById(Long receiverId);
	
	
}
