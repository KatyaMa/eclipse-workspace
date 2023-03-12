package com.sociaMedia.repositoryDAO;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sociaMedia.entity.User;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	
  User findByEmail(String email);
  
//  @Query("SELECT u FROM User u")
  List<User> findAll();
//  User findByEmail(String email);

}

