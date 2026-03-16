package com.webportfolio.career.application;

import com.webportfolio.career.domain.Career;
import com.webportfolio.career.domain.CareerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CareerQueryService {

    private final CareerRepository careerRepository;

    public CareerQueryService(CareerRepository careerRepository) {
        this.careerRepository = careerRepository;
    }

    public List<Career> getAll() {
        return careerRepository.findAll();
    }
}
