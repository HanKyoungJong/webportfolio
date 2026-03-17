package com.webportfolio.intro.presentation;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IntroController {
    @GetMapping("/")
    public String home() { return "index"; }

    @GetMapping("/health")
    public String health() { return "health"; }
}
