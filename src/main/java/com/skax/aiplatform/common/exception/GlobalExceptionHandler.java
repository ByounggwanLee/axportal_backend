package com.skax.aiplatform.common.exception;

import com.skax.aiplatform.common.response.AxResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import java.util.stream.Collectors;

/**
 * 전역 예외 처리 핸들러
 * 
 * <p>애플리케이션에서 발생하는 모든 예외를 일관된 형식으로 처리합니다.
 * 표준화된 에러 응답을 제공하고 적절한 로깅을 수행합니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-08-01
 * @version 1.0.0
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 커스텀 예외 처리
     * 
     * @param ex CustomException
     * @return 에러 응답
     */
    @ExceptionHandler(CustomException.class)
    public ResponseEntity<AxResponse<Void>> handleCustomException(CustomException ex) {
        log.warn("Custom exception occurred: {}", ex.getMessage(), ex);
        
        ErrorCode errorCode = ex.getErrorCode();
        AxResponse<Void> response = AxResponse.failure(ex.getMessage(), errorCode.getCode());
        
        return ResponseEntity.status(errorCode.getStatus()).body(response);
    }

    /**
     * 비즈니스 예외 처리
     * 
     * @param ex BusinessException
     * @return 에러 응답
     */
    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<AxResponse<Void>> handleBusinessException(BusinessException ex) {
        log.warn("Business exception occurred: {}", ex.getMessage(), ex);
        
        ErrorCode errorCode = ex.getErrorCode();
        AxResponse<Void> response = AxResponse.failure(ex.getMessage(), errorCode.getCode());
        
        return ResponseEntity.status(errorCode.getStatus()).body(response);
    }

    /**
     * 검증 예외 처리
     * 
     * @param ex ValidationException
     * @return 에러 응답
     */
    @ExceptionHandler(ValidationException.class)
    public ResponseEntity<AxResponse<Void>> handleValidationException(ValidationException ex) {
        log.warn("Validation exception occurred: {}", ex.getMessage(), ex);
        
        ErrorCode errorCode = ex.getErrorCode();
        AxResponse<Void> response = AxResponse.failure(ex.getMessage(), errorCode.getCode());
        
        return ResponseEntity.status(errorCode.getStatus()).body(response);
    }

    /**
     * Bean Validation 예외 처리 (@Valid 검증 실패)
     * 
     * @param ex MethodArgumentNotValidException
     * @return 에러 응답
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<AxResponse<Void>> handleValidationException(MethodArgumentNotValidException ex) {
        log.warn("Method argument validation failed: {}", ex.getMessage());
        
        String errorMessage = ex.getBindingResult().getFieldErrors().stream()
                .map(FieldError::getDefaultMessage)
                .collect(Collectors.joining(", "));
        
        AxResponse<Void> response = AxResponse.failure(errorMessage, ErrorCode.INVALID_INPUT_VALUE.getCode());
        
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

    /**
     * Bean Validation 예외 처리 (Bind 오류)
     * 
     * @param ex BindException
     * @return 에러 응답
     */
    @ExceptionHandler(BindException.class)
    public ResponseEntity<AxResponse<Void>> handleBindException(BindException ex) {
        log.warn("Bind exception occurred: {}", ex.getMessage());
        
        String errorMessage = ex.getBindingResult().getFieldErrors().stream()
                .map(FieldError::getDefaultMessage)
                .collect(Collectors.joining(", "));
        
        AxResponse<Void> response = AxResponse.failure(errorMessage, ErrorCode.INVALID_INPUT_VALUE.getCode());
        
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

    /**
     * Constraint Validation 예외 처리
     * 
     * @param ex ConstraintViolationException
     * @return 에러 응답
     */
    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<AxResponse<Void>> handleConstraintViolationException(ConstraintViolationException ex) {
        log.warn("Constraint violation occurred: {}", ex.getMessage());
        
        String errorMessage = ex.getConstraintViolations().stream()
                .map(ConstraintViolation::getMessage)
                .collect(Collectors.joining(", "));
        
        AxResponse<Void> response = AxResponse.failure(errorMessage, ErrorCode.CONSTRAINT_VIOLATION.getCode());
        
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

    /**
     * 메서드 인자 타입 불일치 예외 처리
     * 
     * @param ex MethodArgumentTypeMismatchException
     * @return 에러 응답
     */
    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<AxResponse<Void>> handleTypeMismatchException(MethodArgumentTypeMismatchException ex) {
        log.warn("Type mismatch exception occurred: {}", ex.getMessage());
        
        String errorMessage = String.format("잘못된 파라미터 타입입니다: %s", ex.getName());
        AxResponse<Void> response = AxResponse.failure(errorMessage, ErrorCode.INVALID_TYPE_VALUE.getCode());
        
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

    /**
     * 필수 요청 파라미터 누락 예외 처리
     * 
     * @param ex MissingServletRequestParameterException
     * @return 에러 응답
     */
    @ExceptionHandler(MissingServletRequestParameterException.class)
    public ResponseEntity<AxResponse<Void>> handleMissingParameterException(MissingServletRequestParameterException ex) {
        log.warn("Missing request parameter: {}", ex.getMessage());
        
        String errorMessage = String.format("필수 파라미터가 누락되었습니다: %s", ex.getParameterName());
        AxResponse<Void> response = AxResponse.failure(errorMessage, ErrorCode.MISSING_REQUEST_PARAMETER.getCode());
        
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

    /**
     * HTTP 메서드 지원하지 않음 예외 처리
     * 
     * @param ex HttpRequestMethodNotSupportedException
     * @return 에러 응답
     */
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ResponseEntity<AxResponse<Void>> handleMethodNotSupportedException(HttpRequestMethodNotSupportedException ex) {
        log.warn("Method not supported: {}", ex.getMessage());
        
        AxResponse<Void> response = AxResponse.failure(
                ErrorCode.METHOD_NOT_ALLOWED.getMessage(), 
                ErrorCode.METHOD_NOT_ALLOWED.getCode()
        );
        
        return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED).body(response);
    }

    /**
     * JSON 파싱 오류 예외 처리
     * 
     * @param ex HttpMessageNotReadableException
     * @return 에러 응답
     */
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<AxResponse<Void>> handleMessageNotReadableException(HttpMessageNotReadableException ex) {
        log.warn("JSON parsing error: {}", ex.getMessage());
        
        AxResponse<Void> response = AxResponse.failure(
                ErrorCode.INVALID_JSON_FORMAT.getMessage(), 
                ErrorCode.INVALID_JSON_FORMAT.getCode()
        );
        
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

    /**
     * 기타 모든 예외 처리
     * 
     * @param ex Exception
     * @return 에러 응답
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<AxResponse<Void>> handleGeneralException(Exception ex) {
        log.error("Unexpected error occurred: {}", ex.getMessage(), ex);
        
        AxResponse<Void> response = AxResponse.failure(
                ErrorCode.INTERNAL_SERVER_ERROR.getMessage(), 
                ErrorCode.INTERNAL_SERVER_ERROR.getCode()
        );
        
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
    }
}
