package com.skax.aiportal.exception;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 에러 응답 클래스
 * 
 * <p>API에서 발생하는 에러에 대한 응답 형식을 정의합니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-07-19
 * @version 1.0
 */
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ErrorResponse {
    
    /**
     * 에러 발생 시간
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private final LocalDateTime timestamp;
    
    /**
     * 에러 코드
     */
    private final String code;
    
    /**
     * 에러 메시지
     */
    private final String message;
    
    /**
     * HTTP 상태 코드
     */
    private final int status;
    
    /**
     * 요청 경로
     */
    private final String path;
    
    /**
     * 필드 에러 목록 (validation 에러 시)
     */
    private final List<FieldError> fieldErrors;

    @Builder
    private ErrorResponse(String code, String message, int status, String path, List<FieldError> fieldErrors) {
        this.timestamp = LocalDateTime.now();
        this.code = code;
        this.message = message;
        this.status = status;
        this.path = path;
        this.fieldErrors = fieldErrors;
    }

    /**
     * ErrorCode를 기반으로 ErrorResponse를 생성합니다.
     * 
     * @param errorCode 에러 코드
     * @param path 요청 경로
     * @return ErrorResponse
     */
    public static ErrorResponse of(ErrorCode errorCode, String path) {
        return ErrorResponse.builder()
                .code(errorCode.getCode())
                .message(errorCode.getMessage())
                .status(errorCode.getStatus().value())
                .path(path)
                .build();
    }

    /**
     * Validation 에러를 기반으로 ErrorResponse를 생성합니다.
     * 
     * @param errorCode 에러 코드
     * @param path 요청 경로
     * @param bindingResult validation 결과
     * @return ErrorResponse
     */
    public static ErrorResponse of(ErrorCode errorCode, String path, BindingResult bindingResult) {
        return ErrorResponse.builder()
                .code(errorCode.getCode())
                .message(errorCode.getMessage())
                .status(errorCode.getStatus().value())
                .path(path)
                .fieldErrors(createFieldErrors(bindingResult))
                .build();
    }

    /**
     * BindingResult에서 FieldError 목록을 생성합니다.
     * 
     * @param bindingResult validation 결과
     * @return FieldError 목록
     */
    private static List<FieldError> createFieldErrors(BindingResult bindingResult) {
        final List<org.springframework.validation.FieldError> fieldErrors = bindingResult.getFieldErrors();
        return fieldErrors.stream()
                .map(error -> new FieldError(
                        error.getField(),
                        error.getRejectedValue() == null ? "" : error.getRejectedValue().toString(),
                        error.getDefaultMessage()))
                .collect(Collectors.toList());
    }

    /**
     * 필드 에러 클래스
     */
    @Getter
    public static class FieldError {
        private final String field;
        private final String value;
        private final String reason;

        private FieldError(String field, String value, String reason) {
            this.field = field;
            this.value = value;
            this.reason = reason;
        }
    }
}
