package com.webportfolio.project.domain;

import java.util.List;

public record ProjectDetail(
        Long id,
        String company,
        String title,
        List<String> descriptions,
        List<String> techStacks,
        List<String> learnings
) {
}
