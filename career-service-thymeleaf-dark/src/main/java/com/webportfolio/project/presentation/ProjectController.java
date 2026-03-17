package com.webportfolio.project.presentation;

import com.webportfolio.project.application.ProjectQueryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/projects")
public class ProjectController {

    private final ProjectQueryService projectQueryService;

    public ProjectController(ProjectQueryService projectQueryService) {
        this.projectQueryService = projectQueryService;
    }

    @GetMapping
    public String projects(Model model) {
        model.addAttribute("projects", projectQueryService.getAll());
        return "projects";
    }
}
