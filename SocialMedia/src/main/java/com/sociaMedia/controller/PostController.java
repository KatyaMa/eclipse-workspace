package com.sociaMedia.controller;

import com.sociaMedia.entity.Post;
import com.sociaMedia.repositoryDAO.PostRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.time.LocalDateTime;

@Controller
public class PostController {

    @Autowired
    private PostRepository postRepository;

    @GetMapping("/posts/new")
    public String showNewPostForm(Model model) {
        model.addAttribute("post", new Post());
        return "createPost";
    }

    @PostMapping("/posts")
    public String createPost(@Valid @ModelAttribute("post") Post post, BindingResult result) {
        if (result.hasErrors()) {
            return "createPost";
        }

        post.setCreatedAt(LocalDateTime.now());
        postRepository.save(post);

        return "redirect:/posts";
    }
}
