# AXPORTAL BACKEND

**SKT AI 플랫폼 통합 백엔드 서비스**

AI Portal 백엔드 서비스입니다. Spring Boot 3.4.4와 Java 17을 기반으로 구축되었으며, SKT AI 플랫폼의 모든 API를 통합하여 제공하는 포괄적인 백엔드 시스템입니다.

## 🚀 주요 기능

### 핵심 비즈니스 기능
- **데이터셋 관리**: 생성, 조회, 수정, 삭제, 태그 관리, 미리보기
- **인증/인가 시스템**: OAuth2 기반 로그인, JWT 토큰 관리, 권한 체계
- **AI 모델 관리**: 모델 버전 관리, 파일 업로드, 엔드포인트 관리
- **AI 에이전트**: 앱 생성, 지식 관리, 배포 및 모니터링
- **데이터 처리**: 소스 연동, 생성기 관리, 프로세서 실행
- **모델 서빙**: API 키 관리, 서빙 엔드포인트, 모니터링
- **안전 필터**: 콘텐츠 검사, 보안 필터링, 정책 관리

### 기술적 기능
- RESTful API 제공 (OpenAPI 3.0 완전 준수)
- 포괄적인 예외 처리 및 한글 로깅 시스템
- 환경별 설정 관리 (개발/스테이징/운영)
- 페이징 및 정렬 지원
- Spring Boot Actuator 모니터링
- Docker 컨테이너 지원
- 자동화된 테스트 환경

## 🛠 기술 스택

### Backend Framework
- **Java 17** (LTS)
- **Spring Boot 3.4.4**
- **Spring Security 6.x** (OAuth2, JWT)
- **Spring Data JPA** (ORM)
- **MyBatis 3.0.4** (SQL 매퍼)
- **Spring Cloud OpenFeign 4.1.0** (HTTP 클라이언트)

### Database
- **PostgreSQL 15.4+** (운영환경)
- **H2 Database** (개발/테스트환경)

### Documentation & Testing
- **OpenAPI 3.0** / **Swagger UI 2.7.0**
- **JUnit 5** / **Mockito** / **TestContainers**
- **Spring Boot Test** (통합 테스트)

### Build & DevOps
- **Gradle 8.11.1** (빌드 도구)
- **Docker** (컨테이너화)
- **GitHub Actions** (CI/CD)

### External Integrations
- **SKT AI Platform APIs** (15개 도메인 완전 통합)
- **JWT 0.12.6** (토큰 인증)
- **Spring Boot Actuator** (모니터링)

## 📁 프로젝트 구조

```
src/
├── main/
│   ├── java/com/skax/aiportal/
│   │   ├── config/              # 설정 클래스
│   │   │   ├── OpenApiConfig.java
│   │   │   ├── JpaConfig.java
│   │   │   └── MyBatisConfig.java
│   │   ├── controller/          # REST 컨트롤러
│   │   │   ├── authorization/   # 인증 관련 컨트롤러
│   │   │   │   └── AuthenticationController.java
│   │   │   ├── data/           # 데이터 관련 컨트롤러
│   │   │   │   └── DatasetController.java
│   │   │   ├── sample/         # 샘플 컨트롤러 (학습용)
│   │   │   │   └── SampleController.java
│   │   │   └── HealthController.java
│   │   ├── service/             # 비즈니스 로직
│   │   │   ├── authorization/   # 인증 서비스
│   │   │   │   ├── AuthenticationService.java
│   │   │   │   └── impl/SktAuthenticationServiceImpl.java
│   │   │   ├── data/           # 데이터 서비스
│   │   │   │   ├── SktDatasetService.java
│   │   │   │   └── impl/SktDatasetServiceImpl.java
│   │   │   └── sample/         # 샘플 서비스
│   │   ├── repository/          # 데이터 접근 계층
│   │   │   └── sample/         # 샘플 리포지토리
│   │   ├── entity/              # JPA 엔티티
│   │   │   ├── sample/         # 샘플 엔티티
│   │   │   └── BaseEntity.java # 공통 엔티티
│   │   ├── dto/                 # 데이터 전송 객체
│   │   │   ├── authorization/   # 인증 DTO
│   │   │   │   ├── request/    # 요청 DTO
│   │   │   │   └── response/   # 응답 DTO
│   │   │   ├── data/           # 데이터 DTO
│   │   │   │   ├── request/    # 요청 DTO
│   │   │   │   └── response/   # 응답 DTO
│   │   │   ├── sample/         # 샘플 DTO
│   │   │   ├── CustomApiResponse.java # 통합 응답 포맷
│   │   │   └── PageResponse.java # 페이징 응답
│   │   ├── client/              # 외부 API 클라이언트 (534개 파일)
│   │   │   └── sktai/          # SKT AI 플랫폼 클라이언트
│   │   │       ├── config/     # 클라이언트 설정
│   │   │       ├── interceptor/ # 요청 인터셉터
│   │   │       ├── authorization/ # 인증 API (3개 클라이언트)
│   │   │       ├── data/       # 데이터 API (5개 클라이언트)
│   │   │       ├── agent/      # 에이전트 API (3개 클라이언트)
│   │   │       ├── model/      # 모델 API (5개 클라이언트)
│   │   │       ├── gateway/    # 게이트웨이 API (3개 클라이언트)
│   │   │       ├── knowledge/  # 지식 API (4개 클라이언트)
│   │   │       ├── safetyfilter/ # 안전 필터 API (2개 클라이언트)
│   │   │       ├── serving/    # 서빙 API (3개 클라이언트)
│   │   │       └── resource/   # 리소스 API (1개 클라이언트)
│   │   ├── constant/            # 상수 클래스
│   │   │   ├── AuthorizationConstants.java
│   │   │   ├── DatasetConstants.java
│   │   │   └── CommonConstants.java
│   │   ├── converter/           # DTO 변환기
│   │   │   └── DatasetDtoConverter.java
│   │   ├── security/            # 보안 관련
│   │   ├── exception/           # 예외 처리
│   │   │   └── GlobalExceptionHandler.java
│   │   ├── util/                # 유틸리티
│   │   └── AiPortalApplication.java
│   └── resources/
│       ├── mapper/              # MyBatis 매퍼 XML
│       │   └── sample/         # 샘플 매퍼
│       ├── application.yml             # 기본 설정
│       ├── application-dev.yml         # 개발환경 설정
│       ├── application-staging.yml     # 스테이징환경 설정
│       ├── application-prod.yml        # 운영환경 설정
│       └── data.sql                    # 초기 데이터
└── test/
    ├── java/com/skax/aiportal/         # 테스트 코드
    │   └── controller/
    │       └── HealthControllerTest.java
    └── resources/
        └── application-test.yml         # 테스트환경 설정
```

### 📊 프로젝트 규모
- **총 Java 파일**: 600+ 개
- **SKT AI API 클라이언트**: 29개 도메인 완전 구현
- **Controller**: 4개 (Health, Authentication, Dataset, Sample)
- **Service**: 2개 구현 완료 + 1개 샘플
- **외부 API 통합**: 15개 도메인 (534개 클라이언트 파일)
- **DTO 클래스**: 200+ 개 (Request/Response 분리)
- **상수 관리**: 체계적인 Constants 클래스 구조

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

- **Swagger UI**: http://localhost:8080/swagger-ui/index.html
- **OpenAPI Spec**: http://localhost:8080/v3/api-docs

### 🔗 주요 API 엔드포인트

#### ✅ 헬스체크 API
- `GET /health` - 기본 헬스체크
- `GET /health/info` - 상세 헬스체크 (시스템 정보 포함)

#### 🔐 인증 관리 API (완전 구현)
- `POST /api/v1/auth/login` - OAuth2 로그인
- `POST /api/v1/auth/logout` - 로그아웃
- `POST /api/v1/auth/refresh` - 토큰 갱신
- `POST /api/v1/auth/exchange` - 토큰 교환

#### 📊 데이터셋 관리 API (완전 구현)
- `GET /api/v1/datasets` - 데이터셋 목록 조회 (페이징, 필터링, 검색)
- `POST /api/v1/datasets` - 데이터셋 생성
- `GET /api/v1/datasets/{id}` - 데이터셋 상세 조회
- `PUT /api/v1/datasets/{id}` - 데이터셋 수정
- `DELETE /api/v1/datasets/{id}` - 데이터셋 삭제

#### 🧪 샘플 API (학습용 예시)
- `GET /api/v1/samples` - 샘플 목록 조회 (페이징)
- `GET /api/v1/samples/{id}` - 샘플 상세 조회
- `POST /api/v1/samples` - 샘플 생성
- `PUT /api/v1/samples/{id}` - 샘플 수정
- `DELETE /api/v1/samples/{id}` - 샘플 삭제
- `GET /api/v1/samples/search?keyword={keyword}` - 샘플 검색
- `GET /api/v1/samples/popular` - 인기 샘플 조회
- `GET /api/v1/samples/stats` - 샘플 통계

### 🌐 SKT AI 플랫폼 통합 API

본 프로젝트는 **SKT AI 플랫폼의 모든 API 도메인을 완전히 통합**하여 제공합니다:

#### 🔑 Authorization Domain (인증/사용자 관리)
- **SktAiAuthClient** - OAuth2 로그인, 로그아웃, 토큰 관리
- **SktAiUserClient** - 사용자 정보 관리, 프로필 조회
- **SktAiPolicyClient** - 정책 생성, 조회, 관리

#### 📁 Data Domain (데이터 관리)
- **SktAiDatasetClient** - 데이터셋 CRUD, 태그 관리, 미리보기
- **SktAiDatasourceClient** - 데이터 소스 관리, 파일 업로드
- **SktAiGenerationClient** - 데이터 생성 작업 관리
- **SktAiProcessorClient** - 데이터 프로세서 실행 및 모니터링
- **SktAiGeneratorClient** - 데이터 생성기 관리

#### 🤖 Agent Domain (AI 에이전트)
- **SktAiAgentAppsClient** - 에이전트 앱 생성, 배포, 관리
- **SktAiAgentServingClient** - 에이전트 서빙 엔드포인트 관리
- **SktAiAgentChatClient** - 에이전트 채팅 기능

#### 🧠 Model Domain (AI 모델 관리)
- **SktAiModelClient** - 모델 등록, 조회, 관리
- **SktAiModelVersionClient** - 모델 버전 관리
- **SktAiModelFileClient** - 모델 파일 업로드, 다운로드
- **SktAiModelEndpointClient** - 모델 엔드포인트 관리
- **SktAiModelProviderClient** - 모델 제공자 관리

#### 🌐 Gateway Domain (API 게이트웨이)
- **SktAiModelGatewayClient** - 모델 게이트웨이 관리
- **SktAiModelGatewayInvokeClient** - 모델 추론 호출
- **SktAiModelGatewayMonitoringClient** - 게이트웨이 모니터링

#### 📚 Knowledge Domain (지식 관리)
- **SktAiKnowledgeClient** - 지식베이스 관리
- **SktAiKnowledgeVectorDBClient** - 벡터 DB 관리
- **SktAiKnowledgeDocumentClient** - 문서 관리
- **SktAiKnowledgeChunkClient** - 문서 청크 관리

#### 🛡️ Safety Filter Domain (안전 필터)
- **SktAiSafetyFilterClient** - 안전 필터 관리
- **SktAiSafetyCheckClient** - 콘텐츠 안전성 검사

#### 🚀 Serving Domain (모델 서빙)
- **SktAiServingClient** - 서빙 엔드포인트 관리
- **SktAiApiKeyClient** - API 키 관리
- **SktAiAgentServingClient** - 에이전트 서빙

#### 💾 Resource Domain (리소스 관리)
- **SktAiResourceClient** - 시스템 리소스 관리

### 📋 API 특징
- **OpenAPI 3.0 완전 준수**: 모든 API가 표준 스펙 기반
- **포괄적인 한글 문서화**: 모든 엔드포인트 한글 설명
- **통합 응답 형식**: CustomApiResponse 래퍼를 통한 일관된 응답
- **체계적인 에러 처리**: HTTP 상태 코드와 비즈니스 에러 코드 분리
- **자동 로깅**: 모든 요청/응답 자동 로깅 및 추적
- **페이징 지원**: 대용량 데이터 효율적 처리

## 🗃 데이터베이스

### 개발 환경 (H2 In-Memory)
- **접속 URL**: http://localhost:8080/h2-console
- **JDBC URL**: `jdbc:h2:mem:testdb`
- **Username**: `sa`
- **Password**: (비어있음)
- **특징**: 애플리케이션 재시작 시 데이터 초기화, 빠른 개발 및 테스트

### 운영 환경 (PostgreSQL)
다음 환경 변수를 설정해야 합니다:

```bash
# 데이터베이스 연결 정보
export DB_HOST=localhost
export DB_PORT=5432
export DB_NAME=axportal
export DB_USERNAME=your_username
export DB_PASSWORD=your_password

# SKT AI API 연동 설정
export SKTAI_API_BASE_URL=https://aip-stg.sktai.io
export SKTAI_CLIENT_SECRET=your_sktai_client_secret

# JWT 보안 설정
export JWT_SECRET=your_jwt_secret_key
export JWT_EXPIRATION=86400000
```

### 데이터베이스 스키마
```sql
-- 주요 테이블 구조 (예시)
CREATE TABLE users (
    id VARCHAR(255) PRIMARY KEY,
    username VARCHAR(50) UNIQUE NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    full_name VARCHAR(100),
    status VARCHAR(20) NOT NULL,
    last_login_at TIMESTAMP,
    created_at TIMESTAMP NOT NULL,
    updated_at TIMESTAMP,
    created_by VARCHAR(100),
    updated_by VARCHAR(100),
    is_deleted BOOLEAN DEFAULT FALSE
);

CREATE TABLE projects (
    id VARCHAR(255) PRIMARY KEY,
    name VARCHAR(200) NOT NULL,
    description VARCHAR(1000),
    external_project_id VARCHAR(100) UNIQUE NOT NULL,
    status VARCHAR(20) NOT NULL,
    settings TEXT,
    created_at TIMESTAMP NOT NULL,
    updated_at TIMESTAMP,
    is_deleted BOOLEAN DEFAULT FALSE
);

CREATE TABLE datasets (
    id VARCHAR(255) PRIMARY KEY,
    name VARCHAR(200) NOT NULL,
    description VARCHAR(1000),
    external_dataset_id VARCHAR(100) UNIQUE NOT NULL,
    type VARCHAR(20) NOT NULL,
    status VARCHAR(20) NOT NULL,
    file_count INTEGER,
    total_size BIGINT,
    datasource_id VARCHAR(100),
    project_id VARCHAR(255) NOT NULL,
    created_at TIMESTAMP NOT NULL,
    updated_at TIMESTAMP,
    is_deleted BOOLEAN DEFAULT FALSE,
    FOREIGN KEY (project_id) REFERENCES projects(id)
);
```

## 🧪 테스트 실행 가이드

### 전체 테스트 실행
```bash
# 모든 테스트 실행
./gradlew test

# 테스트 보고서 확인
./gradlew test jacocoTestReport
# Windows
start build/reports/tests/test/index.html
start build/reports/jacoco/test/html/index.html

# Mac/Linux
open build/reports/tests/test/index.html
open build/reports/jacoco/test/html/index.html
```

### 계층별 테스트 실행
```bash
# 컨트롤러 계층 테스트
./gradlew test --tests "*ControllerTest"

# 서비스 계층 테스트
./gradlew test --tests "*ServiceTest"

# 레포지토리 계층 테스트
./gradlew test --tests "*RepositoryTest"

# 통합 테스트
./gradlew test --tests "*IntegrationTest"
```

### 특정 테스트 실행
```bash
# 데이터셋 관련 테스트
./gradlew test --tests "*Dataset*"

# 인증 관련 테스트
./gradlew test --tests "*Authentication*"

# 헬스체크 테스트 (현재 구현됨)
./gradlew test --tests "HealthControllerTest"
```

### 테스트 환경 설정
```yaml
# application-test.yml
spring:
  datasource:
    url: jdbc:h2:mem:testdb;DB_CLOSE_DELAY=-1;DB_CLOSE_ON_EXIT=FALSE
    driver-class-name: org.h2.Driver
  jpa:
    hibernate:
      ddl-auto: create-drop
    database-platform: org.hibernate.dialect.H2Dialect

sktai:
  api:
    base-url: http://localhost:8081  # WireMock 서버 (테스트용)
    
logging:
  level:
    com.skax.aiportal: DEBUG
    org.springframework.web: DEBUG
```

### TestContainers 사용 (통합 테스트)
```java
@SpringBootTest
@Testcontainers
class DatasetIntegrationTest {
    
    @Container
    static PostgreSQLContainer<?> postgres = new PostgreSQLContainer<>("postgres:15")
            .withDatabaseName("test")
            .withUsername("test")
            .withPassword("test");
    
    @DynamicPropertySource
    static void configureProperties(DynamicPropertyRegistry registry) {
        registry.add("spring.datasource.url", postgres::getJdbcUrl);
        registry.add("spring.datasource.username", postgres::getUsername);
        registry.add("spring.datasource.password", postgres::getPassword);
    }
}
```

### Mock 테스트 (외부 API)
```java
@ExtendWith(MockitoExtension.class)
class SktDatasetServiceTest {
    
    @Mock
    private SktAiDatasetClient datasetClient;
    
    @InjectMocks
    private SktDatasetServiceImpl datasetService;
    
    @Test
    @DisplayName("데이터셋 생성 성공 테스트")
    void createDataset_Success() {
        // given
        DatasetCreateRequest request = DatasetCreateRequest.builder()
                .name("테스트 데이터셋")
                .description("테스트용 데이터셋입니다")
                .build();
                
        // when & then
        // 테스트 로직 구현
    }
}

## 📊 모니터링 및 운영

### Spring Boot Actuator 엔드포인트
애플리케이션 실행 후 다음 모니터링 엔드포인트를 사용할 수 있습니다:

#### 핵심 모니터링 엔드포인트
```bash
# 애플리케이션 상태 확인
curl http://localhost:8080/actuator/health

# 상세 헬스체크 정보
curl http://localhost:8080/actuator/health/db
curl http://localhost:8080/actuator/health/diskSpace
curl http://localhost:8080/actuator/health/ping

# 애플리케이션 정보
curl http://localhost:8080/actuator/info

# 메트릭 조회
curl http://localhost:8080/actuator/metrics
curl http://localhost:8080/actuator/metrics/jvm.memory.used
curl http://localhost:8080/actuator/metrics/http.server.requests

# 로그 레벨 확인 및 변경
curl http://localhost:8080/actuator/loggers
curl -X POST http://localhost:8080/actuator/loggers/com.skax.aiportal \
  -H "Content-Type: application/json" \
  -d '{"configuredLevel": "DEBUG"}'
```

#### 프로덕션 모니터링 설정
```yaml
# application-prod.yml
management:
  endpoints:
    web:
      exposure:
        include: health,info,metrics,prometheus
      base-path: /actuator
  endpoint:
    health:
      show-details: when-authorized
      group:
        liveness:
          include: livenessState
        readiness:
          include: readinessState
  metrics:
    export:
      prometheus:
        enabled: true
    tags:
      application: axportal-backend
      environment: production
```

### 로깅 시스템
```bash
# 실시간 로그 확인
tail -f logs/axportal-backend.log

# 에러 로그 필터링
grep -i "error\|exception" logs/axportal-backend.log

# 특정 패키지 로그 확인
grep "com.skax.aiportal" logs/axportal-backend.log

# 특정 시간대 로그 확인
grep "2025-01-" logs/axportal-backend.log

# API 호출 로그 확인
grep "HTTP" logs/axportal-backend.log
```

#### 로깅 특징
- **구조화된 로깅**: JSON 형태의 로그 출력 지원
- **요청 추적**: X-Request-ID를 통한 분산 추적
- **성능 모니터링**: 각 API 호출 시간 자동 측정
- **에러 추적**: 상세한 스택 트레이스 및 컨텍스트 정보
- **외부 API 로깅**: SKT AI API 호출 전후 상세 로그

### 성능 모니터링
```bash
# JVM 메트릭
curl http://localhost:8080/actuator/metrics/jvm.memory.used
curl http://localhost:8080/actuator/metrics/jvm.memory.max
curl http://localhost:8080/actuator/metrics/jvm.gc.memory.allocated

# HTTP 요청 메트릭
curl http://localhost:8080/actuator/metrics/http.server.requests

# 데이터소스 메트릭 (HikariCP)
curl http://localhost:8080/actuator/metrics/hikaricp.connections.active
curl http://localhost:8080/actuator/metrics/hikaricp.connections.max

# 시스템 메트릭
curl http://localhost:8080/actuator/metrics/system.cpu.usage
curl http://localhost:8080/actuator/metrics/system.memory.usage
```

### Docker 지원
```bash
# Docker 이미지 빌드
docker build -t axportal-backend:latest .

# Docker Compose로 전체 스택 실행 (애플리케이션 + PostgreSQL)
docker-compose up -d

# 로그 확인
docker-compose logs -f app

# 컨테이너 상태 확인
docker-compose ps

# 서비스 중지
docker-compose down

# 개발환경 재시작 (데이터 초기화)
docker-compose down -v && docker-compose up -d
```

### 프로덕션 모니터링 도구 연동
```yaml
# Prometheus 메트릭 수집
- job_name: 'axportal-backend'
  static_configs:
    - targets: ['localhost:8080']
  metrics_path: /actuator/prometheus
  scrape_interval: 15s

# Grafana 대시보드 설정
# JVM 메모리, GC, HTTP 요청률, 응답시간 등 주요 메트릭 시각화
```

## 🔧 환경 설정

### 환경별 프로파일

#### 개발 환경 (`dev`)
```yaml
# application-dev.yml
spring:
  datasource:
    url: jdbc:h2:mem:testdb
    driver-class-name: org.h2.Driver
  h2:
    console:
      enabled: true
  jpa:
    hibernate:
      ddl-auto: create-drop
    show-sql: true

logging:
  level:
    com.skax.aiportal: DEBUG
    org.springframework.security: DEBUG
```

#### 스테이징 환경 (`staging`)
```yaml
# application-staging.yml
spring:
  datasource:
    url: jdbc:postgresql://${DB_HOST}:${DB_PORT}/${DB_NAME}
    username: ${DB_USERNAME}
    password: ${DB_PASSWORD}
  jpa:
    hibernate:
      ddl-auto: validate

sktai:
  api:
    base-url: https://aip-stg.sktai.io

logging:
  level:
    root: INFO
    com.skax.aiportal: DEBUG
```

#### 운영 환경 (`prod`)
```yaml
# application-prod.yml
spring:
  datasource:
    url: jdbc:postgresql://${DB_HOST}:${DB_PORT}/${DB_NAME}
    username: ${DB_USERNAME}
    password: ${DB_PASSWORD}
    hikari:
      maximum-pool-size: 20
      minimum-idle: 5
  jpa:
    hibernate:
      ddl-auto: validate
    show-sql: false

sktai:
  api:
    base-url: https://aip.sktai.io

security:
  jwt:
    secret: ${JWT_SECRET}
    expiration: ${JWT_EXPIRATION:86400000}

logging:
  level:
    root: WARN
    com.skax.aiportal: INFO
  file:
    name: logs/axportal-backend.log
```

### 필수 환경 변수

#### 로컬 개발환경
```bash
# .env 파일 (git에 포함하지 않음)
SPRING_PROFILES_ACTIVE=dev
SKTAI_API_BASE_URL=https://aip-stg.sktai.io
SKTAI_CLIENT_SECRET=your_client_secret
```

#### 운영환경
```bash
# 데이터베이스 설정
DB_HOST=your-postgres-host
DB_PORT=5432
DB_NAME=axportal_prod
DB_USERNAME=axportal_user
DB_PASSWORD=secure_password

# SKT AI API 설정
SKTAI_API_BASE_URL=https://aip.sktai.io
SKTAI_CLIENT_SECRET=production_client_secret

# 보안 설정
JWT_SECRET=your-256-bit-secret-key
JWT_EXPIRATION=86400000

# 애플리케이션 설정
SPRING_PROFILES_ACTIVE=prod
SERVER_PORT=8080
```

## 🚀 배포 가이드

### Docker 배포
```bash
# 1. 애플리케이션 빌드
./gradlew bootJar

# 2. Docker 이미지 빌드
docker build -t axportal-backend:1.0.0 .

# 3. Docker 컨테이너 실행
docker run -d \
  --name axportal-backend \
  -p 8080:8080 \
  -e SPRING_PROFILES_ACTIVE=prod \
  -e DB_HOST=your-db-host \
  -e DB_USERNAME=your-username \
  -e DB_PASSWORD=your-password \
  -e SKTAI_CLIENT_SECRET=your-secret \
  -e JWT_SECRET=your-jwt-secret \
  axportal-backend:1.0.0
```

### Docker Compose 배포
```bash
# 전체 스택 실행 (애플리케이션 + PostgreSQL + Redis)
docker-compose up -d

# 로그 모니터링
docker-compose logs -f

# 서비스 중지
docker-compose down
```

### 수동 배포 (JAR 파일)
```bash
# 1. 빌드
./gradlew bootJar

# 2. JAR 파일 실행
java -jar \
  -Dspring.profiles.active=prod \
  -DDB_HOST=your-db-host \
  -DDB_USERNAME=your-username \
  -DDB_PASSWORD=your-password \
  -DSKTAI_CLIENT_SECRET=your-secret \
  -DJWT_SECRET=your-jwt-secret \
  build/libs/axportal-backend-1.0.0.jar
```

### Kubernetes 배포 (선택사항)
```yaml
# k8s-deployment.yaml
apiVersion: apps/v1
kind: Deployment
metadata:
  name: axportal-backend
spec:
  replicas: 3
  selector:
    matchLabels:
      app: axportal-backend
  template:
    metadata:
      labels:
        app: axportal-backend
    spec:
      containers:
      - name: axportal-backend
        image: axportal-backend:1.0.0
        ports:
        - containerPort: 8080
        env:
        - name: SPRING_PROFILES_ACTIVE
          value: "prod"
        - name: DB_HOST
          valueFrom:
            secretKeyRef:
              name: db-secret
              key: host
        # 기타 환경 변수...
```

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
