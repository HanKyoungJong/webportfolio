# Career Service Thymeleaf

Spring Boot + Thymeleaf + Docker + DDD 스타일로 만든 백엔드 포트폴리오 프로젝트입니다.

## 기능
- `/` : 소개
- `/careers` : 회사별 경력 요약
- `/projects` : 프로젝트 상세
- `/health` : 헬스 체크

## 실행
```bash
./gradlew clean bootJar
java -jar build/libs/career-service-thymeleaf-1.0.0.jar
```

## Docker
```bash
docker build -t career-service-thymeleaf .
docker run -d -p 8080:8080 --name career-service-thymeleaf career-service-thymeleaf
```

## Jenkins Execute Shell 예시
```bash
#!/bin/bash
set -xe

cd $WORKSPACE
chmod +x gradlew
./gradlew clean bootJar

docker stop career-service-thymeleaf || true
docker rm career-service-thymeleaf || true
docker build -t career-service-thymeleaf .
docker run -d -p 8080:8080 --name career-service-thymeleaf career-service-thymeleaf
```
