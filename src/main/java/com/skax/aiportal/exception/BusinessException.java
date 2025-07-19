package com.skax.aiportal.exception;

import lombok.Getter;

/**
 * 비즈니스 로직 예외 클래스
 * 
 * <p>애플리케이션의 비즈니스 로직에서 발생하는 예외를 처리합니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-07-19
 * @version 1.0
 */
@Getter
public class BusinessException extends RuntimeException {
    
    /**
     * 에러 코드
     */
    private final ErrorCode errorCode;

    /**
     * BusinessException 생성자
     * 
     * @param errorCode 에러 코드
     */
    public BusinessException(ErrorCode errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }

    /**
     * BusinessException 생성자 (커스텀 메시지)
     * 
     * @param errorCode 에러 코드
     * @param message 커스텀 메시지
     */
    public BusinessException(ErrorCode errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
    }

    /**
     * BusinessException 생성자 (원인 예외 포함)
     * 
     * @param errorCode 에러 코드
     * @param cause 원인 예외
     */
    public BusinessException(ErrorCode errorCode, Throwable cause) {
        super(errorCode.getMessage(), cause);
        this.errorCode = errorCode;
    }
}
