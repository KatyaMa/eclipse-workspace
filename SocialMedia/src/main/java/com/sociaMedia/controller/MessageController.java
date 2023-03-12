package com.sociaMedia.controller;

import java.security.Principal;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sociaMedia.entity.Message;
import com.sociaMedia.entity.Post;
import com.sociaMedia.entity.User;
import com.sociaMedia.repositoryDAO.MessageRepository;
import com.sociaMedia.repositoryDAO.UserRepository;
import com.sociaMedia.service.MessageService;
import com.sociaMedia.service.UserService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.ui.Model;

@RestController
@RequestMapping("/messages")
public class MessageController {

    private final MessageService messageService;
    private final UserService userService;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private MessageRepository messageRepository;


    @Autowired
    public MessageController(MessageService messageService, UserService userService) {
        this.messageService = messageService;
        this.userService = userService;
    }
//    @GetMapping("view")
//    public String viewMessages(Model model) {
//        List<Message> messages = messageService.getAllMessages();
//        model.addAttribute("messages", messages);
//        return "messages";
//    }

//    @PostMapping("/messages/send")
//    public String sendMessage(@RequestParam("message") String message,
//                               @RequestParam("receiverId") Long receiverId,
//                               Authentication authentication) {
//
//        // get the currently authenticated user
//        User sender = userService.findByEmail(authentication.getName());
//
//        // get the receiver
//        User receiver = userService.findById(receiverId);
//
//        // create a new message
//        Message newMessage = new Message(sender, receiver, message);
//
//        // save the message to the database
//        messageService.save(newMessage);
//
//        return "redirect:/messages";
//    }

    

    
    @PostMapping("/send")
    public String sendMessage(@RequestParam("message") String message,
//                                           @RequestParam("receiverId") Long receiverId,
//                                           Authentication authentication) 
                                           @AuthenticationPrincipal UserDetails userDetails, Model model)
                                           {

        // get the currently authenticated user
        User sender = userService.findByEmail(userDetails.getUsername());

        // get the receiver
        Long receiverId = (long) 2;
        User receiver = userService.findById(receiverId);

//        if (receiver == null) {
//            return ResponseEntity.badRequest().body("Receiver not found");
//        }

        // create a new message
//        Message newMessage = new Message(sender, receiver, message);
        Message newMessage = new Message();
        newMessage.setMessage(message);
        newMessage.setCreatedAt(LocalDateTime.now());
        newMessage.setSender(sender);
        newMessage.setReceiver(receiver);

        messageRepository.save(newMessage);
        
        model.addAttribute("success", true);
        return "redirect:/messages"; // redirect to the messages page after creating the message
	
        		
        
        
        // save the message to the database
//    messageService.save(newMessage);

//        return ResponseEntity.ok().build();
    }

    
    // method that retrieves all user from the repository and adds them to the model (to be display on messages.html)
//    @GetMapping("/")
//    public String getMessagePage(Model model) {
//        List<User> users = userService.getAllUsers();
//        model.addAttribute("users", users);
//        return "message";
//    }

    
    
//    @PostMapping("/")
//    public ResponseEntity<?> sendMessage(@RequestBody Message message) {
//        User sender = userService.getUserById(message.getSender().getId());
//        User receiver = userService.getUserById(message.getReceiver().getId());
//
//        if (sender == null || receiver == null) {
//            return ResponseEntity.badRequest().body("Invalid user ID provided");
//        }
//
//        message.setSender(sender);
//        message.setReceiver(receiver);
//        message.setCreatedAt(LocalDateTime.now());
//
//        messageService.saveMessage(message);
//
//        return ResponseEntity.ok("Message sent successfully");
//    }
    
    @PostMapping
    public ResponseEntity<?> sendMessage(@RequestParam Long receiverId, @RequestBody Message message, Principal principal) {
        User sender = userRepository.findByEmail(principal.getName());
        User receiver = userRepository.findById(receiverId).orElseThrow(() -> new IllegalArgumentException("Receiver not found"));
        message.setSender(sender);
        message.setReceiver(receiver);
        messageRepository.save(message);
        return ResponseEntity.ok().build();
    }



    @GetMapping("/{receiverId}")
    public List<Message> getChat(@PathVariable Long receiverId, Principal principal) {
        User sender = userRepository.findByEmail(principal.getName());
        User receiver = userRepository.findById(receiverId).orElseThrow(() -> new IllegalArgumentException("Invalid receiver id"));
        return messageRepository.findBySenderAndReceiver(sender, receiver);
    }

    
    
    
    
    
    

//    @GetMapping("/{senderId}/{receiverId}")
//    public ResponseEntity<List<Message>> getMessagesBySenderAndReceiver(@PathVariable Long senderId, @PathVariable Long receiverId) {
//        User sender = userService.getUserById(senderId);
//        User receiver = userService.getUserById(receiverId);
//
//        if (sender == null || receiver == null) {
//            return ResponseEntity.badRequest().body(null);
//        }
//
//        List<Message> messages = messageService.getMessagesBySenderAndReceiver(sender, receiver);
//
//        return ResponseEntity.ok(messages);
//    }

//    @GetMapping("/{userId}")
//    public ResponseEntity<List<Message>> getMessagesBySenderOrReceiver(@PathVariable Long userId) {
//        User user = userService.getUserById(userId);
//
//        if (user == null) {
//            return ResponseEntity.badRequest().body(null);
//        }
//
//        List<Message> messages = messageService.getMessagesBySenderOrReceiver(user);
//
//        return ResponseEntity.ok(messages);
//    }

    @DeleteMapping("/{messageId}")
    public ResponseEntity<?> deleteMessage(@PathVariable Long messageId) {
        Message message = messageService.getMessageById(messageId);

        if (message == null) {
            return ResponseEntity.badRequest().body("Invalid message ID provided");
        }

        messageService.deleteMessage(messageId);

        return ResponseEntity.ok("Message deleted successfully");
    }
    @GetMapping("/messages")
    public String getMessages(Model model) {
        List<User> users = userRepository.findAll();
        model.addAttribute("users", users);
        return "messages";
    }

    // for testing. to be deleted
//    @PostMapping("/send")
//    public String sendMessagePost(@RequestParam User sender, @RequestParam User receiver, @RequestParam String message) {
//        Message newMessage = new Message(sender, receiver, message);
//        messageRepository.save(newMessage);
//        return "Message sent successfully!";
//    }

    
}

