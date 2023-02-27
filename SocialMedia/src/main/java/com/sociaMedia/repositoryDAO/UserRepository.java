package com.sociaMedia.repositoryDAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sociaMedia.entity.User;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {
  User findByEmail(String email);
}

