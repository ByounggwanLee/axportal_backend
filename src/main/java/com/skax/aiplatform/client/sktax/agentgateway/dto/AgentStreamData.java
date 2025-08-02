package com.skax.aiplatform.client.sktax.agentgateway.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

/**
 * Agent 스트림 데이터
 * 
 * <p>Agent 스트리밍 응답 데이터를 정의합니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-08-02
 * @version 1.0
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Agent 스트림 데이터")
public class AgentStreamData {

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
    @Schema(description = "응답 내용", example = "Here's a part of the response.")
    private String content;

    /**
     * 예제 여부
     */
    @JsonProperty("example")
    @Schema(description = "예제 여부", example = "false")
    private Boolean example;

    /**
     * 실행 ID
     */
    @JsonProperty("id")
    @Schema(description = "실행 ID", example = "run-cc905abc-578e-4497-9154-6324803511d1")
    private String id;

    /**
     * 유효하지 않은 도구 호출 목록
     */
    @JsonProperty("invalid_tool_calls")
    @Schema(description = "유효하지 않은 도구 호출 목록", example = "[]")
    private List<Object> invalidToolCalls;

    /**
     * 응답 메타데이터
     */
    @JsonProperty("response_metadata")
    @Schema(description = "응답 메타데이터")
    private AgentResponseMetadata responseMetadata;

    /**
     * 도구 호출 청크 목록
     */
    @JsonProperty("tool_call_chunks")
    @Schema(description = "도구 호출 청크 목록", example = "[]")
    private List<Object> toolCallChunks;

    /**
     * 도구 호출 목록
     */
    @JsonProperty("tool_calls")
    @Schema(description = "도구 호출 목록", example = "[]")
    private List<Object> toolCalls;

    /**
     * 메시지 타입
     */
    @JsonProperty("type")
    @Schema(description = "메시지 타입", example = "AIMessageChunk")
    private String type;
}
