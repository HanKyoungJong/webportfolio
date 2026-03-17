package com.webportfolio.project.application;

import com.webportfolio.project.domain.ProjectDetail;
import com.webportfolio.project.domain.ProjectRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectQueryService {

    private final ProjectRepository projectRepository;

    public ProjectQueryService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    public List<ProjectDetail> getAll() {
        return projectRepository.findAll();
    }
}
