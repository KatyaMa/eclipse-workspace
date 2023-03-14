package com.sociaMedia.repositoryDAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sociaMedia.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

	User findByEmail(String email);

	List<User> findAll();

}
