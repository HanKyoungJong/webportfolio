package com.webportfolio.chat.application;

import com.webportfolio.career.application.CareerQueryService;
import com.webportfolio.career.domain.Career;
import com.webportfolio.project.application.ProjectQueryService;
import com.webportfolio.project.application.ProjectView;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

@Service
public class ChatService {

    private final CareerQueryService careerQueryService;
    private final ProjectQueryService projectQueryService;

    public ChatService(CareerQueryService careerQueryService,
                       ProjectQueryService projectQueryService) {
        this.careerQueryService = careerQueryService;
        this.projectQueryService = projectQueryService;
    }

    public String ask(String question) {
        if (question == null || question.isBlank()) {
            return """
                    질문을 입력해주세요.

                    예시:
                    - 경력 알려줘
                    - 최근 회사는?
                    - AWS 경험 있어?
                    - Java / Spring 경험은?
                    - 프로젝트 알려줘
                    """;
        }

        String q = normalize(question);

        List<Career> careers = careerQueryService.getAll();
        List<ProjectView> projects = projectQueryService.getAll();

        if (containsAny(q, "최근 회사", "현재 회사", "지금 회사", "최신 경력", "최근 경력")) {
            if (careers.isEmpty()) {
                return "등록된 경력 정보가 없습니다.";
            }

            Career latest = careers.get(0);
            return """
                    최근 경력은 다음과 같습니다.
                    회사: %s
                    직무: %s
                    기간: %s
                    내용: %s
                    """.formatted(
                    latest.getCompany(),
                    latest.getPosition(),
                    latest.getPeriod(),
                    latest.getSummary()
            );
        }

        if (containsAny(q, "경력", "이력", "커리어", "회사", "근무")) {
            if (careers.isEmpty()) {
                return "등록된 경력 정보가 없습니다.";
            }

            String body = careers.stream()
                    .map(c -> """
                            - 회사: %s
                              직무: %s
                              기간: %s
                              내용: %s
                            """.formatted(
                            c.getCompany(),
                            c.getPosition(),
                            c.getPeriod(),
                            c.getSummary()
                    ))
                    .collect(Collectors.joining("\n"));

            return "경력 요약입니다.\n\n" + body;
        }

        if (containsAny(q, "프로젝트", "포트폴리오", "작업", "경험")) {
            if (projects.isEmpty()) {
                return "등록된 프로젝트 정보가 없습니다.";
            }

            String body = projects.stream()
                    .limit(6)
                    .map(p -> """
                            - 프로젝트: %s
                              소속: %s
                              주요기술: %s
                            """.formatted(
                            p.title(),
                            p.company(),
                            summarizeTechStacks(p.techStacks(), 5)
                    ))
                    .collect(Collectors.joining("\n"));

            return "대표 프로젝트입니다.\n\n" + body;
        }

        if (containsAny(q, "aws", "ec2", "docker", "jenkins", "배포", "ci/cd", "cicd")) {
            List<ProjectView> matched = projects.stream()
                    .filter(this::isInfraProject)
                    .toList();

            if (matched.isEmpty()) {
                return "AWS / Docker / Jenkins 관련 프로젝트 정보가 없습니다.";
            }

            String body = matched.stream()
                    .map(p -> """
                            - 프로젝트: %s
                              소속: %s
                              기술: %s
                              배운점: %s
                            """.formatted(
                            p.title(),
                            p.company(),
                            String.join(", ", p.techStacks()),
                            String.join(", ", p.learnings())
                    ))
                    .collect(Collectors.joining("\n"));

            return "AWS / Docker / Jenkins / 배포 관련 경험입니다.\n\n" + body;
        }

        if (containsAny(q, "java", "spring", "spring boot", "backend", "백엔드", "api")) {
            List<ProjectView> matched = projects.stream()
                    .filter(this::isBackendProject)
                    .toList();

            if (matched.isEmpty()) {
                return "Java / Spring 관련 프로젝트 정보가 없습니다.";
            }

            String body = matched.stream()
                    .limit(5)
                    .map(p -> """
                            - 프로젝트: %s
                              회사: %s
                              기술스택: %s
                            """.formatted(
                            p.title(),
                            p.company(),
                            summarizeTechStacks(p.techStacks(), 6)
                    ))
                    .collect(Collectors.joining("\n"));

            return "Java / Spring 백엔드 관련 경험입니다.\n\n" + body;
        }

        if (containsAny(q, "자동화", "테스트", "qa", "api 자동화", "katalon")) {
            List<ProjectView> matched = projects.stream()
                    .filter(this::isAutomationProject)
                    .toList();

            if (matched.isEmpty()) {
                return "자동화 / 테스트 관련 프로젝트 정보가 없습니다.";
            }

            String body = matched.stream()
                    .map(p -> """
                            - 프로젝트: %s
                              회사: %s
                              내용: %s
                            """.formatted(
                            p.title(),
                            p.company(),
                            summarizeContents(p.contents(), 2)
                    ))
                    .collect(Collectors.joining("\n"));

            return "자동화 / 테스트 관련 경험입니다.\n\n" + body;
        }

        if (containsAny(q, "알람", "장애", "텔레그램", "telegram", "log4j", "모니터링")) {
            List<ProjectView> matched = projects.stream()
                    .filter(this::isAlarmProject)
                    .toList();

            if (matched.isEmpty()) {
                return "장애 알람 / 모니터링 관련 프로젝트 정보가 없습니다.";
            }

            String body = matched.stream()
                    .map(p -> """
                            - 프로젝트: %s
                              회사: %s
                              내용: %s
                              배운점: %s
                            """.formatted(
                            p.title(),
                            p.company(),
                            String.join(", ", p.contents()),
                            String.join(", ", p.learnings())
                    ))
                    .collect(Collectors.joining("\n"));

            return "장애 알람 / 모니터링 관련 경험입니다.\n\n" + body;
        }

        return """
                아래처럼 질문해보세요.
                - 경력 알려줘
                - 최근 회사는?
                - AWS 경험 있어?
                - Docker / Jenkins 써봤어?
                - Java / Spring 경험은?
                - 자동화 테스트 경험 있어?
                - 장애 알람 시스템 만든 적 있어?
                - 프로젝트 알려줘
                """;
    }

    private String normalize(String input) {
        return input.toLowerCase(Locale.ROOT).trim();
    }

    private boolean containsAny(String question, String... keywords) {
        for (String keyword : keywords) {
            if (question.contains(keyword.toLowerCase(Locale.ROOT))) {
                return true;
            }
        }
        return false;
    }

    private boolean isInfraProject(ProjectView project) {
        return project.techStacks().stream().anyMatch(this::containsInfraKeyword)
                || project.contents().stream().anyMatch(this::containsInfraKeyword)
                || project.learnings().stream().anyMatch(this::containsInfraKeyword)
                || containsInfraKeyword(project.title());
    }

    private boolean isBackendProject(ProjectView project) {
        return project.techStacks().stream().anyMatch(this::containsBackendKeyword)
                || project.contents().stream().anyMatch(this::containsBackendKeyword)
                || containsBackendKeyword(project.title());
    }

    private boolean isAutomationProject(ProjectView project) {
        return project.techStacks().stream().anyMatch(this::containsAutomationKeyword)
                || project.contents().stream().anyMatch(this::containsAutomationKeyword)
                || project.learnings().stream().anyMatch(this::containsAutomationKeyword)
                || containsAutomationKeyword(project.title());
    }

    private boolean isAlarmProject(ProjectView project) {
        return project.techStacks().stream().anyMatch(this::containsAlarmKeyword)
                || project.contents().stream().anyMatch(this::containsAlarmKeyword)
                || project.learnings().stream().anyMatch(this::containsAlarmKeyword)
                || containsAlarmKeyword(project.title());
    }

    private boolean containsInfraKeyword(String value) {
        String text = value.toLowerCase(Locale.ROOT);
        return text.contains("aws")
                || text.contains("ec2")
                || text.contains("docker")
                || text.contains("jenkins")
                || text.contains("배포")
                || text.contains("ci/cd")
                || text.contains("cicd");
    }

    private boolean containsBackendKeyword(String value) {
        String text = value.toLowerCase(Locale.ROOT);
        return text.contains("java")
                || text.contains("spring")
                || text.contains("spring boot")
                || text.contains("api")
                || text.contains("backend")
                || text.contains("백엔드");
    }

    private boolean containsAutomationKeyword(String value) {
        String text = value.toLowerCase(Locale.ROOT);
        return text.contains("자동화")
                || text.contains("테스트")
                || text.contains("qa")
                || text.contains("katalon")
                || text.contains("groovy");
    }

    private boolean containsAlarmKeyword(String value) {
        String text = value.toLowerCase(Locale.ROOT);
        return text.contains("알람")
                || text.contains("장애")
                || text.contains("telegram")
                || text.contains("텔레그램")
                || text.contains("log4j")
                || text.contains("오류")
                || text.contains("에러");
    }

    private String summarizeTechStacks(List<String> techStacks, int limit) {
        return techStacks.stream()
                .limit(limit)
                .collect(Collectors.joining(", "));
    }

    private String summarizeContents(List<String> contents, int limit) {
        return contents.stream()
                .limit(limit)
                .collect(Collectors.joining(", "));
    }
}