package com.sociaMedia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

//import com.sociaMedia.entity.User;
import com.sociaMedia.service.MessageService;
import com.sociaMedia.service.UserService;

import java.util.ArrayList;
//import com.sociaMedia.service.UserService;
import java.util.List;
import com.sociaMedia.entity.Message;
import com.sociaMedia.entity.Post;
import com.sociaMedia.entity.User;
import com.sociaMedia.repositoryDAO.PostRepository;

@Controller
public class MainController {

	@Autowired
	private MessageService messageService;

	@Autowired
	private PostRepository postRepository;

	@Autowired
	private UserService userService;

	// all posts from the repository and adds them to the model
	@GetMapping("/")
	public String showHomePage(@AuthenticationPrincipal UserDetails userDetails, Model model) {
		// get the currently authenticated user
		User user = userService.findByEmail(userDetails.getUsername());

		List<Post> posts = postRepository.findAllByOrderByCreatedAtDesc();
		model.addAttribute("posts", posts);
		model.addAttribute("user", user);
		return "index";
	}

//	@GetMapping("/messages")
//	public String viewMessages(@AuthenticationPrincipal UserDetails userDetails, Model model) {
//		User sender = userService.findByEmail(userDetails.getUsername());
//		List<User> users = userService.findAllExcept(sender);
//		List<Message> messages = messageService.getAllMessages();
//		model.addAttribute("messages", messages);
//		model.addAttribute("users", users);
//		return "messages";
//	}

	// for testing messages, might need to be deleted
	@GetMapping("/messages")
	public String viewMessages(@AuthenticationPrincipal UserDetails userDetails, @RequestParam(name = "receiverId", required = false) Long receiverId, Model model) {
	    User sender = userService.findByEmail(userDetails.getUsername());
	    List<User> users = userService.findAllExcept(sender);
	    model.addAttribute("users", users);

	    if (receiverId != null) {
	        User receiver = userService.findById(receiverId);
	        List<Message> messages = messageService.getMessagesBetweenUsers(sender, receiver);
	        model.addAttribute("messages", messages);
	        model.addAttribute("receiver", receiver);
	    } else {
	        // If receiverId is null, get messages between the sender and the first user in the list
//	        List<Message> messages = messageService.getAllMessages();
	        model.addAttribute("messages", new ArrayList<Message>());
	    }

	    return "messages";
	}

	@GetMapping("/login")
	public String login(Model model) {
		return "login";
	}

	@RequestMapping("/about")
	public String aboutPage() {
		return "about";
	}

	@RequestMapping("/contact")
	public String contactPage() {
		return "contact";
	}

}
