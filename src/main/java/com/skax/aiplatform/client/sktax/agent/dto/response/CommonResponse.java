package com.skax.aiplatform.client.sktax.agent.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * SKTAX Agent API 공통 응답 DTO
 * 
 * <p>SKTAX Agent API의 표준 응답 형식을 정의합니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-08-02
 * @version 1.0
 */
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Schema(description = "Agent API 공통 응답")
public class CommonResponse {

    /**
     * 응답 타임스탬프 (ISO 8601 format)
     */
    @Schema(description = "응답 타임스탬프", example = "2025-08-02T10:30:00Z")
    @JsonProperty("timestamp")
    private String timestamp;

    /**
     * 응답 코드
     */
    @Schema(description = "응답 코드", example = "200")
    @JsonProperty("code")
    private Integer code;

    /**
     * 응답 상세 메시지
     */
    @Schema(description = "응답 상세 메시지", example = "Success")
    @JsonProperty("detail")
    private String detail;

    /**
     * 추적 ID
     */
    @Schema(description = "추적 ID", example = "uuid-trace-id")
    @JsonProperty("traceId")
    private String traceId;

    /**
     * 응답 데이터
     */
    @Schema(description = "응답 데이터")
    @JsonProperty("data")
    private Object data;

    /**
     * 페이로드 정보
     */
    @Schema(description = "페이로드 정보")
    @JsonProperty("payload")
    private Object payload;
}
