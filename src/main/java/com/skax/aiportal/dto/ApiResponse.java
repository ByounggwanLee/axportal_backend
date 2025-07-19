package com.skax.aiportal.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * API 응답 공통 클래스
 * 
 * <p>모든 API 응답에 대한 공통 형식을 정의합니다.</p>
 * 
 * @param <T> 응답 데이터 타입
 * @author ByounggwanLee
 * @since 2025-07-19
 * @version 1.0
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ApiResponse<T> {
    
    /**
     * 성공 여부
     */
    private boolean success;
    
    /**
     * 응답 메시지
     */
    private String message;
    
    /**
     * 응답 데이터
     */
    private T data;
    
    /**
     * 응답 시간
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime timestamp;

    /**
     * 성공 응답을 생성합니다.
     * 
     * @param data 응답 데이터
     * @param <T> 데이터 타입
     * @return 성공 응답
     */
    public static <T> ApiResponse<T> success(T data) {
        return ApiResponse.<T>builder()
                .success(true)
                .message("성공")
                .data(data)
                .timestamp(LocalDateTime.now())
                .build();
    }

    /**
     * 성공 응답을 생성합니다. (메시지 포함)
     * 
     * @param data 응답 데이터
     * @param message 성공 메시지
     * @param <T> 데이터 타입
     * @return 성공 응답
     */
    public static <T> ApiResponse<T> success(T data, String message) {
        return ApiResponse.<T>builder()
                .success(true)
                .message(message)
                .data(data)
                .timestamp(LocalDateTime.now())
                .build();
    }

    /**
     * 성공 응답을 생성합니다. (데이터 없음)
     * 
     * @param message 성공 메시지
     * @return 성공 응답
     */
    public static ApiResponse<Void> success(String message) {
        return ApiResponse.<Void>builder()
                .success(true)
                .message(message)
                .timestamp(LocalDateTime.now())
                .build();
    }

    /**
     * 실패 응답을 생성합니다.
     * 
     * @param message 실패 메시지
     * @return 실패 응답
     */
    public static ApiResponse<Void> failure(String message) {
        return ApiResponse.<Void>builder()
                .success(false)
                .message(message)
                .timestamp(LocalDateTime.now())
                .build();
    }
}
