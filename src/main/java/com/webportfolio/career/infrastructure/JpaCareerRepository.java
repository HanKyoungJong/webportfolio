package com.webportfolio.career.infrastructure;

import com.webportfolio.career.domain.Career;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JpaCareerRepository extends JpaRepository<Career, Long> {
    List<Career> findAllByOrderByIdAsc();
}
