package com.sociaMedia.controller;

import com.sociaMedia.entity.Post;
import com.sociaMedia.entity.User;
import com.sociaMedia.repositoryDAO.PostRepository;
import com.sociaMedia.repositoryDAO.UserRepository;
import com.sociaMedia.service.UserService;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;

@Controller
public class PostController {

	@Autowired
	private PostRepository postRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private UserService userService;

	@GetMapping("/new-post")
	public String showNewPostForm(Model model) {
		List<Post> posts = postRepository.findAll();
		model.addAttribute("posts", posts);
		model.addAttribute("post", new Post());
		return "index";
	}

	@PostMapping("/submit")
	public String handleSubmit(@RequestParam("message") String message,
			@AuthenticationPrincipal UserDetails userDetails, Model model) {
		User user = userService.findByEmail(userDetails.getUsername());

		Post post = new Post();
		post.setMessage(message);
		post.setCreatedAt(LocalDateTime.now());
		post.setUser(user);
		postRepository.save(post);

		model.addAttribute("success", true);
		return "redirect:/"; // redirect to the home page after creating the post
	}
}
