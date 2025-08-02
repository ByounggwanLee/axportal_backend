package com.skax.aiplatform.client.sktax.agent.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

/**
 * SKTAX Agent Runnable Config DTO
 * 
 * <p>Agent 실행 설정 정보를 정의합니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-08-02
 * @version 1.0
 */
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Schema(description = "실행 설정")
public class RunnableConfig {

    /**
     * 태그 목록
     */
    @JsonProperty("tags")
    @Schema(description = "태그 목록")
    private List<String> tags;

    /**
     * 메타데이터
     */
    @JsonProperty("metadata")
    @Schema(description = "메타데이터")
    private Map<String, Object> metadata;

    /**
     * 콜백 설정
     */
    @JsonProperty("callbacks")
    @Schema(description = "콜백 설정")
    private Object callbacks;

    /**
     * 실행 이름
     */
    @JsonProperty("run_name")
    @Schema(description = "실행 이름", example = "agent-execution")
    private String runName;

    /**
     * 최대 동시 실행 수
     */
    @JsonProperty("max_concurrency")
    @Schema(description = "최대 동시 실행 수", example = "10")
    private Integer maxConcurrency;

    /**
     * 재귀 제한
     */
    @JsonProperty("recursion_limit")
    @Schema(description = "재귀 제한", example = "100")
    private Integer recursionLimit;

    /**
     * 설정 가능한 값들
     */
    @JsonProperty("configurable")
    @Schema(description = "설정 가능한 값들", defaultValue = "{}")
    @Builder.Default
    private Map<String, Object> configurable = Map.of();

    /**
     * 실행 ID
     */
    @JsonProperty("run_id")
    @Schema(description = "실행 ID", example = "f295a545-9ab7-4ca5-a6bc-3cf347994f1")
    private String runId;
}
