package com.skax.aiportal.dto.agent.response;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Agent API 공통 응답 DTO
 * 
 * <p>Agent API 호출 시 반환되는 공통 응답 형식입니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-07-22
 * @version 1.0
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AgentApiResponse<T> {

    /**
     * 성공 여부
     */
    private boolean success;

    /**
     * 응답 코드
     */
    private Integer code;

    /**
     * 응답 메시지
     */
    private String message;

    /**
     * 응답 상세 메시지
     */
    private String detail;

    /**
     * 추적 ID
     */
    private String traceId;

    /**
     * 응답 데이터
     */
    private T data;

    /**
     * 응답 타임스탬프
     */
    private LocalDateTime timestamp;

    /**
     * 메타데이터
     */
    private Object metadata;

    /**
     * 성공 응답 생성
     */
    public static <T> AgentApiResponse<T> success(T data) {
        return AgentApiResponse.<T>builder()
                .success(true)
                .code(200)
                .message("성공")
                .data(data)
                .timestamp(LocalDateTime.now())
                .build();
    }

    /**
     * 성공 응답 생성 (메시지 포함)
     */
    public static <T> AgentApiResponse<T> success(T data, String message) {
        return AgentApiResponse.<T>builder()
                .success(true)
                .code(200)
                .message(message)
                .data(data)
                .timestamp(LocalDateTime.now())
                .build();
    }

    /**
     * 실패 응답 생성
     */
    public static <T> AgentApiResponse<T> error(Integer code, String message) {
        return AgentApiResponse.<T>builder()
                .success(false)
                .code(code)
                .message(message)
                .timestamp(LocalDateTime.now())
                .build();
    }

    /**
     * 실패 응답 생성 (상세 메시지 포함)
     */
    public static <T> AgentApiResponse<T> error(Integer code, String message, String detail) {
        return AgentApiResponse.<T>builder()
                .success(false)
                .code(code)
                .message(message)
                .detail(detail)
                .timestamp(LocalDateTime.now())
                .build();
    }
}
