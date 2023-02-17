package com.RestAPI;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;

@Controller
public class MovieController {
	
    @GetMapping("/movie")
    public String searchMovie(@RequestParam(name = "title") String title, Model model) {
        try {
            String response = MovieApiClient.searchMovie(title);
            model.addAttribute("movie", response);
            return "movie";
        } catch (IOException e) {
            e.printStackTrace();
            return "error";
        }
    }
}
