package com.webportfolio.common.init;

import com.webportfolio.career.domain.Career;
import com.webportfolio.career.domain.CareerRepository;
import com.webportfolio.project.domain.Project;
import com.webportfolio.project.domain.ProjectRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {
    private final CareerRepository careerRepository;
    private final ProjectRepository projectRepository;

    public DataInitializer(CareerRepository careerRepository, ProjectRepository projectRepository) {
        this.careerRepository = careerRepository;
        this.projectRepository = projectRepository;
    }

    @Override
    public void run(String... args) {
        if (careerRepository.count() == 0) {
            careerRepository.save(new Career("키츠 2025.03 ~ ing (프리랜서)", "백엔드 개발자", "재직 중", "ECM개발운영팀 : ECM 웹 개발 및 API 개발 및 배포"));
            careerRepository.save(new Career("키즈노트 2022.08 ~ 2024.02", "백엔드 개발자", "경력", "플랫폼개발팀 : 자동화 개발 및 자동화 스크립트 개발, API 자동화 개발"));
            careerRepository.save(new Career("더블다운인터액티브 2020.08 ~ 2021.12", "백엔드 개발자", "경력", "서버개발팀 : API개발, AB 테스트 개발, ADMIN 유지보수 및 배포 "));
            careerRepository.save(new Career("차이의발견 2019.09 ~ 2020.02", "백엔드 개발자", "경력", "서비스개발팀 : 하이브리드 웹앱 서비스 개발 및 유지보수 배포"));
            careerRepository.save(new Career("한국정보인증 2017.09 ~ 2018.06", "백엔드 개발자", "경력", "서비스개발팀 : API개발, ADMIN 유지보수 및 배포"));
        }

        if (projectRepository.count() == 0) {
            projectRepository.save(new Project("포스코 고객사 ECM문서 권한 개발 및 웹개발", "키츠",
                    "포스코 고객사 ECM 문서 관리 시스템의 웹 및 API 개발·운영 담당\nSpring 기반 ECM 웹 애플리케이션에서 문서 권한 관리 기능 개발 수행\nJava 11 기반 시스템을 Java 17 환경으로 마이그레이션하여 런타임 업그레이드 진행\nJDK 변경에 따른 비호환 API 수정 및 코드 호환성 개선 작업 수행\n라이브러리 버전 정합성 검토 및 전체 코드 수정 후 기능·통합 테스트 진행\nLinux 서버 환경에서 JAR 파일 생성 및 배포, Job 및 Batch 프로그램 실행·테스트\nShell 스크립트와 리눅스 커맨드를 활용해 배치 실행 상태 확인 및 로그 분석\nOracle DB 연동을 통한 데이터 처리 및 서비스 정상 동작 검증\nBatch 실행 중 발생한 오류 원인 분석 및 수정으로 운영",
                    "Java 11\nSpring Framework\nMySQL\nUbuntu\nGitHubn\nJSP\nJavaScript",
                    "ECM 개발 운영을 하면서 전반적인 ECM에대한 배운 경험\n테스트 적용 및 배포 안정성 강화 경험"));

            projectRepository.save(new Project("키즈노트 서비스 및 고객사용 관리자 시스템 자동화 개발", "키즈노트",
                "키즈노트 서비스 자동화 개발 및 고객사 Admin 개발 및 유지보수\n유아 교육기관과 학부모 간의 소통을 지원하는 Admin 플랫폼 백엔드 개발\n주요 기능: 알림장, 사진 및 영상 공유, 고객사 전용 관리자 시스템 개발(로그인, 게시판 등)\n자동화 개발 및 API 자동화 구축\nKatalon 기반 테스트 스크립트 개발\n고객사 관리자 시스템 요구사항 반영, 유지보수, 배포 진행",
                "Java 11\nSpring Framework\nSpring Boot\nMySQL\nUbuntu\nGitHub\nJenkins\nKatalon\nGroovy\nJSP\nJavaScript",
                "API 자동화 테스트 환경 구축을 통한 서비스 품질 개선 경험\nCI/CD 환경에서 자동화 테스트 적용 및 배포 안정성 강화 경험"));

            projectRepository.save(new Project("더블다운카지노 서비스 개발 및 관리자 시스템 개발", "더블다운인터액티브",
                "글로벌 사용자 대상 카지노 게임 서비스 API 개발\n게임 데이터 처리 향상을 위한 API 성능 최적화\nA/B 테스트 기능 개발을 통해 게임 유저 유입 증가 및 이벤트 실험 진행\n운영팀 및 고객 지원을 위한 관리자 시스템 유지보수 및 기능 개선",
                "Java 8\nSpring Framework\nSpring Boot\nMySQL\nOracle\nAWS EC2\nJenkins\nJSP\nJavaScript\nMA\nMSA",
                "대규모 트래픽을 처리하는 API 개발 및 성능 최적화 경험\nA/B 테스트를 활용한 데이터 기반의 서비스 개선 경험\nAWS EC2 기반의 서버 운영 및 배포 자동화 경험\n관리자 시스템 유지보수를 통해 운영 효율성을 높이는 경험"));

            projectRepository.save(new Project("엔터독 서비스 개발 및 유지보수", "차이의발견",
                "하이브리드 웹앱 서비스 개발 및 유지보수\nSpring 기반 API 개발\n사용자 데이터 관리 및 서비스 기능 개선\n관리자 시스템 개발\n요구사항 개발 진행 및 유지보수, 배포 진행(로그인, 게시판 등)",
                "Java 8\nSpring Framework\nMySQL\nCafe24\nGitHub\nSpring MVC\nJSP\nJavaScript\nMyBatis",
                "1인 개발자로 설계, 개발, QA, 배포 및 유지보수까지 전 과정을 수행한 경험"));

            projectRepository.save(new Project("관리자 시스템 개발 및 유지보수", "한국정보인증",
                "서비스 운영을 위한 Admin API 개발 및 기능 개선\nCentOS 기반 서버 환경에서의 운영 및 배포 진행",
                "Java 7\nSpring Framework\nSpring Boot\nMySQL\nOracle\nCentOS\nJBoss\nJenkins\nJSP\nJavaScript\nMA",
                "Spring 기반의 API 개발 및 유지보수 경험"));

            projectRepository.save(new Project("장애 알람 시스템 구축", "한국정보인증",
                "장애 상황, 긴급 상황 및 특정 서비스의 에러 메시지를 자동 감지하여 알림 전송\n텔레그램 봇을 이용한 알람 시스템 구축\n서비스 장애 및 오류 발생 시 지정된 채팅방으로 실시간 알림 전송\nlog4j 기반 로그 시스템과 연동하여 즉각적인 대응이 가능하도록 구현\n메시지 표준화: 발생 시각, 오류 코드, 서비스명, 조치 필요 여부 포함\n비동기 처리, 재시도 로직, 중복 알람 방지 로직 설계 및 구현",
                "Java 7\nSpring Boot\nSpring Framework\nlog4j\nTelegram Bot API\nJBoss\nJavaScript\nCentOS",
                "log4j를 활용한 로그 수집 및 실시간 오류 감지 시스템 개발 경험\n알람 시스템의 비동기 처리와 재시도 로직 설계 경험\n중복 알람 방지 로직을 통한 운영 효율 개선 경험"));

            projectRepository.save(new Project("AWS · Docker · Jenkins 기반 포트폴리오 서버 배포", "개인 포트폴리오",
                "Spring Boot + Thymeleaf 기반 서버 사이드 어플리케이션으로 재구성\nDDD 스타일 구조를 적용하여 경력기술서와 프로젝트 경험을 도메인 중심으로 정리\nAWS EC2 환경에 Docker 컨테이너 기반으로 배포\nJenkins를 활용한 CI/CD 자동 배포 환경 구성",
                "Java 17\nSpring Boot\nSpring MVC\nThymeleaf\nAWS EC2\nDocker\nJenkins\nGitHub",
                "AWS, Docker, Jenkins 기반 배포 자동화 경험\n백엔드 개발자 포트폴리오를 서비스 설계와 운영 관점으로 확장한 경험"));
        }
    }
}
