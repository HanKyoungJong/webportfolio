package com.webportfolio.career.presentation;

import com.webportfolio.career.application.CareerQueryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/careers")
public class CareerController {

    private final CareerQueryService careerQueryService;

    public CareerController(CareerQueryService careerQueryService) {
        this.careerQueryService = careerQueryService;
    }

    @GetMapping
    public String careers(Model model) {
        model.addAttribute("careers", careerQueryService.getAll());
        return "careers";
    }
}
