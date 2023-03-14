package com.sociaMedia.repositoryDAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sociaMedia.entity.Message;
import com.sociaMedia.entity.Post;
import com.sociaMedia.entity.User;

public interface MessageRepository extends JpaRepository<Message, Long>{

//	List<Message> findBySenderOrReceiverOrderByCreatedAtDesc(User user, User user2);
//    @Query("SELECT m FROM Message m WHERE m.sender = :user OR m.receiver = :receiver ORDER BY m.createdAt DESC")
//    List<Message> findBySenderOrReceiverOrderByCreatedAtDesc(@Param("user") User user, @Param("receiver") User receiver);

    List<Message> findBySenderAndReceiver(User sender, User receiver);

}
