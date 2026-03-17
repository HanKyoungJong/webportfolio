package com.webportfolio.intro.presentation;

import com.webportfolio.intro.application.IntroQueryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IntroController {

    private final IntroQueryService introQueryService;

    public IntroController(IntroQueryService introQueryService) {
        this.introQueryService = introQueryService;
    }

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("profile", introQueryService.getProfile());
        return "index";
    }

    @GetMapping("/health")
    public String health(Model model) {
        model.addAttribute("status", "OK");
        return "health";
    }
}
