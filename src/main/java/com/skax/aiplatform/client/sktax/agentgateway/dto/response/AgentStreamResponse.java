package com.skax.aiplatform.client.sktax.agentgateway.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.skax.aiplatform.client.sktax.agentgateway.dto.AgentStreamData;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Agent Gateway Stream 응답 항목
 * 
 * <p>Agent 스트리밍 처리 결과 항목을 담는 응답 객체입니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-08-02
 * @version 1.0
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Agent Gateway Stream 응답 항목")
public class AgentStreamResponse {

    /**
     * 스트림 데이터
     */
    @JsonProperty("data")
    @Schema(description = "스트림 데이터")
    private AgentStreamData data;

    /**
     * 이벤트 타입
     */
    @JsonProperty("event")
    @Schema(description = "이벤트 타입", example = "data")
    private String event;

    /**
     * 실행 ID
     */
    @JsonProperty("id")
    @Schema(description = "실행 ID", example = "run-cc905abc-578e-4497-9154-6324803511d1")
    private String id;
}
