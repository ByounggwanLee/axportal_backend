package com.skax.aiplatform.client.sktax.agent.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.skax.aiplatform.client.sktax.agent.dto.QueryBody;
import com.skax.aiplatform.client.sktax.agent.dto.RunnableConfig;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Map;

/**
 * Agent Graph 실행 요청 DTO
 * 
 * @author ByounggwanLee
 * @since 2025-08-02
 * @version 1.0
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Agent Graph 실행 요청")
public class QueryAgentGraphRequest {

    @NotBlank(message = "그래프 ID는 필수입니다")
    @JsonProperty("graph_id")
    @Schema(description = "그래프 ID", example = "9deaa8f7-32af-47e7-aa58-d59bc8f047c3")
    private String graphId;

    @Valid
    @JsonProperty("input_data")
    @Schema(description = "입력 데이터")
    private QueryBody inputData;

    @JsonProperty("config")
    @Schema(description = "실행 설정")
    @Builder.Default
    private RunnableConfig config = RunnableConfig.builder()
            .runId("f295a545-9ab7-4ca5-a6bc-3cf347994f1")
            .configurable(Map.of())
            .build();
}
