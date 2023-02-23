package com.CRUD_API.repositiry;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.CRUD_API.Tutorial;

import java.util.List;
import java.util.Optional;

@Repository
public interface TutorialRepository extends JpaRepository<Tutorial, Long>
     // Tutorial → Entity type and Long --> primary key
{
     //   findByPublished is a custom method()
    List<Tutorial> findByPublished(boolean published);
}



// we can use JpaRepository’s methods: save(), findOne(), findById(), findAll(), count(), delete(), deleteById()… without implementing these methods.
