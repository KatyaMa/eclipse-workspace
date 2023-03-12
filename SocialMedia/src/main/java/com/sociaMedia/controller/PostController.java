package com.sociaMedia.controller;

import com.sociaMedia.entity.Post;
import com.sociaMedia.entity.User;
import com.sociaMedia.repositoryDAO.PostRepository;
import com.sociaMedia.repositoryDAO.UserRepository;
import com.sociaMedia.service.UserService;

import java.util.List;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


import java.security.Principal;
import java.time.LocalDateTime;

@Controller
public class PostController {

    @Autowired
    private PostRepository postRepository;
    
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

//    private static final Logger log = LoggerFactory.getLogger(PostController.class);

    @GetMapping("/new-post")
    public String showNewPostForm(Model model) {
        List<Post> posts = postRepository.findAll();
        model.addAttribute("posts", posts);
        model.addAttribute("post", new Post());
        return "index";
    }

    
    @PostMapping("/submit")
    public String handleSubmit(@RequestParam("message") String message, @AuthenticationPrincipal UserDetails userDetails, Model model) {
        User user = userService.findByEmail(userDetails.getUsername());

        Post post = new Post();
        post.setMessage(message);
        post.setCreatedAt(LocalDateTime.now());
        post.setUser(user);
        postRepository.save(post);
        
        model.addAttribute("success", true);
        return "redirect:/"; // redirect to the home page after creating the post
    }
    
    
    
    // method that retrieves all posts from the repository and adds them to the model
    @GetMapping("/")
    public String showHomePage(Model model) {
    	
        List<Post> posts = postRepository.findAllByOrderByCreatedAtDesc();
        model.addAttribute("posts", posts);
        return "index";
    }
    
    
    // for testing findAll()
//    @GetMapping("/test")
//    public String home(Model model) {
//        List<Post> posts = postRepository.findAll();
//        model.addAttribute("posts", posts);
//        log.debug("Retrieved all posts from the repository: {}", posts);
//        return "home";
//    }


}
