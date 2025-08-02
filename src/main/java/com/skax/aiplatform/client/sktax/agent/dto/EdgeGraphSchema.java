package com.skax.aiplatform.client.sktax.agent.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * SKTAX Agent Edge Graph Schema DTO
 * 
 * <p>OpenAPI 스키마명: EdgeGraphSchema</p>
 * <p>Agent Graph의 에지 스키마를 정의합니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-08-02
 * @version 1.0
 */
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Schema(description = "에지 그래프 스키마")
public class EdgeGraphSchema {

    @JsonProperty("id")
    @Schema(description = "에지 ID", required = true)
    private String id;

    @JsonProperty("type")
    @Schema(description = "에지 타입")
    private String type;

    @JsonProperty("source")
    @Schema(description = "소스 노드 ID")
    private String source;

    @JsonProperty("target")
    @Schema(description = "타겟 노드 ID")
    private String target;

    @JsonProperty("source_handle")
    @Schema(description = "소스 핸들")
    private String sourceHandle;

    @JsonProperty("target_handle")
    @Schema(description = "타겟 핸들")
    private String targetHandle;

    @JsonProperty("marker_start")
    @Schema(description = "시작 마커")
    private EdgeMarker markerStart;

    @JsonProperty("marker_end")
    @Schema(description = "종료 마커")
    private EdgeMarker markerEnd;

    @JsonProperty("reconnectable")
    @Schema(description = "재연결 가능 여부")
    private String reconnectable;

    @JsonProperty("condition_label")
    @Schema(description = "조건 라벨", example = "type이 case일때 edge의 label로 보여질 값")
    private String conditionLabel;
}
