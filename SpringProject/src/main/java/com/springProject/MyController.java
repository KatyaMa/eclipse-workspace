package com.springProject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class MyController{
   @GetMapping("/")
   public String showIndex()
   {
	   System.out.println("IN  showIndex()");
                  return "index";
   }
}