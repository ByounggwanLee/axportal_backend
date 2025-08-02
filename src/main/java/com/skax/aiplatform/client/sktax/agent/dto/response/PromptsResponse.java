package com.skax.aiplatform.client.sktax.agent.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.skax.aiplatform.client.sktax.agent.dto.PromptInfo;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

/**
 * SKTAX Agent Prompts 목록 응답 DTO
 * 
 * <p>Prompts 목록 조회 응답 데이터를 정의합니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-08-02
 * @version 1.0
 */
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Schema(description = "Prompt 목록 응답")
public class PromptsResponse {

    /**
     * 응답 타임스탬프
     */
    @Schema(description = "응답 타임스탬프")
    @JsonProperty("timestamp")
    private LocalDateTime timestamp;

    /**
     * 응답 코드
     */
    @Schema(description = "응답 코드")
    @JsonProperty("code")
    private Integer code;

    /**
     * 응답 상세 메시지
     */
    @Schema(description = "응답 상세 메시지")
    @JsonProperty("detail")
    private String detail;

    /**
     * 추적 ID
     */
    @Schema(description = "추적 ID")
    @JsonProperty("traceId")
    private String traceId;

    /**
     * Prompt 목록 데이터
     */
    @Schema(description = "Prompt 목록 데이터")
    @JsonProperty("data")
    private List<PromptInfo> data;

    /**
     * 페이로드 정보
     */
    @Schema(description = "페이로드 정보")
    @JsonProperty("payload")
    private Object payload;
}
