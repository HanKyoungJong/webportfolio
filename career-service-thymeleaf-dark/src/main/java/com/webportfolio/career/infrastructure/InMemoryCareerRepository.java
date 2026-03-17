package com.webportfolio.career.infrastructure;

import com.webportfolio.career.domain.Career;
import com.webportfolio.career.domain.CareerRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class InMemoryCareerRepository implements CareerRepository {

    @Override
    public List<Career> findAll() {
        return List.of(
                new Career(1L, "키츠", "백엔드 개발자", "현재 재직(프리랜서)", "ECM개발 운영 및 API 개발 및 배포를 정리 했습니다."),
                new Career(2L, "키즈노트", "백엔드 개발자", "경력", "유아 교육기관과 학부모 간의 소통을 지원하는 서비스 및 고객사 Admin 플랫폼 개발 경험을 정리했습니다."),
                new Career(3L, "더블다운인터액티브", "백엔드 개발자", "경력", "글로벌 사용자 대상 카지노 게임 서비스 API, 성능 최적화, 관리자 시스템 운영 경험을 정리했습니다."),
                new Career(4L, "차이의발견", "백엔드 개발자", "경력", "엔터독 서비스 개발 및 유지보수, 관리자 시스템 개발을 1인 개발자로 수행한 경험을 정리했습니다."),
                new Career(5L, "한국정보인증", "백엔드 개발자", "경력", "관리자 시스템 개발과 텔레그램 기반 장애 알람 시스템 구축 경험을 정리했습니다.")
        );
    }
}
