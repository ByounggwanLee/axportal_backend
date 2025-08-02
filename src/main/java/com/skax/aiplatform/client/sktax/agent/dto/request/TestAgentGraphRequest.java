package com.skax.aiplatform.client.sktax.agent.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.skax.aiplatform.client.sktax.agent.dto.QueryBody;
import com.skax.aiplatform.client.sktax.agent.dto.RunnableConfig;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Map;

/**
 * Agent Graph 테스트 실행 요청 DTO
 * 
 * @author ByounggwanLee
 * @since 2025-08-02
 * @version 1.0
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Agent Graph 테스트 실행 요청")
public class TestAgentGraphRequest {

    @NotBlank(message = "그래프 ID는 필수입니다")
    @JsonProperty("graph_id")
    @Schema(description = "그래프 ID", example = "9deaa8f7-32af-47e7-aa58-d59bc8f047c3")
    private String graphId;

    @NotNull(message = "입력 데이터는 필수입니다")
    @Valid
    @JsonProperty("input_data")
    @Schema(description = "입력 데이터")
    private QueryBody inputData;

    @NotNull(message = "그래프 스키마는 필수입니다")
    @JsonProperty("graph")
    @Schema(description = "그래프 스키마")
    private Object graph;

    @NotBlank(message = "API 키는 필수입니다")
    @JsonProperty("api_key")
    @Schema(description = "API 키")
    private String apiKey;

    @JsonProperty("config")
    @Schema(description = "실행 설정")
    @Builder.Default
    private RunnableConfig config = RunnableConfig.builder()
            .runId("3f4137fc-9ba0-4516-a287-6f018c3cb618")
            .configurable(Map.of())
            .build();
}
