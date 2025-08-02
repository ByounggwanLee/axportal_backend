# GitHub Copilot Instructions for Spring Boot Project

## 프로젝트 정보
- **프로젝트명**: AxportalBackend Project
- **개발자**: ByounggwanLee
- **생성일**: 2025-08-01
- **목표**: Spring Boot 기반의 AI Portal RESTful API 개발
- **Java 버전**: 17+
- **Spring Boot 버전**: 3.4.4
- **빌드 도구**: Maven
- **데이터베이스**: Tibero (운영), Tibero (테스트), Tibero (개발), H2 (로컬 개발), PostGreSql (외부개발), H2 (외부로컬 개발)

## 기술 스택
- **ORM**: Spring Data JPA, MyBatis
- **External API**: Spring Cloud OpenFeign
- **Documentation**: SpringDoc OpenAPI 3
- **Testing**: JUnit 5, Mockito
- **Logging**: SLF4J, Logback, 
- **Security**: Spring Security, JWT
- **Utilities**: Lombok, Jakarta Validation, MapStruct

## 코딩 스타일 가이드

### 1. 네이밍 컨벤션
- **클래스명**: PascalCase (예: UserService, ProductController)
- **메서드명**: camelCase (예: createUser, findByEmail)
- **변수명**: camelCase (예: userId, createdAt)
- **상수명**: UPPER_SNAKE_CASE (예: MAX_RETRY_COUNT)
- **패키지명**: lowercase with dots (예: com.byounggwanlee.project)

### 2. 파일 구조 및 패키지 규칙
```
com.skax.aiplatform/
├── client/          # Feign Client 인터페이스
├── config/          # 설정 클래스
├── constant/        # 상수 정의
├── controller/      # REST 컨트롤러
├── service/         # 비즈니스 로직
├── repository/      # 데이터 액세스
├── entity/          # JPA 엔티티
├── dto/             # 데이터 전송 객체
└── common           # 공통 기능
    ├── exception/   # 예외 처리
    ├── security/    # 보안 관련
    └── util/        # 유틸리티
```

### 3. 어노테이션 사용 규칙
- **Lombok**: @Getter, @Builder, @NoArgsConstructor 우선 사용
- **JPA**: @Entity, @Table, @Column 명시적 설정
- **Validation**: @Valid, @NotNull, @NotBlank 적극 활용
- **Spring**: @Service, @Repository, @RestController 표준 사용

### 4. 메서드 구현 패턴
```java
// Service 메서드 패턴
@Transactional(readOnly = true)
public EntityResponse getEntityById(Long id) {
    Entity entity = findEntityById(id);
    return EntityResponse.from(entity);
}

private Entity findEntityById(Long id) {
    return entityRepository.findById(id)
            .orElseThrow(() -> new CustomException(ErrorCode.ENTITY_NOT_FOUND));
}
```
### 5. 공통 기능
- **RESTful API 설계**: 일관된 REST API 패턴
- **통합된 응답 포맷**: AxResponse 래퍼를 통한 표준화된 응답
- **페이징 처리**: PageResponse를 통한 효율적인 대용량 데이터 처리
- **예외 처리**: GlobalExceptionHandler를 통한 통합 예외 관리
- **API 문서화**: OpenAPI 3 기반 자동 문서 생성
- **입력 검증**: Jakarta Validation을 통한 요청 데이터 검증
- **로깅**: 구조화된 로깅 및 요청 추적 자동생성
- **주석**: JavaDoc과 OpenApi 생성
- **상수화**: 애플리케이션 상수 클래스를 생성하여 사용
- **Mapping**: MapStruct를 통한 DTO와 Entity 간 변환

## API 설계 규칙

### 1. REST API 엔드포인트 패턴
```
GET    /api/v1/users          # 목록 조회
GET    /api/v1/users/{id}     # 단일 조회
POST   /api/v1/users          # 생성
PUT    /api/v1/users/{id}     # 전체 수정
PATCH  /api/v1/users/{id}     # 부분 수정
DELETE /api/v1/users/{id}     # 삭제
```

### 2. 응답 형식 표준화
```java
// 성공 응답
{
  "success": true,
  "message": "조회 성공",
  "data": { ... },
  "timestamp": "2025-07-19T00:39:49Z"
}

// 오류 응답
{
  "success": false,
  "message": "사용자를 찾을 수 없습니다",
  "errorCode": "USER_NOT_FOUND",
  "timestamp": "2025-07-19T00:39:49Z"
}
```

### 3. 페이징 응답 형식
```java
{
  "success": true,
  "message": "목록 조회 성공",
  "data": {
    "content": [...],
    "pageable": {
      "page": 0,
      "size": 20,
      "sort": "createdAt,desc"
    },
    "totalElements": 100,
    "totalPages": 5,
    "first": true,
    "last": false
  }
}
```

## 데이터베이스 설계 규칙

### 1. 테이블 명명 규칙
- 테이블명: snake_case, 복수형 (예: users, products, order_items)
- 컬럼명: snake_case (예: created_at, user_id, email_address)
- 인덱스명: idx_테이블명_컬럼명 (예: idx_users_email)

### 2. 공통 컬럼
```java
// 모든 엔티티에 포함할 공통 필드
@CreatedDate
@Column(name = "created_at", updatable = false)
private LocalDateTime createdAt;

@LastModifiedDate
@Column(name = "updated_at")
private LocalDateTime updatedAt;

@Column(name = "created_by", length = 50)
private String createdBy;

@Column(name = "updated_by", length = 50)
private String updatedBy;
```

### 3. JPA 엔티티 규칙
```java
@Entity
@Table(name = "table_name")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@EntityListeners(AuditingEntityListener.class)
public class EntityName extends BaseEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    // 나머지 필드들...
}
```

## 예외 처리 규칙

### 1. 커스텀 예외 계층구조
```java
// 기본 예외
public class CustomException extends RuntimeException {
    private final ErrorCode errorCode;
}

// 비즈니스 예외
public class BusinessException extends CustomException {
    // 비즈니스 로직 관련 예외
}

// 검증 예외
public class ValidationException extends CustomException {
    // 입력값 검증 관련 예외
}
```

### 2. ErrorCode 정의 패턴
```java
@Getter
@RequiredArgsConstructor
public enum ErrorCode {
    // 4xx Client Errors
    INVALID_INPUT_VALUE(HttpStatus.BAD_REQUEST, "C001", "잘못된 입력값입니다"),
    USER_NOT_FOUND(HttpStatus.NOT_FOUND, "C002", "사용자를 찾을 수 없습니다"),
    EMAIL_ALREADY_EXISTS(HttpStatus.CONFLICT, "C003", "이미 존재하는 이메일입니다"),
    
    // 5xx Server Errors
    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "S001", "서버 내부 오류가 발생했습니다");
    
    private final HttpStatus status;
    private final String code;
    private final String message;
}
```

## 테스트 코드 작성 규칙

### 1. 테스트 클래스 구조
```java
@DisplayName("사용자 서비스 테스트")
class UserServiceTest {
    
    // given-when-then 패턴 사용
    @Test
    @DisplayName("사용자 생성 성공")
    void createUser_Success() {
        // given
        UserCreateRequest request = createUserRequest();
        
        // when
        UserResponse result = userService.createUser(request);
        
        // then
        assertThat(result.getEmail()).isEqualTo(request.getEmail());
    }
    
    // 테스트 헬퍼 메서드는 private으로 하단에 배치
    private UserCreateRequest createUserRequest() {
        // 테스트 데이터 생성 로직
    }
}
```

### 2. Mock 사용 규칙
```java
// given 절에서 Mock 동작 정의
given(userRepository.findById(anyLong())).willReturn(Optional.of(user));
given(passwordEncoder.encode(anyString())).willReturn("encodedPassword");

// then 절에서 검증
verify(userRepository).save(any(User.class));
verify(userRepository, times(1)).findById(userId);
```

## 로깅 규칙

### 1. 로그 레벨 사용 기준
```java
log.error("시스템 오류", exception);     // 시스템 오류
log.warn("비정상 상황이지만 처리 가능");   // 경고
log.info("중요한 비즈니스 이벤트");       // 정보
log.debug("디버깅 정보");              // 디버그
```

### 2. 로그 메시지 형식
```java
// 성공 로그
log.info("Created new user with id: {}", savedUser.getId());

// 오류 로그
log.error("Failed to create user with email: {}, error: {}", 
          request.getEmail(), exception.getMessage());

// 비즈니스 로그
log.info("User {} successfully logged in", user.getEmail());
```

## 보안 규칙

### 1. 인증/인가 처리
```java
// JWT 토큰 검증
@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
public UserResponse getUserProfile() {
    // 구현
}

// 자원 소유자 검증
@PreAuthorize("#userId == authentication.principal.id or hasRole('ADMIN')")
public UserResponse updateUser(@PathVariable Long userId, ...) {
    // 구현
}
```

### 2. 민감한 정보 처리
```java
// 비밀번호는 로그에 출력하지 않음
@ToString.Exclude
private String password;

// API 응답에서 민감한 정보 제외
@JsonIgnore
private String password;
```

## 성능 최적화 규칙

### 1. 데이터베이스 쿼리 최적화
```java
// N+1 문제 방지를 위한 Fetch Join 사용
@Query("SELECT u FROM User u JOIN FETCH u.orders WHERE u.active = true")
List<User> findActiveUsersWithOrders();

// 페이징 쿼리 최적화
@Query(value = "SELECT u FROM User u WHERE u.name LIKE %:name%",
       countQuery = "SELECT count(u) FROM User u WHERE u.name LIKE %:name%")
Page<User> findByNameContaining(@Param("name") String name, Pageable pageable);
```

### 2. 캐싱 전략
```java
@Cacheable(value = "users", key = "#id")
public UserResponse getUserById(Long id) {
    // 구현
}

@CacheEvict(value = "users", key = "#result.id")
public UserResponse updateUser(Long id, UserUpdateRequest request) {
    // 구현
}
```

## 문서화 규칙

### 1. API 문서화
```java
@Operation(summary = "사용자 생성", description = "새로운 사용자를 생성합니다.")
@ApiResponses({
    @ApiResponse(responseCode = "201", description = "사용자 생성 성공"),
    @ApiResponse(responseCode = "400", description = "잘못된 요청 데이터"),
    @ApiResponse(responseCode = "409", description = "이메일 중복")
})
public ResponseEntity<ApiResponse<UserResponse>> createUser(
        @Valid @RequestBody UserCreateRequest request) {
    // 구현
}
```

### 2. 클래스 문서화
```java
/**
 * 사용자 관리 서비스
 * 
 * <p>사용자의 생성, 조회, 수정, 삭제 등의 비즈니스 로직을 처리합니다.
 * 이메일 중복 검증, 비밀번호 암호화 등의 기능을 포함합니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-07-19
 * @version 1.0
 */
@Service
public class UserService {
    // 구현
}
```

## 특별 지시사항

### 1. 코드 생성 우선순위
1. 보안을 최우선으로 고려
2. 예외 처리를 반드시 포함
3. 로깅 구문 적절히 삽입
4. 테스트 가능한 구조로 설계
5. 성능을 고려한 구현
6. 애플리케이션 상수 클래스(Constants)를 생성하여 사용
7. sample소스는 아래와 같이 sample디렉토리에 생성
8. Controller에서 사용하는 DTO(/dto/** 디렉토리)생성시 
   - Request는 Req 접미사 사용하고 Request 디렉토리에 생성
   - Response는 Res 접미사 사용하고 Response 디렉토리에 생성
   - 이외는 기본 디렉토리에 생성
9. Feign Client에서 사용하는 DTO(/client/** 디렉토리) 생성시 
   - File명에 Req, Request, req, request가 포함된 경우 Request 디렉토리에 생성
   - File명에 Res, Response, res, response가 포함된 경우 Response 디렉토리에 생성
   - 이외는 기본 디렉토리에 생성
```
controller: controller/sample
service: service/sample, service/sample/Impl
entity: entity/sample
repository: repository/sample
dto: repository/sample/request, repository/sample/response
mapper: repository/sample/request, repository/sample/response
```

### 2. 금지사항
- System.out.println() 사용 금지 (로깅 프레임워크 사용)
- Raw Type 사용 금지 (제네릭 타입 명시)
- Magic Number 사용 금지 (상수로 정의)
- 하드코딩된 문자열 사용 최소화
- try-catch로 예외 숨기기 금지
- 불필요한 주석 사용 금지 (명확한 코드 작성으로 주석 최소화)
- 불필요한 코드 주석 처리 금지 (코드 삭제 후 Git 기록으로 관리)
- 불필요한 import문 사용 금지 (정리된 import문 유지)
- 불필요한 getter/setter 메서드 사용 금지 (Lombok 활용)
- 불필요한 클래스, 메서드, 변수 선언 금지 (명확한 역할 분리)
- 복잡한 if-else 구조 사용 금지 (가독성 높은 코드 작성)
- 불필요한 의존성 주입 사용 금지 (생성자 주입 우선)
- 불필요한 예외 처리 사용 금지 (명확한 예외 처리)
- 불필요한 테스트 코드 작성 금지 (실제 동작 검증 중심)
- 불필요한 의존성 추가 금지 (프로젝트 목적에 맞는 라이브러리만 사용)
- Controller에서 Feign Client DTO 사용 금지 (Service 계층에서 처리)
- Controller에서 Entity 사용 금지 (Service 계층에서 처리)

### 3. 권장사항
- Optional 적극 활용으로 NPE 방지
- Stream API 활용한 함수형 프로그래밍
- Builder 패턴 사용으로 객체 생성 명확화
- 인터페이스 기반 설계로 확장성 확보
- 단위 테스트 커버리지 80% 이상 유지
- Mocking 프레임워크 사용으로 외부 의존성 최소화
- Lombok을 활용한 코드 간결화
- MapStruct를 통한 DTO와 Entity 간 변환 최적화
- OpenAPI 3를 통한 API 문서화 자동화

## 프로젝트별 특수 요구사항

### 1. AXPORTAL BACKEND 개인 프로젝트 규칙
- 모든 커밋 메시지는 한글로 작성
- API 응답 메시지는 한글로 제공
- 에러 메시지도 사용자 친화적인 한글로 작성
- 주석은 한글로 작성하되 기술적 용어는 영어 병기

### 2. 개발 환경 설정
- 로컬: H2 인메모리 데이터베이스 사용
- 외부개발: PostGreSQL 사용 및 TestContainers 활용한 실제 DB 테스트
- 개발: Tibero 사용 및 TestContainers 활용한 실제 DB 테스트
- 스테이징: Tibero 사용
- 운영: Tibero 사용
- 개발적용시 Docker Compose 활용

### 3. CI/CD 관련
- GitHub Actions를 통한 자동 빌드/테스트
- PR시 코드 리뷰 필수
- main 브랜치 직접 푸시 금지
- 태그 기반 배포 전략 사용

## 환경별 설정 가이드

### 1. 외부Local 환경 (elocal)
```yaml
database: H2 in-memory
logging_level: DEBUG
security: 완화된 설정
cache: 비활성화
```

### 2. 외부개발 환경 (edev)
```yaml
database: PostGreSQL (외부개발 DB)
logging_level: DEBUG
security: 완화된 설정
cache: 비활성화
```

### 3. Local 환경 (local)
```yaml
database: H2 in-memory
logging_level: DEBUG
security: 완화된 설정
cache: 비활성화
```

### 4. 개발 환경 (dev)
```yaml
database: Tibero (개발 DB)
logging_level: DEBUG
security: 완화된 설정
cache: 비활성화
```

### 5. 스테이징 환경 (staging)
```yaml
database: Tibero (테스트 DB)
logging_level: INFO
security: 운영과 동일
cache: 활성화
```

### 6. 운영 환경 (prod)
```yaml
database: Tibero (운영 DB)
logging_level: WARN
security: 강화된 설정
cache: 활성화
monitoring: 전체 활성화
```

## 팀 개발 규칙

### 1. 코드 리뷰 체크리스트
- [ ] 보안 취약점 검토 완료
- [ ] 예외 처리 적절성 확인
- [ ] 테스트 코드 포함 여부
- [ ] 성능 영향도 검토
- [ ] 문서화 완료

### 2. 브랜치 전략
```
main: 운영 배포 브랜치
develop: 개발 통합 브랜치
feature/기능명: 기능 개발 브랜치
hotfix/이슈번호: 긴급 수정 브랜치
```

### 3. 커밋 메시지 규칙
- 한글 사용: 모든 메시지는 한글로 작성합니다.
- 명확성: 커밋이 무엇을 변경했는지, 왜 변경했는지 명확하게 전달합니다.
- 일관성: 프로젝트 내에서 정한 규칙을 일관성 있게 따릅니다.
- 제목 (Subject Line)
   - 형식: [타입]: [간결한 요약 (명령형 어조)]
   - 길이: 50자 이내 (권장)
   - 명령형 어조 사용: "~을 추가", "~을 수정", "~을 제거" 와 같이 동사로 시작합니다. (예: "기능 추가", "버그 수정")
   - 마침표 사용 금지: 제목 끝에는 마침표를 찍지 않습니다.
```
feat: 새로운 기능 추가
fix: 버그 수정
docs: 문서 수정
style: 코드 포맷팅
refactor: 코드 리팩토링
test: 테스트 코드 추가/수정
chore: 기타 작업
```
## 성과 지표
- 코드 일관성: 90% 이상
- 예외 처리 포함률: 95% 이상
- 테스트 커버리지: 80% 이상
- 보안 규칙 준수율: 100%
- 문서화 완성도: 85% 이상

## AI 코딩 최적화 설정

### 1. Copilot 코드 생성 우선순위
```yaml
priorities:
  - security_first: true
  - performance_aware: true
  - test_driven: true
  - documentation_included: true
  - korean_comments: true
```

### 2. 템플릿 우선순위
```java
// 엔티티 생성시 반드시 포함할 패턴
@Entity
@Table(name = "테이블명")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@EntityListeners(AuditingEntityListener.class)
public class EntityName extends BaseEntity {
    // 구현
}
```

### 3. 의존성 주입 패턴
```java
// Constructor Injection 우선 사용
@RequiredArgsConstructor
public class ServiceClass {
    private final Repository repository;
    // Field Injection 금지, Setter Injection 최소화
}
```