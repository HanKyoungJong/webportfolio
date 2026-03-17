# career-service-thymeleaf-db

Spring Boot + Thymeleaf 기반 웹 애플리케이션에
H2 DB, AWS EC2 배포, Jenkins CI/CD, Nginx 까지 적용한 포트폴리오입니다.

---

## 🔧 기술 스택

* Java 17
* Spring Boot
* Spring MVC
* Thymeleaf
* Spring Data JPA
* H2 Database
* AWS EC2 (Amazon Linux)
* Jenkins (CI/CD)
* Nginx (Reverse Proxy)
* Docker (기초 구성)
* GitHub

---

## 🚀 실행 방법

### 로컬 실행

```bash
./gradlew clean bootJar
java -jar build/libs/career-service-thymeleaf-db-1.0.0.jar
```

---

## 🗄 H2 Console

* URL: `/h2-console`
* JDBC URL: `jdbc:h2:mem:portfolio`

---

## 🌐 배포 아키텍처

```
GitHub
  → Jenkins
    → Gradle Build
      → JAR 생성
        → EC2 서버 배포
          → Spring Boot 실행 (8080)
            → Nginx (80)
              → 사용자 접속
```

---

## ☁️ AWS EC2 구축

### 1. EC2 생성

* Amazon Linux 2023
* 보안 그룹 설정:

    * 22 (SSH)
    * 80 (HTTP)
    * 8080 (Spring Boot)
    * 9090 (Jenkins)

---

### 2. 기본 환경 설정

```bash
sudo dnf update -y
sudo dnf install java-17-amazon-corretto-devel -y
sudo dnf install git -y
```

---

## 🤖 Jenkins 구축

### 1. Jenkins 설치

```bash
sudo dnf install jenkins -y
sudo systemctl enable jenkins
sudo systemctl start jenkins
```

접속:

```
http://EC2-IP:9090
```

---

### 2. Jenkins Job 구성

* Freestyle Project 생성
* GitHub Repository 연결
* Build Step → Execute shell 사용

---

## 🌍 Nginx 구축 (Reverse Proxy)

## 🔗 접속 URL

기존:

```
http://EC2-IP:8080
```

변경 후:

```
http://EC2-IP
```

---

## 🔌 서비스 포트

| 서비스         | 포트   |
| ----------- | ---- |
| Nginx       | 80   |
| Spring Boot | 8080 |
| Jenkins     | 9090 |

---
