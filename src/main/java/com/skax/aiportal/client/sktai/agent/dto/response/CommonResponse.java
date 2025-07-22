package com.skax.aiportal.client.sktai.agent.dto.response;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * SKT AI Agent API 공통 응답 DTO
 *
 * <p>SKT AI Agent API의 표준 응답 형식입니다.</p>
 *
 * @author ByounggwanLee
 * @since 2025-07-22
 * @version 1.0
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CommonResponse {

    /**
     * 응답 타임스탬프
     */
    private LocalDateTime timestamp;

    /**
     * 응답 코드
     */
    private Integer code;

    /**
     * 응답 상세 메시지
     */
    private String detail;

    /**
     * 추적 ID
     */
    @JsonProperty("traceId")
    private String traceId;

    /**
     * 응답 데이터
     */
    private Object data;

    /**
     * 페이징 정보
     */
    private Object payload;
}
