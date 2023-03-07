package com.sociaMedia.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.sociaMedia.entity.User;
import com.sociaMedia.service.UserService;

@Controller
public class MainController {

//    @GetMapping("/")
//    public String root() {
//        return "index";
//    }
//	@Autowired
//	private UserService userService;


    @GetMapping("/login")
    public String login(Model model) {
        return "login";
    }

    @GetMapping("/user")
    public String userIndex() {
        return "user/index";
    }
    
//    @GetMapping("/profile")
//    public String showUserProfile(Model model, Principal principal) {
//        User user = userService.findByEmail(principal.getName());
//        model.addAttribute("user", user);
//        return "profile";
//    }

    
}


