package com.webportfolio.intro.domain;

import java.util.List;

public record IntroProfile(
        String name,
        String title,
        String summary,
        List<String> strengths,
        List<String> techStacks,
        List<String> links
) {
}
