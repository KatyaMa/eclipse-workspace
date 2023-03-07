package com.sociaMedia.service;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.sociaMedia.dto.UserRegistrationDto;
import com.sociaMedia.entity.Role;
import com.sociaMedia.entity.User;
import com.sociaMedia.repositoryDAO.UserRepository;


@Service
public class UserServiceImpl implements UserService {

   @Autowired
   private UserRepository userRepository;

   @Autowired
   private BCryptPasswordEncoder passwordEncoder;

   public User findByEmail(String email){
       return userRepository.findByEmail(email);
   }

   public User save(UserRegistrationDto registration){
       User user = new User();
       user.setFirstName(registration.getFirstName());
       user.setLastName(registration.getLastName());
       user.setEmail(registration.getEmail());
       user.setPassword(passwordEncoder.encode(registration.getPassword()));
       user.setRoles(Arrays.asList(new Role("ROLE_USER")));
       return userRepository.save(user);
   }

   public User getUserById(Long userId) {
       Optional<User> userOptional = userRepository.findById(userId);
       if (userOptional.isPresent()) {
           return userOptional.get();
       } else {
           throw new RuntimeException("User not found");
       }
   }

   public List<User> getAllUsers() {
       return userRepository.findAll();
   }

   public void deleteUser(Long userId) {
       userRepository.deleteById(userId);
   }

   @Override
   public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
       User user = userRepository.findByEmail(email);
       if (user == null){
           throw new UsernameNotFoundException("Invalid username or password.");
       }
       return new org.springframework.security.core.userdetails.User(user.getEmail(),
               user.getPassword(),
               mapRolesToAuthorities(user.getRoles()));
   }

   private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles){
       return roles.stream()
               .map(role -> new SimpleGrantedAuthority(role.getName()))
               .collect(Collectors.toList());
   }
}
