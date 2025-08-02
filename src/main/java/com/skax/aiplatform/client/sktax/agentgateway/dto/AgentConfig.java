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
 * Agent 설정 정보
 * 
 * <p>Agent 실행을 위한 설정 정보를 정의합니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-08-02
 * @version 1.0
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Agent 설정 정보")
public class AgentConfig {

    /**
     * 설정 가능한 속성들
     */
    @JsonProperty("configurable")
    @Schema(description = "설정 가능한 속성들", example = "{}")
    private Map<String, Object> configurable;

    /**
     * 메타데이터
     */
    @JsonProperty("metadata")
    @Schema(description = "메타데이터", example = "{}")
    private Map<String, Object> metadata;

    /**
     * 재귀 제한
     */
    @JsonProperty("recursion_limit")
    @Schema(description = "재귀 제한", example = "25")
    private Integer recursionLimit;

    /**
     * 태그 목록
     */
    @JsonProperty("tags")
    @Schema(description = "태그 목록", example = "[]")
    private List<String> tags;
}
