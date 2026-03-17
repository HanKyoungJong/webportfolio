package com.webportfolio.career.presentation;

import com.webportfolio.career.application.CareerQueryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CareerController {
    private final CareerQueryService careerQueryService;

    public CareerController(CareerQueryService careerQueryService) {
        this.careerQueryService = careerQueryService;
    }

    @GetMapping("/careers")
    public String careers(Model model) {
        model.addAttribute("careers", careerQueryService.getAll());
        return "careers";
    }
}
