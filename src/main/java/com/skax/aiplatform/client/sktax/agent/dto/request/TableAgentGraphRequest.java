package com.skax.aiplatform.client.sktax.agent.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.util.Map;

/**
 * Table Agent Graph 생성/수정 요청 DTO
 * 
 * @author ByounggwanLee
 * @since 2025-08-02
 * @version 1.0
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Table Agent Graph 생성/수정 요청")
public class TableAgentGraphRequest {

    @NotBlank(message = "그래프 이름은 필수입니다")
    @JsonProperty("name")
    @Schema(description = "그래프 이름", example = "research_flow")
    private String name;

    @JsonProperty("description")
    @Schema(description = "그래프 설명", example = "search from wikipedia and create answer")
    private String description;

    @JsonProperty("graph")
    @Schema(description = "그래프 스키마")
    private Map<String, Object> graph;
}
