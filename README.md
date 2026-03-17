# career-service-thymeleaf-db

Spring Boot + Thymeleaf + Docker + DDD 스타일 구조에
DB(H2) 연동까지 적용한 포트폴리오입니다.

## 기술 스택
- Java 17
- Spring Boot
- Spring MVC
- Thymeleaf
- Spring Data JPA
- H2 
- AWS EC2
- Docker
- Jenkins
- GitHub

## 실행
### H2 기본 실행
```bash
./gradlew clean bootJar
java -jar build/libs/career-service-thymeleaf-db-1.0.0.jar
```
## H2 Console
- /h2-console
- JDBC URL: jdbc:h2:mem:portfolio
