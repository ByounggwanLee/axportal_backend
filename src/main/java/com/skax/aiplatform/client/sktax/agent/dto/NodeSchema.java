package com.skax.aiplatform.client.sktax.agent.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * SKTAX Agent Node Schema DTO
 * 
 * <p>OpenAPI 스키마명: NodeSchema</p>
 * <p>Agent Graph의 노드 스키마를 정의합니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-08-02
 * @version 1.0
 */
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Schema(description = "노드 스키마")
public class NodeSchema {

    @JsonProperty("id")
    @Schema(description = "노드 ID", required = true)
    private String id;

    @JsonProperty("type")
    @Schema(description = "노드 타입")
    private String type;

    @JsonProperty("position")
    @Schema(description = "노드 위치")
    private XYPosition position;

    @JsonProperty("source_position")
    @Schema(description = "소스 위치")
    private Position sourcePosition;

    @JsonProperty("target_position")
    @Schema(description = "타겟 위치")
    private Position targetPosition;

    @JsonProperty("style")
    @Schema(description = "스타일")
    private Object style;

    @JsonProperty("data")
    @Schema(description = "노드 데이터", required = true)
    private Object data;
}
