package com.webportfolio.project.domain;

import java.util.List;

public interface ProjectRepository {
    List<Project> findAllOrderById();
    long count();
    Project save(Project project);
}
