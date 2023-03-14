package com.sociaMedia.service;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sociaMedia.entity.Comment;
import com.sociaMedia.entity.Friend;
import com.sociaMedia.entity.Group;
import com.sociaMedia.entity.Like;
import com.sociaMedia.entity.Message;
import com.sociaMedia.entity.Post;
import com.sociaMedia.entity.User;
import com.sociaMedia.repositoryDAO.*;

//@Service
//@Transactional
public class SocialMediaService {

	EntityManagerFactory emf = Persistence.createEntityManagerFactory("socialmedia");

	// I use Spring's dependency injection to inject the UserDao object into the
	// SocialMediaService class. @Autowired tells Spring to inject an instance of
	// the UserDao class into the userDao field

	@Autowired
	private UserDao userDao;
	@Autowired
	private GroupDao groupDao;
	@Autowired
	private MessageDao messageDao;
	@Autowired
	private CommentDao commentDao;
	@Autowired
	private FriendDao friendDao;
	@Autowired
	private LikeDao likeDao;

	// methods use the DAO classes to perform CRUD operations on the database

	// User methods

	public void addUser(User user) {
		userDao.save(user);
	}

	public User getUserById(Long id) {
		return userDao.getById(id);
	}

	public List<User> getAllUsers() {
		return userDao.getAll();
	}

	public void updateUser(User user) {
		userDao.update(user);
	}

	public void deleteUser(User user) {
		userDao.deleteUser(user);
	}

	public void addGroup(Group group) {
		groupDao.addGroup(group);
	}

	public Group getGroupById(Long id) {
		return groupDao.getGroupById(id);
	}

	public List<Group> getAllGroups() {
		return groupDao.getAllGroups();
	}

	public void addUserToGroup(Group group, User user) {
		groupDao.addUserToGroup(group, user);
	}

	public void removeUserFromGroup(Group group, User user) {
		groupDao.removeUserFromGroup(group, user);
	}

	public void deleteGroup(Long id) {
		groupDao.deleteGroup(id);
	}

	// Message methods
	public List<Message> getMessagesByUser(User user) {
	    EntityManager em = emf.createEntityManager();
	    List<Message> messages = null;
	    try {
	        em.getTransaction().begin();
	        TypedQuery<Message> query = em.createQuery("SELECT m FROM Message m WHERE m.receiver = :user OR m.sender = :user ORDER BY m.createdAt DESC", Message.class);
	        query.setParameter("user", user);
	        messages = query.getResultList();
	        em.getTransaction().commit();
	    } finally {
	        em.close();
	    }
	    return messages;
	}

	public Message postMessage(User sender, User receiver, String message) {
	    EntityManager em = emf.createEntityManager();
	    Message newMessage = new Message(receiver, sender, message);
	    newMessage.setSender(sender);
	    newMessage.setReceiver(receiver);
	    newMessage.setCreatedAt(LocalDateTime.now());
	    newMessage.setMessage(message);
	    try {
	        em.getTransaction().begin();
	        em.persist(newMessage);
	        em.getTransaction().commit();
	    } finally {
	        em.close();
	    }
	    return newMessage;
	}

	// Method to delete a message
	public void deleteMessage(Long messageId) {
		// Get message from database
		Message message = messageDao.getMessageById(messageId);

		// Check if message exists
		if (message == null) {
			throw new IllegalArgumentException("Message with ID " + messageId + " not found.");
		}

		// Delete message from database
		messageDao.deleteMessage(messageId);
	}


	// "Comment" methods
	// These methods include input validation to ensure that the message or comment
	// content is not empty, and error handling to handle cases where a message or
	// comment with the specified ID cannot be found in the database. The methods
	// use the MessageDao and CommentDao classes to interact with the database
	// Method to add a new comment
	public void addComment(Comment comment) {
		// Validate comment content
		if (comment.getContent() == null || comment.getContent().isEmpty()) {
			throw new IllegalArgumentException("Comment content cannot be empty.");
		}

		// Set comment creation time
		comment.setCreatedAt(LocalDateTime.now());

		// Add comment to database
		commentDao.save(comment);
	}

	// Method to delete a comment
	public void deleteComment(Long commentId) {
		// Get comment from database
		Comment comment = commentDao.getById(commentId);

		// Check if comment exists
		if (comment == null) {
			throw new IllegalArgumentException("Comment with ID " + commentId + " not found.");
		}

		// Delete comment from database
		commentDao.delete(comment);
	}

	public Comment getComment(Long id) {
		return commentDao.getById(id);
	}

	public List<Comment> getAllComments() {
		return commentDao.getAll();
	}

	// Friend methods

	public void addFriend(Friend friend) {
		friendDao.save(friend);
	}

	public Friend getFriendById(Long id) {
		return friendDao.getById(id);
	}

	public List<Friend> getAllFriends() {
		return friendDao.getAll();
	}

	public void updateFriend(Friend friend) {
		friendDao.update(friend);
	}

	public void deleteFriend(Friend friend) {
		friendDao.delete(friend);
	}

	// Like methods

	public void addLike(Like like) {
		likeDao.addLike(like);
	}

	public List<Like> getLikesByUserId(Long userId) {
		return likeDao.getLikesByUserId(userId);
	}

	public List<Like> getLikesByPostId(Long postId) {
		return likeDao.getLikesByPostId(postId);
	}

	public void removeLike(Like like) {
		likeDao.removeLike(like);
	}




// ??????????? other DAOs ????
	public void close() {
		groupDao.close();
		messageDao.close();
	}
}
