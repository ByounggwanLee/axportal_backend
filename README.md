# AXPORTAL BACKEND

AI Portal 백엔드 서비스입니다. Spring Boot 3.4.4와 Java 17을 기반으로 구축되었습니다.

## 🚀 주요 기능

- RESTful API 제공
- JWT 기반 인증/인가 (구현 예정)
- Spring Security 보안 설정
- OpenAPI 3.0 문서화 (Swagger UI)
- MyBatis 및 JPA 데이터 접근
- PostgreSQL 및 H2 데이터베이스 지원
- Spring Cloud OpenFeign 클라이언트
- 포괄적인 예외 처리
- 환경별 설정 관리
- 페이징 및 정렬 지원
- 샘플 도메인 CRUD API (예시 구현)

## 🛠 기술 스택

### Backend
- **Java 17**
- **Spring Boot 3.4.4**
- **Spring Security 6.x**
- **Spring Data JPA**
- **MyBatis 3.0.4**

### Database
- **PostgreSQL** (운영환경)
- **H2** (개발/테스트환경)

### Documentation
- **OpenAPI 3.0**
- **Swagger UI**

### Build Tool
- **Gradle 8.11.1**

### Others
- **JWT (JSON Web Token)**
- **Lombok**
- **Spring Cloud OpenFeign**
- **Spring Boot Actuator**

## 📁 프로젝트 구조

```
src/
├── main/
│   ├── java/com/skax/aiportal/
│   │   ├── config/          # 설정 클래스
│   │   ├── controller/      # REST 컨트롤러
│   │   │   └── sample/      # 샘플 컨트롤러
│   │   ├── service/         # 비즈니스 로직
│   │   │   └── sample/      # 샘플 서비스
│   │   ├── repository/      # 데이터 접근 계층
│   │   │   └── sample/      # 샘플 리포지토리
│   │   ├── entity/          # JPA 엔티티
│   │   │   ├── sample/      # 샘플 엔티티
│   │   │   └── BaseEntity.java  # 공통 엔티티
│   │   ├── dto/             # 데이터 전송 객체
│   │   │   ├── sample/      # 샘플 DTO
│   │   │   ├── ApiResponse.java # 공통 응답
│   │   │   └── PageResponse.java # 페이징 응답
│   │   ├── security/        # 보안 관련
│   │   ├── exception/       # 예외 처리
│   │   ├── util/            # 유틸리티
│   │   │   └── Constants.java # 애플리케이션 상수
│   │   └── AiPortalApplication.java
│   └── resources/
│       ├── mapper/          # MyBatis 매퍼 XML
│       │   └── sample/      # 샘플 매퍼
│       ├── application.yml           # 기본 설정
│       ├── application-dev.yml       # 개발환경 설정
│       ├── application-staging.yml   # 스테이징환경 설정
│       ├── application-prod.yml      # 운영환경 설정
│       └── data.sql                  # 초기 데이터
└── test/
    ├── java/com/skax/aiportal/       # 테스트 코드
    └── resources/
        └── application-test.yml       # 테스트환경 설정
```

## 🏃‍♂️ 실행 방법

### 필수 조건
- Java 17 이상
- Gradle 8.x 이상

### 개발 환경 실행

1. 프로젝트 클론
```bash
git clone <repository-url>
cd axportal_backend
```

2. 의존성 설치 및 빌드
```bash
./gradlew build
```

3. 애플리케이션 실행
```bash
./gradlew bootRun
```

또는

```bash
java -jar build/libs/axportal-backend-1.0.0.jar
```

### 환경별 실행

```bash
# 개발 환경
./gradlew bootRun --args='--spring.profiles.active=dev'

# 스테이징 환경
./gradlew bootRun --args='--spring.profiles.active=staging'

# 운영 환경
./gradlew bootRun --args='--spring.profiles.active=prod'
```

## 📖 API 문서

애플리케이션 실행 후 다음 URL에서 API 문서를 확인할 수 있습니다:

- **Swagger UI**: http://localhost:8080/api/swagger-ui.html
- **OpenAPI Spec**: http://localhost:8080/api/v3/api-docs

### 주요 API 엔드포인트

#### 헬스체크 API
- `GET /api/health` - 기본 헬스체크
- `GET /api/health/info` - 상세 헬스체크

#### 샘플 API (예시 구현)
- `GET /api/v1/samples` - 샘플 목록 조회 (페이징)
- `GET /api/v1/samples/{id}` - 샘플 상세 조회
- `POST /api/v1/samples` - 샘플 생성
- `PUT /api/v1/samples/{id}` - 샘플 수정
- `DELETE /api/v1/samples/{id}` - 샘플 삭제
- `GET /api/v1/samples/search?keyword={keyword}` - 샘플 검색
- `GET /api/v1/samples/popular` - 인기 샘플 조회
- `GET /api/v1/samples/stats` - 샘플 통계

## 🗃 데이터베이스

### 개발 환경 (H2)
- **URL**: http://localhost:8080/api/h2-console
- **JDBC URL**: `jdbc:h2:mem:axportal_dev`
- **Username**: `sa`
- **Password**: (비어있음)

### 운영 환경 (PostgreSQL)
환경 변수를 통해 데이터베이스 연결 정보를 설정해야 합니다:

```bash
export DB_HOST=localhost
export DB_PORT=5432
export DB_NAME=axportal
export DB_USERNAME=your_username
export DB_PASSWORD=your_password
```

## 🧪 테스트

```bash
# 전체 테스트 실행
./gradlew test

# 특정 테스트 클래스 실행
./gradlew test --tests HealthControllerTest

# 테스트 리포트 확인
open build/reports/tests/test/index.html
```

## 📊 모니터링

Spring Boot Actuator를 통해 애플리케이션 모니터링이 가능합니다:

- **Health Check**: http://localhost:8080/api/actuator/health
- **Metrics**: http://localhost:8080/api/actuator/metrics
- **Info**: http://localhost:8080/api/actuator/info

## 🔧 환경 설정

### 개발 환경
- 포트: 8080
- 데이터베이스: H2 (In-Memory)
- 로그 레벨: DEBUG

### 운영 환경
- 포트: 8080 (설정 가능)
- 데이터베이스: PostgreSQL
- 로그 레벨: WARN

## 🤝 기여 방법

1. Fork the Project
2. Create your Feature Branch (`git checkout -b feature/AmazingFeature`)
3. Commit your Changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the Branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

## 📝 라이선스

이 프로젝트는 MIT 라이선스 하에 배포됩니다. 자세한 내용은 `LICENSE` 파일을 참조하세요.

## 👥 작성자

- **ByounggwanLee** - *Initial work* - [GitHub](https://github.com/byounggwanlee)

## 📞 문의

프로젝트에 대한 문의사항이 있으시면 다음으로 연락해 주세요:

- Email: developer@axportal.com
- GitHub Issues: [Issues 페이지](https://github.com/byounggwanlee/axportal_backend/issues)

---

⭐ 이 프로젝트가 도움이 되셨다면 Star를 눌러주세요!
