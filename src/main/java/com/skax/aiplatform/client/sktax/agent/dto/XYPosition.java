package com.skax.aiplatform.client.sktax.agent.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * SKTAX Agent XY Position DTO
 * 
 * <p>OpenAPI 스키마명: XYPosition</p>
 * <p>X, Y 좌표 위치를 나타냅니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-08-02
 * @version 1.0
 */
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Schema(description = "X, Y 좌표 위치")
public class XYPosition {

    @JsonProperty("x")
    @Schema(description = "X 좌표", required = true)
    private Integer x;

    @JsonProperty("y")
    @Schema(description = "Y 좌표", required = true)
    private Integer y;
}
