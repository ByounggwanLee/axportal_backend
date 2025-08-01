# AxportalBackend

## 프로젝트 개요

AxportalBackend는 Spring Boot 3.4.4 기반의 AI Portal RESTful API 서버입니다.  
JWT 인증, 다중 데이터베이스 환경 지원, OpenAPI 3 문서화 등의 기능을 제공합니다.

## 기술 스택

### 핵심 프레임워크
- **Spring Boot 3.4.4**
- **Java 17**
- **Maven**

### 주요 라이브러리
- **Spring Data JPA** - ORM 및 데이터 액세스
- **MyBatis 3.0.5** - SQL 매핑 프레임워크
- **Spring Cloud OpenFeign** - HTTP 클라이언트
- **Spring Security** - 보안 및 인증
- **JWT (jjwt 0.12.6)** - JSON Web Token 인증
- **SpringDoc OpenAPI 3** - API 문서화
- **Lombok** - 보일러플레이트 코드 제거
- **MapStruct** - 객체 매핑
- **Jakarta Validation** - 데이터 검증

### 데이터베이스
- **H2** - 로컬 개발환경
- **PostgreSQL** - 외부 개발환경
- **Tibero** - 개발/스테이징/운영환경

## 프로젝트 구조

```
src/main/java/com/skax/aiplatform/
├── AxportalBackendApplication.java     # 메인 애플리케이션 클래스
├── client/                             # Feign Client 인터페이스
├── config/                             # 설정 클래스
│   ├── JpaConfig.java                 # JPA 설정
│   ├── SecurityConfig.java            # Spring Security 설정
│   ├── OpenApiConfig.java             # OpenAPI 문서화 설정
│   └── WebConfig.java                 # Web MVC 설정
├── constant/                          # 상수 정의
│   └── Constants.java                 # 애플리케이션 상수
├── controller/                        # REST 컨트롤러
│   └── HealthController.java          # 헬스 체크 컨트롤러
├── service/                           # 비즈니스 로직
├── repository/                        # 데이터 액세스
├── entity/                            # JPA 엔티티
│   └── BaseEntity.java               # 공통 엔티티 클래스
├── dto/                              # 데이터 전송 객체
└── common/                           # 공통 기능
    ├── exception/                    # 예외 처리
    │   ├── ErrorCode.java           # 에러 코드 정의
    │   ├── CustomException.java     # 기본 예외 클래스
    │   ├── BusinessException.java   # 비즈니스 예외
    │   ├── ValidationException.java # 검증 예외
    │   └── GlobalExceptionHandler.java # 전역 예외 처리
    ├── response/                     # 응답 포맷
    │   ├── AxResponse.java          # 표준 응답 래퍼
    │   └── PageResponse.java        # 페이징 응답 래퍼
    ├── security/                     # 보안 관련
    └── util/                         # 유틸리티

.vscode/                              # VS Code 설정
├── launch.json                       # Run/Debug 설정 (외부Local 기본)
├── tasks.json                        # 작업 설정 (Maven Wrapper 사용)
├── settings.json                     # 워크스페이스 설정
└── launch.properties                 # 런타임 속성
```

## 환경별 프로필

### 1. local (기본)
- **데이터베이스**: H2 인메모리
- **포트**: 8080
- **H2 콘솔**: http://localhost:8080/api/v1/h2-console

### 2. elocal (외부 로컬)
- **데이터베이스**: H2 인메모리
- **용도**: 외부 로컬 테스트

### 3. edev (외부 개발)
- **데이터베이스**: PostgreSQL
- **용도**: 외부 개발 환경

### 4. dev (개발)
- **데이터베이스**: Tibero
- **용도**: 내부 개발 환경

### 5. staging (스테이징)
- **데이터베이스**: Tibero
- **용도**: 스테이징 환경

### 6. prod (운영)
- **데이터베이스**: Tibero
- **용도**: 운영 환경

## 실행 방법

### 1. Maven Wrapper를 사용한 개발 환경 실행

**Windows:**
```cmd
# 프로젝트 컴파일
.\mvnw.cmd clean compile

# 테스트 실행
.\mvnw.cmd test

# 패키지 빌드
.\mvnw.cmd clean package

# Spring Boot 실행 (로컬 환경)
.\mvnw.cmd spring-boot:run

# 특정 프로필로 실행
.\mvnw.cmd spring-boot:run -Dspring-boot.run.profiles=local
.\mvnw.cmd spring-boot:run -Dspring-boot.run.profiles=elocal
.\mvnw.cmd spring-boot:run -Dspring-boot.run.profiles=edev
```

**Linux/Mac:**
```bash
# 실행 권한 부여 (최초 1회)
chmod +x mvnw

# 프로젝트 컴파일
./mvnw clean compile

# 테스트 실행
./mvnw test

# 패키지 빌드
./mvnw clean package

# Spring Boot 실행 (로컬 환경)
./mvnw spring-boot:run

# 특정 프로필로 실행
./mvnw spring-boot:run -Dspring-boot.run.profiles=local
./mvnw spring-boot:run -Dspring-boot.run.profiles=elocal
./mvnw spring-boot:run -Dspring-boot.run.profiles=edev
```

### 2. 편의 스크립트 사용

**Windows:**
```cmd
# 대화형 실행 스크립트
run.bat
```

**Linux/Mac:**
```bash
# 실행 권한 부여 (최초 1회)
chmod +x run.sh

# 대화형 실행 스크립트
./run.sh
```

### 3. JAR 파일 직접 실행

```bash
# JAR 파일 빌드
.\mvnw.cmd clean package  # Windows
./mvnw clean package     # Linux/Mac

# JAR 파일로 실행
java -jar target/aiplatform-1.0.0.jar

# 프로필별 실행
java -jar target/aiplatform-1.0.0.jar --spring.profiles.active=local
java -jar target/aiplatform-1.0.0.jar --spring.profiles.active=edev
java -jar target/aiplatform-1.0.0.jar --spring.profiles.active=prod
```

### 4. VS Code 작업(Task) 사용

VS Code에서 `Ctrl+Shift+P` → `Tasks: Run Task` 선택 후:
- **Spring Boot: Run (External Local) - Default** - 기본 외부 로컬 환경 실행 ⭐
- **Maven: Clean Compile** - 프로젝트 컴파일
- **Maven: Clean Package** - JAR 파일 빌드  
- **Maven: Test** - 테스트 실행
- **Spring Boot: Run (Local)** - 로컬 환경으로 실행
- **Spring Boot: Run (External Local)** - 외부 로컬 환경으로 실행
- **Spring Boot: Run (External Dev)** - 외부 개발 환경으로 실행

### 5. VS Code Run/Debug 사용

VS Code에서 `F5` 키를 누르거나 Run/Debug 패널에서:
- **Spring Boot App (External Local)** - 외부 로컬 환경 디버그 ⭐ (기본)
- **Spring Boot App (Local)** - 로컬 환경 디버그
- **Spring Boot App (External Dev)** - 외부 개발 환경 디버그  
- **Debug HealthController** - HealthController 디버그용

> 📌 **기본 설정**: Run 및 Debug 실행 시 **외부Local환경(elocal)**이 기본으로 설정되어 있습니다.

## API 문서

### Swagger UI
- **로컬**: http://localhost:8080/api/v1/swagger-ui.html
- **API Docs**: http://localhost:8080/api/v1/api-docs

### 주요 엔드포인트
- `GET /health` - 헬스 체크
- `GET /info` - 시스템 정보
- `GET /actuator/health` - Spring Actuator 헬스 체크

## 테스트 실행

**Windows:**
```cmd
# 전체 테스트 실행
.\mvnw.cmd test

# 특정 테스트 클래스 실행
.\mvnw.cmd test -Dtest=HealthControllerTest

# 테스트 커버리지 포함 실행
.\mvnw.cmd clean test jacoco:report
```

**Linux/Mac:**
```bash
# 전체 테스트 실행
./mvnw test

# 특정 테스트 클래스 실행
./mvnw test -Dtest=HealthControllerTest

# 테스트 커버리지 포함 실행
./mvnw clean test jacoco:report
```

## 빌드 및 배포

### 1. Maven Wrapper 빌드

**Windows:**
```cmd
# 기본 빌드
.\mvnw.cmd clean package

# 프로필별 빌드
.\mvnw.cmd clean package -P local
.\mvnw.cmd clean package -P dev
.\mvnw.cmd clean package -P prod

# 테스트 스킵 빌드
.\mvnw.cmd clean package -DskipTests

# 컴파일만 수행
.\mvnw.cmd clean compile
```

**Linux/Mac:**
```bash
# 기본 빌드
./mvnw clean package

# 프로필별 빌드
./mvnw clean package -P local
./mvnw clean package -P dev
./mvnw clean package -P prod

# 테스트 스킵 빌드
./mvnw clean package -DskipTests

# 컴파일만 수행
./mvnw clean compile
```

### 2. 배포 파일
- **JAR**: `target/aiplatform-1.0.0.jar`
- **설정 파일**: `src/main/resources/application-{profile}.yml`

## 데이터베이스 설정

### H2 (로컬 개발)
```yaml
spring:
  datasource:
    url: jdbc:h2:mem:axportal
    username: sa
    password: 
```

### PostgreSQL (외부 개발)
```yaml
spring:
  datasource:
    url: jdbc:postgresql://localhost:5432/axportal_edev
    username: axportal_user
    password: axportal_password
```

### Tibero (운영)
```yaml
spring:
  datasource:
    url: jdbc:tibero:thin:@prod-db-server:8629:axportal_prod
    username: axportal_prod
    password: ${DB_PASSWORD}
```

## 환경 변수

### 운영 환경 필수 환경 변수
```bash
DB_PASSWORD=운영DB비밀번호
JWT_SECRET=JWT시크릿키
```

### 선택적 환경 변수
```bash
SERVER_PORT=8080
SPRING_PROFILES_ACTIVE=prod
LOG_LEVEL=INFO
```

## 보안 설정

### JWT 토큰
- **만료 시간**: 24시간 (운영환경: 1시간)
- **리프레시 토큰**: 7일 (운영환경: 24시간)
- **알고리즘**: HS256

### CORS 설정
- **허용 도메인**: `localhost:*`, `*.skax.com`
- **허용 메서드**: GET, POST, PUT, PATCH, DELETE, OPTIONS
- **자격 증명**: 허용

## 모니터링

### Spring Actuator
- `/actuator/health` - 헬스 체크
- `/actuator/info` - 애플리케이션 정보
- `/actuator/metrics` - 메트릭 정보

### 로깅
- **로그 레벨**: DEBUG (개발), INFO (운영)
- **로그 파일**: 콘솔 출력 (Docker 환경)

## 개발 가이드라인

### 1. 코딩 컨벤션
- **Java**: Google Java Style Guide 준수
- **네이밍**: camelCase (변수, 메서드), PascalCase (클래스)
- **패키지**: 소문자, 점(.) 구분

### 2. 커밋 메시지
```
feat: 새로운 기능 추가
fix: 버그 수정
docs: 문서 수정
style: 코드 포맷팅
refactor: 리팩토링
test: 테스트 추가/수정
chore: 빌드 설정 등
```

### 3. 브랜치 전략
- **main**: 운영 배포 브랜치
- **develop**: 개발 통합 브랜치
- **feature/기능명**: 기능 개발 브랜치
- **hotfix/수정명**: 긴급 수정 브랜치

## 라이센스

MIT License - 자세한 내용은 [LICENSE](LICENSE) 파일 참조

## 작성자

**ByounggwanLee**
- Email: developer@skax.com
- GitHub: https://github.com/byounggwanlee

## 버전 히스토리

### v1.0.0 (2025-08-01)
- 초기 프로젝트 구조 생성
- Spring Boot 3.4.4 기반 설정
- JWT 인증 기반 구조 구현
- 다중 데이터베이스 환경 지원
- OpenAPI 3 문서화 설정
- 전역 예외 처리 구현
- 헬스 체크 API 구현
