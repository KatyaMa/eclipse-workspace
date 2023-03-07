package com.sociaMedia.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sociaMedia.entity.Message;
import com.sociaMedia.entity.User;
import com.sociaMedia.repositoryDAO.MessageRepository;

import jakarta.persistence.TypedQuery;

@Service
public class MessageService {
    
    private final MessageRepository messageRepository;
//    private final UserService userService;

    @Autowired
    public MessageService(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    public Message saveMessage(Message message) {
        return messageRepository.save(message);
    }

    public List<Message> getMessagesBySenderAndReceiver(User sender, User receiver) {
        return messageRepository.findBySenderAndReceiverOrderByCreatedAtDesc(sender, receiver);
    }

    public List<Message> getMessagesBySenderOrReceiver(User user) {
        return messageRepository.findBySenderOrReceiverOrderByCreatedAtDesc(user, user);
    }
    
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
//	public List<Message> getMessagesBySenderAndReceiver(User sender, User receiver) {
//		TypedQuery<Message> query = entityManager.createQuery(
//				"SELECT m FROM Message m WHERE m.sender = :sender AND m.receiver = :receiver", Message.class);
//		query.setParameter("sender", sender);
//		query.setParameter("receiver", receiver);
//		return query.getResultList();
//	}
//
//	public void deleteMessage(Long id) {
//		entityManager.getTransaction().begin();
//		Message message = entityManager.find(Message.class, id);
//		entityManager.remove(message);
//		entityManager.getTransaction().commit();
//	}


}

