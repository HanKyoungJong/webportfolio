package com.webportfolio.project.domain;

import java.util.List;

public interface ProjectRepository {
    List<ProjectDetail> findAll();
}
