package com.example.springdatajpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import com.example.springdatajpa.model.Tutorial;

@RepositoryRestResource(path = "learningtutorials")
public interface TutorialRepository extends JpaRepository<Tutorial, Long>
     // Tutorial → Entity type and Long --> primary key
{
     //   findByPublished is a custom method()
    List<Tutorial> findByPublished(boolean published);
}