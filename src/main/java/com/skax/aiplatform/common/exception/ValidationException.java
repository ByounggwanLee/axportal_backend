package com.skax.aiplatform.common.exception;

/**
 * 데이터 검증 관련 예외 클래스
 * 
 * <p>입력값 검증 실패나 데이터 유효성 검사 오류 시 발생하는 예외입니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-08-01
 * @version 1.0.0
 */
public class ValidationException extends CustomException {

    /**
     * ErrorCode를 받는 생성자
     * 
     * @param errorCode 에러 코드
     */
    public ValidationException(ErrorCode errorCode) {
        super(errorCode);
    }

    /**
     * ErrorCode와 추가 메시지를 받는 생성자
     * 
     * @param errorCode 에러 코드
     * @param message 추가 메시지
     */
    public ValidationException(ErrorCode errorCode, String message) {
        super(errorCode, message);
    }

    /**
     * ErrorCode와 원인 예외를 받는 생성자
     * 
     * @param errorCode 에러 코드
     * @param cause 원인 예외
     */
    public ValidationException(ErrorCode errorCode, Throwable cause) {
        super(errorCode, cause);
    }

    /**
     * ErrorCode, 추가 메시지, 원인 예외를 받는 생성자
     * 
     * @param errorCode 에러 코드
     * @param message 추가 메시지
     * @param cause 원인 예외
     */
    public ValidationException(ErrorCode errorCode, String message, Throwable cause) {
        super(errorCode, message, cause);
    }
}
