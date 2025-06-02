# 🌐 Spring Boot 로그인·회원가입 통합 웹 애플리케이션

Spring Boot를 기반으로 한 **로그인/회원가입 시스템 구현 프로젝트**입니다.  
백엔드에서는 MVC 구조를 활용한 RESTful 컨트롤러를 구성하고, 프론트엔드는 정적 HTML과 템플릿 엔진을 연동하여 실제 웹사이트 구조를 구현했습니다.

---

## ✨ 주요 기능

| 기능 | 메서드 | URL | 설명 |
|------|--------|-----|------|
| 로그인 | `POST` | `/login` | 이메일+비밀번호로 로그인 처리, 세션 저장 |
| 로그인 페이지 렌더링 | `GET` | `/login-form` | 로그인 템플릿 반환 (`members/login.html`) |
| 회원가입 등록 | `POST` | `/register` | Member DTO를 전달받아 회원 등록 처리 |
| 회원가입 폼 렌더링 | `GET` | `/register-form` | 회원가입 템플릿 반환 |
| 비밀번호 찾기 페이지 | `GET` | `/forgot-password-form` | 비밀번호 찾기 화면 렌더링 |

---

## 🗂️ 프로젝트 구조 요약

```
src/
 └── main/
      ├── java/idusw/sb/b202312407/
      │     ├── controller/
      │     │     └── MemberController.java
      │     ├── domain/ (DTO)
      │     │     └── Member.java, Blog.java
      │     ├── entity/
      │     │     └── MemberEntity.java, BlogEntity.java
      │     ├── repository/
      │     │     └── CRUD 인터페이스 및 구현체
      │     └── service/
      │           └── 서비스 로직 및 응용 계층
      ├── resources/
      │     ├── static/
      │     │     └── css, js, img, scss 등 정적 리소스
      │     ├── templates/
      │     │     ├── main/ (404.html, login.html 등)
      │     │     └── fragments/ (footer, header, sidebar 분리 구성)
      │     └── application.properties
```

---

## 🛠️ 사용 기술

- Java 17
- Spring Boot 3.x
- Spring MVC
- Thymeleaf (or 유사 템플릿 엔진)
- Gradle
- HTML/CSS/JS
- Session 기반 로그인 처리

---

## 📚 학습 포인트

- `@Controller`, `@RequestMapping`, `@PostMapping`, `@GetMapping` 등 MVC 컨트롤러 구성
- `@RequestParam`, `@ModelAttribute`를 통한 폼 데이터 처리
- 세션을 통한 로그인 정보 유지 (`session.setAttribute(...)`)
- 정적 HTML 리소스와 템플릿 분리 관리 (`fragments` 디렉토리)
- 프론트-백엔드 연동 흐름 전체 실습

---

## 🧪 실행 방법

1. JDK 17 이상 설치
2. Gradle 빌드
```bash
./gradlew build
```
3. 서버 실행
```bash
./gradlew bootRun
```
4. 웹브라우저에서 접속
```
http://localhost:8080/login-form
http://localhost:8080/register-form
```

---

