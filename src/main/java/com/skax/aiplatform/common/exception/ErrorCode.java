package com.skax.aiplatform.common.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

/**
 * 에러 코드 정의 열거형
 * 
 * <p>애플리케이션에서 발생할 수 있는 모든 에러 코드를 정의합니다.
 * HTTP 상태 코드, 에러 코드, 에러 메시지를 포함합니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-08-01
 * @version 1.0.0
 */
@Getter
@RequiredArgsConstructor
public enum ErrorCode {

    // 4xx Client Errors
    INVALID_INPUT_VALUE(HttpStatus.BAD_REQUEST, "C001", "잘못된 입력값입니다"),
    INVALID_TYPE_VALUE(HttpStatus.BAD_REQUEST, "C002", "잘못된 타입 값입니다"),
    MISSING_REQUEST_PARAMETER(HttpStatus.BAD_REQUEST, "C003", "필수 요청 파라미터가 누락되었습니다"),
    INVALID_JSON_FORMAT(HttpStatus.BAD_REQUEST, "C004", "잘못된 JSON 형식입니다"),
    METHOD_NOT_ALLOWED(HttpStatus.METHOD_NOT_ALLOWED, "C005", "지원하지 않는 HTTP 메서드입니다"),
    
    // 인증/인가 관련 에러
    UNAUTHORIZED(HttpStatus.UNAUTHORIZED, "A001", "인증이 필요합니다"),
    INVALID_TOKEN(HttpStatus.UNAUTHORIZED, "A002", "유효하지 않은 토큰입니다"),
    EXPIRED_TOKEN(HttpStatus.UNAUTHORIZED, "A003", "만료된 토큰입니다"),
    FORBIDDEN(HttpStatus.FORBIDDEN, "A004", "접근 권한이 없습니다"),
    INSUFFICIENT_PRIVILEGES(HttpStatus.FORBIDDEN, "A005", "권한이 부족합니다"),
    
    // 리소스 관련 에러
    RESOURCE_NOT_FOUND(HttpStatus.NOT_FOUND, "R001", "요청한 리소스를 찾을 수 없습니다"),
    USER_NOT_FOUND(HttpStatus.NOT_FOUND, "R002", "사용자를 찾을 수 없습니다"),
    ROLE_NOT_FOUND(HttpStatus.NOT_FOUND, "R003", "역할을 찾을 수 없습니다"),
    
    // 중복 데이터 관련 에러
    DUPLICATE_RESOURCE(HttpStatus.CONFLICT, "D001", "이미 존재하는 리소스입니다"),
    EMAIL_ALREADY_EXISTS(HttpStatus.CONFLICT, "D002", "이미 존재하는 이메일입니다"),
    USERNAME_ALREADY_EXISTS(HttpStatus.CONFLICT, "D003", "이미 존재하는 사용자명입니다"),
    
    // 비즈니스 로직 관련 에러
    BUSINESS_LOGIC_ERROR(HttpStatus.BAD_REQUEST, "B001", "비즈니스 로직 오류입니다"),
    INVALID_PASSWORD(HttpStatus.BAD_REQUEST, "B002", "잘못된 비밀번호입니다"),
    ACCOUNT_LOCKED(HttpStatus.BAD_REQUEST, "B003", "계정이 잠겨있습니다"),
    ACCOUNT_DISABLED(HttpStatus.BAD_REQUEST, "B004", "비활성화된 계정입니다"),
    
    // 외부 서비스 관련 에러
    EXTERNAL_SERVICE_ERROR(HttpStatus.BAD_GATEWAY, "E001", "외부 서비스 오류입니다"),
    EXTERNAL_SERVICE_TIMEOUT(HttpStatus.GATEWAY_TIMEOUT, "E002", "외부 서비스 응답 시간 초과입니다"),
    EXTERNAL_SERVICE_UNAVAILABLE(HttpStatus.SERVICE_UNAVAILABLE, "E003", "외부 서비스를 사용할 수 없습니다"),
    
    // 외부 API 관련 에러
    EXTERNAL_API_UNAUTHORIZED(HttpStatus.UNAUTHORIZED, "E004", "외부 API 인증 실패"),
    EXTERNAL_API_FORBIDDEN(HttpStatus.FORBIDDEN, "E005", "외부 API 접근 권한 없음"),
    EXTERNAL_API_NOT_FOUND(HttpStatus.NOT_FOUND, "E006", "외부 API 리소스 없음"),
    EXTERNAL_API_BAD_REQUEST(HttpStatus.BAD_REQUEST, "E007", "외부 API 잘못된 요청"),
    EXTERNAL_API_VALIDATION_ERROR(HttpStatus.UNPROCESSABLE_ENTITY, "E008", "외부 API 유효성 검증 실패"),
    EXTERNAL_API_SERVER_ERROR(HttpStatus.BAD_GATEWAY, "E009", "외부 API 서버 오류"),
    
    // 5xx Server Errors
    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "S001", "서버 내부 오류가 발생했습니다"),
    DATABASE_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "S002", "데이터베이스 오류가 발생했습니다"),
    SERVICE_UNAVAILABLE(HttpStatus.SERVICE_UNAVAILABLE, "S003", "서비스를 사용할 수 없습니다"),
    
    // 파일 관련 에러
    FILE_NOT_FOUND(HttpStatus.NOT_FOUND, "F001", "파일을 찾을 수 없습니다"),
    FILE_UPLOAD_ERROR(HttpStatus.BAD_REQUEST, "F002", "파일 업로드 중 오류가 발생했습니다"),
    FILE_SIZE_EXCEEDED(HttpStatus.BAD_REQUEST, "F003", "파일 크기가 제한을 초과했습니다"),
    INVALID_FILE_TYPE(HttpStatus.BAD_REQUEST, "F004", "지원하지 않는 파일 형식입니다"),
    
    // 데이터 검증 관련 에러
    VALIDATION_ERROR(HttpStatus.BAD_REQUEST, "V001", "데이터 검증 오류입니다"),
    CONSTRAINT_VIOLATION(HttpStatus.BAD_REQUEST, "V002", "데이터 제약 조건 위반입니다"),
    DATA_INTEGRITY_ERROR(HttpStatus.BAD_REQUEST, "V003", "데이터 무결성 오류입니다");

    private final HttpStatus status;
    private final String code;
    private final String message;
}
