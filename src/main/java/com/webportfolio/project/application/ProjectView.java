package com.webportfolio.project.application;

import com.webportfolio.project.domain.Project;

import java.util.Arrays;
import java.util.List;

public record ProjectView(Long id, String title, String company, List<String> contents, List<String> techStacks, List<String> learnings) {
    public static ProjectView from(Project project) {
        return new ProjectView(
                project.getId(),
                project.getTitle(),
                project.getCompany(),
                split(project.getContents()),
                split(project.getTechStacks()),
                split(project.getLearnings())
        );
    }

    private static List<String> split(String value) {
        return Arrays.stream(value.split("\n"))
                .map(String::trim)
                .filter(s -> !s.isBlank())
                .toList();
    }
}
