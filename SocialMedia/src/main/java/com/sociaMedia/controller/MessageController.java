package com.sociaMedia.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sociaMedia.entity.Message;
import com.sociaMedia.entity.User;
import com.sociaMedia.service.MessageService;
import com.sociaMedia.service.UserServiceImpl;

@RestController
@RequestMapping("/messages")
public class MessageController {

    private final MessageService messageService;
    private final UserServiceImpl userServiceImpl;

    @Autowired
    public MessageController(MessageService messageService, UserServiceImpl userServiceImpl) {
        this.messageService = messageService;
        this.userServiceImpl = userServiceImpl;
    }
    @GetMapping("/view")
    public String viewMessages() {
        return "messages";
    }

    @PostMapping("/")
    public ResponseEntity<?> sendMessage(@RequestBody Message message) {
        User sender = userServiceImpl.getUserById(message.getSender().getId());
        User receiver = userServiceImpl.getUserById(message.getReceiver().getId());

        if (sender == null || receiver == null) {
            return ResponseEntity.badRequest().body("Invalid user ID provided");
        }

        message.setSender(sender);
        message.setReceiver(receiver);
        message.setCreatedAt(LocalDateTime.now());

        messageService.saveMessage(message);

        return ResponseEntity.ok("Message sent successfully");
    }

    @GetMapping("/{senderId}/{receiverId}")
    public ResponseEntity<List<Message>> getMessagesBySenderAndReceiver(@PathVariable Long senderId, @PathVariable Long receiverId) {
        User sender = userServiceImpl.getUserById(senderId);
        User receiver = userServiceImpl.getUserById(receiverId);

        if (sender == null || receiver == null) {
            return ResponseEntity.badRequest().body(null);
        }

        List<Message> messages = messageService.getMessagesBySenderAndReceiver(sender, receiver);

        return ResponseEntity.ok(messages);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<List<Message>> getMessagesBySenderOrReceiver(@PathVariable Long userId) {
        User user = userServiceImpl.getUserById(userId);

        if (user == null) {
            return ResponseEntity.badRequest().body(null);
        }

        List<Message> messages = messageService.getMessagesBySenderOrReceiver(user);

        return ResponseEntity.ok(messages);
    }

    @DeleteMapping("/{messageId}")
    public ResponseEntity<?> deleteMessage(@PathVariable Long messageId) {
        Message message = messageService.getMessageById(messageId);

        if (message == null) {
            return ResponseEntity.badRequest().body("Invalid message ID provided");
        }

        messageService.deleteMessage(messageId);

        return ResponseEntity.ok("Message deleted successfully");
    }

}

