package com.skax.aiplatform.client.sktax.agent.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * SKTAX Agent Graph Schema DTO
 * 
 * <p>Agent Graph의 스키마 정보를 정의합니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-08-02
 * @version 1.0
 */
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Schema(description = "그래프 스키마")
public class GraphSchema {

    /**
     * 노드 목록
     */
    @JsonProperty("nodes")
    @Builder.Default
    @Schema(description = "노드 목록")
    private List<NodeSchema> nodes = List.of();

    /**
     * 에지 목록
     */
    @JsonProperty("edges")
    @Builder.Default
    @Schema(description = "에지 목록")
    private List<EdgeGraphSchema> edges = List.of();
}
