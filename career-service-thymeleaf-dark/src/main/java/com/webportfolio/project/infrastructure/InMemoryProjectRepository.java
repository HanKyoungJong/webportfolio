package com.webportfolio.project.infrastructure;

import com.webportfolio.project.domain.ProjectDetail;
import com.webportfolio.project.domain.ProjectRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class InMemoryProjectRepository implements ProjectRepository {

    @Override
    public List<ProjectDetail> findAll() {
        return List.of(
                new ProjectDetail(
                        1L,
                        "키츠",
                        "ECM 웹 및 API 개발·운영 (ECM개발운영팀)",
                        List.of(
                                "포스코 고객사 ECM 문서 관리 시스템의 웹 및 API 개발·운영 담당",
                                "Spring 기반 ECM 웹 애플리케이션에서 문서 권한 관리 기능 개발",
                                "Oracle DB 연동을 통한 문서·권한 데이터 처리 및 서비스 정상 동작 검증",
                                "Java 11 기반 시스템을 Java 17 환경으로 마이그레이션하여 런타임 업그레이드 진행",
                                "JDK 변경에 따른 비호환 API 수정 및 코드 호환성 개선 작업 수행",
                                "라이브러리 버전 정합성 검토 및 전체 코드 수정 후 기능·통합 테스트 진행",
                                "Linux 서버 환경에서 JAR 파일 생성 및 배포, Job 및 Batch 프로그램 실행·테스트",
                                "Shell 스크립트 및 리눅스 커맨드를 활용한 배치 실행 상태 확인 및 로그 분석",
                                "Batch 실행 중 발생한 오류 원인 분석 및 수정으로 운영 안정성 확보"
                        ),
                        List.of(
                                "Java11", "Spring Framework", "Spring", "MySQL", "Linux", "GitHub", "JSP", "JavaScript"
                        ),
                        List.of(
                                "Spring 기반 웹·API 개발부터 운영까지의 전반적인 백엔드 사이클 경험",
                                "Java 버전 업그레이드 과정에서의 마이그레이션 대응 능력 및 안정성 검증 경험",
                                "Linux 환경에서의 Job·Batch 운영 및 로그 기반 장애 분석 역량 강화"
                        )
                ),
                new ProjectDetail(
                        2L,
                        "키즈노트",
                        "키즈노트 서비스 및 고객사용 관리자 시스템 자동화 개발",
                        List.of(
                                "키즈노트 서비스 자동화 개발 및 고객사 Admin 개발 및 유지보수",
                                "유아 교육기관과 학부모 간의 소통을 지원하는 Admin 플랫폼 백엔드 개발",
                                "주요 기능: 알림장, 사진 및 영상 공유, 고객사 전용 관리자 시스템 개발(로그인, 게시판 등)",
                                "자동화 개발 및 API 자동화 구축",
                                "테스트 자동화를 위한 Katalon 기반 테스트 스크립트 개발",
                                "고객사 관리자 시스템 개발: 요구사항 개발, 유지보수 및 배포 진행(로그인, 게시판 등)"
                        ),
                        List.of(
                                "Java11", "Spring Framework", "Spring Boot", "MySQL", "Ubuntu", "GitHub", "Jenkins", "Katalon", "Groovy", "JSP", "JavaScript"
                        ),
                        List.of(
                                "API 자동화 테스트 환경 구축을 통한 서비스 품질 개선 경험",
                                "CI/CD 환경에서 자동화 테스트 적용 및 배포 안정성 강화 경험"
                        )
                ),
                new ProjectDetail(
                        3L,
                        "더블다운인터액티브",
                        "더블다운카지노 서비스 개발 및 관리자 시스템 개발",
                        List.of(
                                "글로벌 사용자 대상의 카지노 게임 서비스 API 개발",
                                "게임 데이터 처리 향상을 위한 API 성능 최적화",
                                "A/B 테스트 기능 개발을 통해 다양한 게임 유저 유입 증가 및 게임 이벤트 실험 진행(광고, 결제 등)",
                                "관리자(Admin) 시스템 유지 보수 및 배포",
                                "운영팀 및 고객 지원을 위한 관리자 시스템 유지보수 및 기능 개선"
                        ),
                        List.of(
                                "Java8", "Spring Framework", "Spring Boot", "MySQL", "Oracle", "AWS EC2", "Jenkins", "JSP", "JavaScript", "MA", "MSA"
                        ),
                        List.of(
                                "대규모 트래픽을 처리하는 API 개발 및 성능 최적화 경험",
                                "A/B 테스트를 활용한 데이터 기반의 서비스 개선 경험",
                                "AWS EC2 기반의 서버 운영 및 배포 자동화 경험",
                                "관리자 시스템 유지보수를 통해 운영 효율성을 높이는 경험"
                        )
                ),
                new ProjectDetail(
                        4L,
                        "차이의발견",
                        "엔터독 서비스 개발 및 유지보수",
                        List.of(
                                "하이브리드 웹앱 서비스 개발 및 유지보수",
                                "Spring 기반의 API 개발",
                                "사용자 데이터 관리 및 서비스 기능 개선",
                                "관리자 시스템 개발",
                                "요구사항 개발 진행 및 유지보수 및 배포 진행(로그인, 게시판 등)"
                        ),
                        List.of(
                                "Java8", "Spring Framework", "MySQL", "Cafe24", "GitHub", "Jenkins", "MVC", "JSP", "JavaScript", "MyBatis"
                        ),
                        List.of(
                                "1인 개발자로 설계, 개발, QA, 배포 및 유지보수 전 과정을 수행한 경험"
                        )
                ),
                new ProjectDetail(
                        5L,
                        "한국정보인증",
                        "관리자 시스템 개발 및 유지보수",
                        List.of(
                                "서비스 운영을 위한 Admin API 개발 및 기능 개선",
                                "CentOS 기반 서버 환경에서의 운영 및 배포 진행"
                        ),
                        List.of(
                                "Java7", "Spring Framework", "Spring Boot", "MySQL", "Oracle", "CentOS", "JBoss", "Jenkins", "JSP", "JavaScript", "MA"
                        ),
                        List.of(
                                "Spring 기반의 API 개발 및 유지보수 경험"
                        )
                ),
                new ProjectDetail(
                        6L,
                        "한국정보인증",
                        "장애 알람 시스템 구축",
                        List.of(
                                "텔레그램 봇을 활용한 알람 시스템 개발 프로젝트 담당",
                                "장애 상황 및 긴급 상황 발생 시 담당자에게 신속하고 정확하게 알람을 전달하는 시스템 구축",
                                "서비스 내 장애 로그를 log4j로 수집",
                                "장애 로그를 분석·가공하여 메시지로 변환",
                                "메시지 표준화: 시각, 오류 코드, 서비스명, 조치 필요 여부 포함",
                                "중복 알람 방지 로직을 설계하여 동일 장애에 대한 반복 알람 방지",
                                "텔레그램 API 호출 지연 및 다중 장애 발생 시 메시지 누락 문제를 개선",
                                "비동기 처리: 이벤트를 메시지 큐에 적재 후 별도 워커가 처리",
                                "전송 실패 시 최대 3회 재시도 로직 구현",
                                "로그 시스템과 연동하여 에러 발생 시 즉각 대응 가능하도록 구현"
                        ),
                        List.of(
                                "Java", "Spring Boot", "log4j", "JBoss", "JavaScript", "Telegram Bot API"
                        ),
                        List.of(
                                "log4j를 활용한 로그 수집 및 실시간 오류 감지 시스템 개발 경험",
                                "비동기 처리와 재시도, 중복 방지 설계를 통한 장애 대응 시스템 안정화 경험"
                        )
                ),
                new ProjectDetail(
                        6L,
                        "개인 포트폴리오",
                        "AWS · Docker · Jenkins 기반 포트폴리오 배포",
                        List.of(
                                "Spring Boot + Thymeleaf 기반 포트폴리오 서비스 구성",
                                "AWS EC2 서버에 Docker 기반으로 애플리케이션 배포",
                                "Jenkins를 이용해 GitHub 소스 기준 빌드 및 배포 자동화 구성",
                                "GitHub → Jenkins → Docker → AWS EC2 흐름으로 자동 배포 구조 정리",
                                "헬스 체크, 경력 페이지, 프로젝트 페이지를 포함한 개인 백엔드 포트폴리오 구축"
                        ),
                        List.of(
                                "Spring Boot", "Thymeleaf", "AWS EC2", "Docker", "Jenkins", "GitHub", "Gradle", "Java17"
                        ),
                        List.of(
                                "백엔드 서비스 개발부터 빌드, 배포, 운영까지 전 과정을 직접 구성한 경험",
                                "포트폴리오를 실제 배포 환경으로 연결하며 DevOps 흐름을 정리한 경험"
                        )
                )
        );
    }
}
