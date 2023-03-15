package com.sociaMedia.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sociaMedia.entity.Message;
import com.sociaMedia.entity.User;
import com.sociaMedia.repositoryDAO.MessageRepository;

@Service
public class MessageService {

	@Autowired
	private final MessageRepository messageRepository;

	public MessageService(MessageRepository messageRepository) {
		this.messageRepository = messageRepository;
	}

	public Message save(Message message) {
		return messageRepository.save(message);
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

	public List<Message> getAllMessages() {
		return messageRepository.findAll();
	}

	// for testing messages between
    public List<Message> getMessagesBetweenUsers(User user1, User user2) {
        List<Message> allMessages = getAllMessages();
        List<Message> result = new ArrayList<Message>();
        // loop through all messages and add the ones between the two users to the list
        for (Message message : allMessages) {
        	Long senderId = message.getSender().getId();
        	Long receiverId = message.getReceiver().getId();
        	if (Objects.equals(senderId, user1.getId()) && Objects.equals(receiverId, user2.getId())
        		||
        		Objects.equals(senderId, user2.getId()) && Objects.equals(receiverId, user1.getId())) {
        			result.add(message);        		
        		}
        }
        return result;
    }

}
