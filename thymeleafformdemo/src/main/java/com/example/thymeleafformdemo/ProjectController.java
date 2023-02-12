package com.example.thymeleafformdemo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

// sourced from from:
//
// https://attacomsian.com/blog/spring-boot-thymeleaf-form-handling
//

@Controller
public class ProjectController {

    @GetMapping("/create-project")
    public String createProjectForm(Model model) {

        model.addAttribute("project", new Project());
        return "create-project";
    }

    @PostMapping("/save-project")
    public String saveProjectSubmission(@ModelAttribute Project project, Model model)

 {

    	List<Project> projectList = new ArrayList<>();
		// TODO: save project in DB here
    	projectList.add(project);
    	model.addAttribute("projectList", projectList);

        return "result";
    }
    
}
