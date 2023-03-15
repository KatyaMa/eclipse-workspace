package com.sociaMedia.controller;

import java.security.Principal;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
import org.springframework.web.servlet.view.RedirectView;

import com.sociaMedia.entity.Message;
import com.sociaMedia.entity.User;
import com.sociaMedia.repositoryDAO.MessageRepository;
import com.sociaMedia.repositoryDAO.UserRepository;
import com.sociaMedia.service.MessageService;
import com.sociaMedia.service.UserService;

@RestController
@RequestMapping("/messages")
public class MessageController {

	private final MessageService messageService;
	private final UserService userService;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private MessageRepository messageRepository;

	public MessageController(MessageService messageService, UserService userService) {
		this.messageService = messageService;
		this.userService = userService;
	}

	@PostMapping("/send")
	public RedirectView sendMessage(@RequestParam("message") String message,
			@RequestParam("receiverId") Long receiverId, @AuthenticationPrincipal UserDetails userDetails,
			Model model) {
		// get the currently authenticated user
		User sender = userService.findByEmail(userDetails.getUsername());

		// get the receiver
		User receiver = userService.findById(receiverId);

		// create a new message
		Message newMessage = new Message();
		newMessage.setMessage(message);
		newMessage.setCreatedAt(LocalDateTime.now());
		newMessage.setSender(sender);
		newMessage.setReceiver(receiver);

		// save the message to the database
		messageRepository.save(newMessage);

		model.addAttribute("success", true);
		return new RedirectView("/messages?receiverId=" + receiver.getId()); // redirect to the messages page after creating the message
	}

	@GetMapping("/{receiverId}")
	public String getChat(@PathVariable Long receiverId, @AuthenticationPrincipal UserDetails userDetails,
			Model model) {
		// get the currently authenticated user
		User sender = userService.findByEmail(userDetails.getUsername());

		// get the receiver
		User receiver = userService.findById(receiverId);

		List<Message> messages = messageRepository.findBySenderAndReceiver(sender, receiver);
		model.addAttribute("sender", sender);
		model.addAttribute("receiver", receiver);
		model.addAttribute("messages", messages);

		return "messages";
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
