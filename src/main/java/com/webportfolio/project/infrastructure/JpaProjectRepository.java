package com.webportfolio.project.infrastructure;

import com.webportfolio.project.domain.Project;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JpaProjectRepository extends JpaRepository<Project, Long> {
    List<Project> findAllByOrderByIdAsc();
}
