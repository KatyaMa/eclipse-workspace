package com.sociaMedia.controller;

//import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

//import com.sociaMedia.entity.User;
import com.sociaMedia.service.MessageService;
import com.sociaMedia.service.UserService;

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

	@GetMapping("/messages")
	public String viewMessages(Model model) {
		List<Message> messages = messageService.getAllMessages();
		List<User> users = userService.findAll();
		model.addAttribute("messages", messages);
		model.addAttribute("users", users);
		return "messages";
	}

	@GetMapping("/login")
	public String login(Model model) {
		return "login";
	}

//	@GetMapping("/user")
//	public String userIndex() {
//		return "user/index";
//	}

	@RequestMapping("/about")
	public String aboutPage() {
		return "about";
	}

	@RequestMapping("/contact")
	public String contactPage() {
		return "contact";
	}

}
