package com.webportfolio.project.infrastructure;

import com.webportfolio.project.domain.Project;
import com.webportfolio.project.domain.ProjectRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProjectRepositoryAdapter implements ProjectRepository {
    private final JpaProjectRepository jpaProjectRepository;

    public ProjectRepositoryAdapter(JpaProjectRepository jpaProjectRepository) {
        this.jpaProjectRepository = jpaProjectRepository;
    }

    @Override
    public List<Project> findAllOrderById() {
        return jpaProjectRepository.findAllByOrderByIdAsc();
    }

    @Override
    public long count() {
        return jpaProjectRepository.count();
    }

    @Override
    public Project save(Project project) {
        return jpaProjectRepository.save(project);
    }
}
