package com.webportfolio.career.infrastructure;

import com.webportfolio.career.domain.Career;
import com.webportfolio.career.domain.CareerRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CareerRepositoryAdapter implements CareerRepository {
    private final JpaCareerRepository jpaCareerRepository;

    public CareerRepositoryAdapter(JpaCareerRepository jpaCareerRepository) {
        this.jpaCareerRepository = jpaCareerRepository;
    }

    @Override
    public List<Career> findAllOrderById() {
        return jpaCareerRepository.findAllByOrderByIdAsc();
    }

    @Override
    public long count() {
        return jpaCareerRepository.count();
    }

    @Override
    public Career save(Career career) {
        return jpaCareerRepository.save(career);
    }
}
