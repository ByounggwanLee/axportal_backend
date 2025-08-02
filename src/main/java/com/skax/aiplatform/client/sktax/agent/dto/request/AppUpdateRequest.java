package com.skax.aiplatform.client.sktax.agent.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * SKTAX Agent App 수정 요청 DTO
 * 
 * <p>Agent App 수정 요청 데이터를 정의합니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-08-02
 * @version 1.0
 */
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Schema(description = "Agent App 수정 요청")
public class AppUpdateRequest {

    /**
     * App 이름
     */
    @Schema(description = "App 이름", example = "simple_rag_agent")
    @JsonProperty("name")
    private String name;

    /**
     * App 설명
     */
    @Schema(description = "App 설명", example = "agent_graph_service_deploy")
    @JsonProperty("description")
    private String description;
}
