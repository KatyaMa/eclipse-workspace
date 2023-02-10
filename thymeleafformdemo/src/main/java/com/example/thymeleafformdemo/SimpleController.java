package com.example.thymeleafformdemo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SimpleController {
	
	   @GetMapping("/login")
	    public String loginForm(Model model) {

	        model.addAttribute("mylogin", new LoginPOJO());
	        return "create-login";
	    }

	    @PostMapping("/save-login")
	    public String saveLoginSubmission(Model model, LoginPOJO mylogin) {
	    	System.out.println(">>>>>> IN saveLoginSubmission");
	    	System.out.println(">>>>>> uname="+mylogin.getUname());
	    	System.out.println(">>>>>> pass ="+mylogin.getPassword());
	        // TODO: 
	    	model.addAttribute("mylogin", mylogin);
	        return "login-result";
	    }

	    
	    
	    @GetMapping("/register")
	    public String registerForm(Model model) {

	        model.addAttribute("myRegister", new RegisterPOJO());
	        return "Register";
	    }

	    @PostMapping("/save-register")
	    public String saveRegisterSubmission(Model model, RegisterPOJO myRegister) {
	    	System.out.println(">>>>>> IN saveRegisterSubmission");
	    	System.out.println(">>>>>> uname="+myRegister.getUname());
	    	System.out.println(">>>>>> email="+myRegister.getEmail());
	    	System.out.println(">>>>>> pass ="+myRegister.getPassword());
	        // TODO: 
	    	model.addAttribute("myRegister", myRegister);
	        return "register-result";
	    }
}
