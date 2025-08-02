package com.skax.aiplatform.client.sktax.agent.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * SKTAX Agent Edge Marker DTO
 * 
 * <p>OpenAPI 스키마명: EdgeMarker</p>
 * <p>에지의 마커 정보를 정의합니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-08-02
 * @version 1.0
 */
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Schema(description = "에지 마커")
public class EdgeMarker {

    @JsonProperty("type")
    @Schema(description = "마커 타입", required = true)
    private MarkerType type;

    @JsonProperty("color")
    @Schema(description = "마커 색상")
    private String color;

    @JsonProperty("width")
    @Schema(description = "마커 너비")
    private Integer width;

    @JsonProperty("height")
    @Schema(description = "마커 높이")
    private Integer height;

    @JsonProperty("marker_units")
    @Schema(description = "마커 단위")
    private String markerUnits;

    @JsonProperty("orient")
    @Schema(description = "마커 방향")
    private String orient;

    @JsonProperty("stroke_width")
    @Schema(description = "스트로크 너비")
    private Integer strokeWidth;
}
