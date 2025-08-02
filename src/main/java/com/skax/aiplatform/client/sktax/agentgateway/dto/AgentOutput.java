package com.skax.aiplatform.client.sktax.agentgateway.dto;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Agent 출력 결과
 * 
 * <p>Agent 실행 결과를 담는 출력 객체입니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-08-02
 * @version 1.0
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Agent 출력 결과")
public class AgentOutput {

    /**
     * 추가 키워드 인수
     */
    @JsonProperty("additional_kwargs")
    @Schema(description = "추가 키워드 인수", example = "{}")
    private Map<String, Object> additionalKwargs;

    /**
     * 응답 내용
     */
    @JsonProperty("content")
    @Schema(description = "응답 내용", example = "Sure! Here's a bear joke for you:\\n\\nWhy did the bear wear a hat?\\n\\nBecause he didn't want anyone to think he was a bare bear!")
    private String content;

    /**
     * 응답 메타데이터
     */
    @JsonProperty("response_metadata")
    @Schema(description = "응답 메타데이터")
    private AgentResponseMetadata responseMetadata;

    /**
     * 메시지 타입
     */
    @JsonProperty("type")
    @Schema(description = "메시지 타입", example = "AIMessage")
    private String type;
}
