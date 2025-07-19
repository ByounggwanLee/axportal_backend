package com.skax.aiportal.exception;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

/**
 * 전역 예외 처리 클래스
 * 
 * <p>애플리케이션에서 발생하는 모든 예외를 처리하고
 * 일관된 형태의 에러 응답을 반환합니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-07-19
 * @version 1.0
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * BusinessException 처리
     * 
     * @param e BusinessException
     * @param request HttpServletRequest
     * @return ErrorResponse
     */
    @ExceptionHandler(BusinessException.class)
    protected ResponseEntity<ErrorResponse> handleBusinessException(BusinessException e, HttpServletRequest request) {
        log.error("BusinessException", e);
        final ErrorResponse response = ErrorResponse.of(e.getErrorCode(), request.getRequestURI());
        return new ResponseEntity<>(response, e.getErrorCode().getStatus());
    }

    /**
     * MethodArgumentNotValidException 처리 (@Valid 검증 실패)
     * 
     * @param e MethodArgumentNotValidException
     * @param request HttpServletRequest
     * @return ErrorResponse
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    protected ResponseEntity<ErrorResponse> handleMethodArgumentNotValidException(
            MethodArgumentNotValidException e, HttpServletRequest request) {
        log.error("MethodArgumentNotValidException", e);
        final ErrorResponse response = ErrorResponse.of(ErrorCode.INVALID_INPUT_VALUE, request.getRequestURI(), e.getBindingResult());
        return new ResponseEntity<>(response, ErrorCode.INVALID_INPUT_VALUE.getStatus());
    }

    /**
     * BindException 처리 (@ModelAttribute 검증 실패)
     * 
     * @param e BindException
     * @param request HttpServletRequest
     * @return ErrorResponse
     */
    @ExceptionHandler(BindException.class)
    protected ResponseEntity<ErrorResponse> handleBindException(BindException e, HttpServletRequest request) {
        log.error("BindException", e);
        final ErrorResponse response = ErrorResponse.of(ErrorCode.INVALID_INPUT_VALUE, request.getRequestURI(), e.getBindingResult());
        return new ResponseEntity<>(response, ErrorCode.INVALID_INPUT_VALUE.getStatus());
    }

    /**
     * MethodArgumentTypeMismatchException 처리 (타입 변환 실패)
     * 
     * @param e MethodArgumentTypeMismatchException
     * @param request HttpServletRequest
     * @return ErrorResponse
     */
    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    protected ResponseEntity<ErrorResponse> handleMethodArgumentTypeMismatchException(
            MethodArgumentTypeMismatchException e, HttpServletRequest request) {
        log.error("MethodArgumentTypeMismatchException", e);
        final ErrorResponse response = ErrorResponse.of(ErrorCode.INVALID_TYPE_VALUE, request.getRequestURI());
        return new ResponseEntity<>(response, ErrorCode.INVALID_TYPE_VALUE.getStatus());
    }

    /**
     * HttpRequestMethodNotSupportedException 처리 (지원하지 않는 HTTP 메서드)
     * 
     * @param e HttpRequestMethodNotSupportedException
     * @param request HttpServletRequest
     * @return ErrorResponse
     */
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    protected ResponseEntity<ErrorResponse> handleHttpRequestMethodNotSupportedException(
            HttpRequestMethodNotSupportedException e, HttpServletRequest request) {
        log.error("HttpRequestMethodNotSupportedException", e);
        final ErrorResponse response = ErrorResponse.of(ErrorCode.METHOD_NOT_ALLOWED, request.getRequestURI());
        return new ResponseEntity<>(response, ErrorCode.METHOD_NOT_ALLOWED.getStatus());
    }

    /**
     * HttpMessageNotReadableException 처리 (요청 본문 읽기 실패)
     * 
     * @param e HttpMessageNotReadableException
     * @param request HttpServletRequest
     * @return ErrorResponse
     */
    @ExceptionHandler(HttpMessageNotReadableException.class)
    protected ResponseEntity<ErrorResponse> handleHttpMessageNotReadableException(
            HttpMessageNotReadableException e, HttpServletRequest request) {
        log.error("HttpMessageNotReadableException", e);
        final ErrorResponse response = ErrorResponse.of(ErrorCode.INVALID_INPUT_VALUE, request.getRequestURI());
        return new ResponseEntity<>(response, ErrorCode.INVALID_INPUT_VALUE.getStatus());
    }

    /**
     * Exception 처리 (기타 모든 예외)
     * 
     * @param e Exception
     * @param request HttpServletRequest
     * @return ErrorResponse
     */
    @ExceptionHandler(Exception.class)
    protected ResponseEntity<ErrorResponse> handleException(Exception e, HttpServletRequest request) {
        log.error("Exception", e);
        final ErrorResponse response = ErrorResponse.of(ErrorCode.INTERNAL_SERVER_ERROR, request.getRequestURI());
        return new ResponseEntity<>(response, ErrorCode.INTERNAL_SERVER_ERROR.getStatus());
    }
}
