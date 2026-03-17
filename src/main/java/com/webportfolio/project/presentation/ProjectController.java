package com.webportfolio.project.presentation;

import com.webportfolio.project.application.ProjectQueryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProjectController {
    private final ProjectQueryService projectQueryService;

    public ProjectController(ProjectQueryService projectQueryService) {
        this.projectQueryService = projectQueryService;
    }

    @GetMapping("/projects")
    public String projects(Model model) {
        model.addAttribute("projects", projectQueryService.getAll());
        return "projects";
    }
}
