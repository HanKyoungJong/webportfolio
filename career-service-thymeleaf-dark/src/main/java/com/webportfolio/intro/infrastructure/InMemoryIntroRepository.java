package com.webportfolio.intro.infrastructure;

import com.webportfolio.intro.domain.IntroProfile;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class InMemoryIntroRepository {

    public IntroProfile getProfile() {
        return new IntroProfile(
                "한경종",
                "Backend Developer Portfolio",
                "Spring Boot 기반 백엔드 개발 경험과 AWS · Docker · Jenkins 기반 배포 경험, 관리자 시스템 개발, 자동화 테스트, 장애 알림 시스템 구축 경험을 정리한 포트폴리오입니다.",
                List.of(
                        "Java · Spring Boot 중심 백엔드 개발",
                        "관리자 시스템 및 서비스 API 개발",
                        "AWS EC2 · Docker · Jenkins 기반 배포 경험",
                        "장애 로그 분석 및 텔레그램 알람 시스템 구축"
                ),
                List.of(
                        "Java", "Spring Boot", "Spring Framework", "Thymeleaf", "MySQL", "Oracle", "AWS EC2", "Docker", "Jenkins", "log4j"
                ),
                List.of(
                        "GitHub Portfolio", "AWS · Docker · Jenkins 배포", "Career Summary", "Project Detail"
                )
        );
    }
}
