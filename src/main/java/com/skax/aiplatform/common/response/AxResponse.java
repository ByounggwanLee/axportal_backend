package com.skax.aiplatform.common.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

/**
 * 표준화된 API 응답 래퍼 클래스
 * 
 * <p>모든 API 응답을 일관된 형식으로 제공하기 위한 래퍼 클래스입니다.
 * 성공/실패 여부, 메시지, 데이터, 타임스탬프를 포함합니다.</p>
 * 
 * @param <T> 응답 데이터 타입
 * @author ByounggwanLee
 * @since 2025-08-01
 * @version 1.0.0
 */
@Getter
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
@Schema(description = "API 응답 래퍼")
public class AxResponse<T> {

    @Schema(description = "성공 여부", example = "true")
    private final boolean success;

    @Schema(description = "응답 메시지", example = "조회 성공")
    private final String message;

    @Schema(description = "응답 데이터")
    private final T data;

    @Schema(description = "에러 코드", example = "C001")
    private final String errorCode;

    @Schema(description = "응답 시간", example = "2025-08-01T10:30:00")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private final LocalDateTime timestamp;

    /**
     * 성공 응답 생성 (데이터 포함)
     * 
     * @param data 응답 데이터
     * @param message 성공 메시지
     * @param <T> 데이터 타입
     * @return 성공 응답
     */
    public static <T> AxResponse<T> success(T data, String message) {
        return AxResponse.<T>builder()
                .success(true)
                .message(message)
                .data(data)
                .timestamp(LocalDateTime.now())
                .build();
    }

    /**
     * 성공 응답 생성 (데이터 포함, 기본 메시지)
     * 
     * @param data 응답 데이터
     * @param <T> 데이터 타입
     * @return 성공 응답
     */
    public static <T> AxResponse<T> success(T data) {
        return success(data, "성공");
    }

    /**
     * 성공 응답 생성 (데이터 없음)
     * 
     * @param message 성공 메시지
     * @return 성공 응답
     */
    public static AxResponse<Void> success(String message) {
        return AxResponse.<Void>builder()
                .success(true)
                .message(message)
                .timestamp(LocalDateTime.now())
                .build();
    }

    /**
     * 성공 응답 생성 (기본 메시지)
     * 
     * @return 성공 응답
     */
    public static AxResponse<Void> success() {
        return success("성공");
    }

    /**
     * 실패 응답 생성
     * 
     * @param message 실패 메시지
     * @param errorCode 에러 코드
     * @return 실패 응답
     */
    public static AxResponse<Void> failure(String message, String errorCode) {
        return AxResponse.<Void>builder()
                .success(false)
                .message(message)
                .errorCode(errorCode)
                .timestamp(LocalDateTime.now())
                .build();
    }

    /**
     * 실패 응답 생성 (기본 메시지)
     * 
     * @param errorCode 에러 코드
     * @return 실패 응답
     */
    public static AxResponse<Void> failure(String errorCode) {
        return failure("요청 처리 중 오류가 발생했습니다", errorCode);
    }
}
