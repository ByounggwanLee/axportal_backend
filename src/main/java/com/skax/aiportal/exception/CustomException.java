package com.skax.aiportal.exception;

import lombok.Getter;

/**
 * 기본 예외 (커스텀 예외 최상위)
 *
 * <p>비즈니스/검증/시스템 예외의 공통 부모입니다.</p>
 *
 * @author ByounggwanLee
 * @since 2025-07-19
 */
@Getter
public class CustomException extends RuntimeException {
    private final ErrorCode errorCode;

    public CustomException(ErrorCode errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }

    public CustomException(ErrorCode errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
    }
}
