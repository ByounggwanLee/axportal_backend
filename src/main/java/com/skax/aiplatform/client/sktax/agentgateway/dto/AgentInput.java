package com.skax.aiplatform.client.sktax.agentgateway.dto;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Agent 입력 데이터
 * 
 * <p>Agent 실행에 필요한 입력 정보를 정의합니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-08-02
 * @version 1.0
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Agent 입력 데이터")
public class AgentInput {

    /**
     * 추가 키워드 인수
     */
    @JsonProperty("additional_kwargs")
    @Schema(description = "추가 키워드 인수", example = "{\"additional1\": \"value\"}")
    private Map<String, Object> additionalKwargs;

    /**
     * 메시지 목록
     */
    @JsonProperty("messages")
    @Valid
    @Schema(description = "메시지 목록")
    private List<AgentMessage> messages;
}
