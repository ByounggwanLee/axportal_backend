package com.skax.aiplatform.common.exception;

import lombok.Getter;

/**
 * 애플리케이션 기본 예외 클래스
 * 
 * <p>모든 커스텀 예외의 기본 클래스입니다.
 * ErrorCode를 포함하여 표준화된 예외 처리를 제공합니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-08-01
 * @version 1.0.0
 */
@Getter
public class CustomException extends RuntimeException {

    private final ErrorCode errorCode;

    /**
     * ErrorCode를 받는 생성자
     * 
     * @param errorCode 에러 코드
     */
    public CustomException(ErrorCode errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }

    /**
     * ErrorCode와 추가 메시지를 받는 생성자
     * 
     * @param errorCode 에러 코드
     * @param message 추가 메시지
     */
    public CustomException(ErrorCode errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
    }

    /**
     * ErrorCode와 원인 예외를 받는 생성자
     * 
     * @param errorCode 에러 코드
     * @param cause 원인 예외
     */
    public CustomException(ErrorCode errorCode, Throwable cause) {
        super(errorCode.getMessage(), cause);
        this.errorCode = errorCode;
    }

    /**
     * ErrorCode, 추가 메시지, 원인 예외를 받는 생성자
     * 
     * @param errorCode 에러 코드
     * @param message 추가 메시지
     * @param cause 원인 예외
     */
    public CustomException(ErrorCode errorCode, String message, Throwable cause) {
        super(message, cause);
        this.errorCode = errorCode;
    }
}
