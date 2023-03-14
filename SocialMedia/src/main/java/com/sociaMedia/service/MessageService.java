package com.sociaMedia.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sociaMedia.entity.Message;
import com.sociaMedia.entity.User;
import com.sociaMedia.repositoryDAO.MessageRepository;
import com.sociaMedia.repositoryDAO.UserRepository;

import jakarta.persistence.TypedQuery;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

@Service
public class MessageService {
    
	@Autowired
    private final MessageRepository messageRepository;
//    private final UserService userService;

    @Autowired
    private UserRepository userRepository;
	private EntityManagerFactory entityManagerFactory;
	private EntityManager entityManager;

    public MessageService(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }
    

    public void sendMessage(Long senderId, Long receiverId, String message) {
        User sender = userRepository.findById(senderId).orElseThrow(() -> new IllegalArgumentException("Invalid sender ID"));
        User receiver = userRepository.findById(receiverId).orElseThrow(() -> new IllegalArgumentException("Invalid receiver ID"));
        LocalDateTime now = LocalDateTime.now();
        Message newMessage = new Message(sender, receiver, message);
        newMessage.setSender(sender);
        newMessage.setReceiver(receiver);
        newMessage.setCreatedAt(now);
        newMessage.setMessage(message);
        messageRepository.save(newMessage);
    }

    
    public Message save(Message message) {
        return messageRepository.save(message);
    }

//    public List<Message> getMessagesBySenderAndReceiver(User sender, User receiver) {
//        return messageRepository.findBySenderAndReceiverOrderByCreatedAtDesc(sender, receiver);
//    }
//
//    public List<Message> getMessagesBySenderOrReceiver(User user) {
//        return messageRepository.findBySenderOrReceiverOrderByCreatedAtDesc(user, user);
//    }
    
    public void deleteMessage(Long messageId) {
        messageRepository.deleteById(messageId);
    }

    public Message getMessageById(Long messageId) {
        Optional<Message> messageOptional = messageRepository.findById(messageId);
        if (messageOptional.isPresent()) {
            return messageOptional.get();
        } else {
            throw new RuntimeException("Message not found");
        }
    }

    public List<Message> getAllMessages() {
        return messageRepository.findAll();
    }


    
    
    // Now you can use the methods of the messageRepository to interact with the database.
//	public Message getMessageById(Long id) {
//		return entityManager.find(Message.class, id);
//	}
//
//	public List<Message> getAllMessages() {
//		TypedQuery<Message> query = entityManager.createQuery("SELECT m FROM Message m", Message.class);
//		return query.getResultList();
//	}
//
	public List<Message> getMessagesBySenderAndReceiver(User sender, User receiver) {
		TypedQuery<Message> query = entityManager.createQuery(
				"SELECT m FROM Message m WHERE m.sender = :sender AND m.receiver = :receiver", Message.class);
		query.setParameter("sender", sender);
		query.setParameter("receiver", receiver);
		return query.getResultList();
	}
//
//	public void deleteMessage(Long id) {
//		entityManager.getTransaction().begin();
//		Message message = entityManager.find(Message.class, id);
//		entityManager.remove(message);
//		entityManager.getTransaction().commit();
//	}


}

