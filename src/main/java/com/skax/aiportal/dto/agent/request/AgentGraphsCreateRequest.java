package com.skax.aiportal.dto.agent.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Agent Graphs 생성 요청 DTO
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AgentGraphsCreateRequest {

    @NotBlank(message = "프로젝트 ID는 필수입니다")
    private String projectId;

    @NotBlank(message = "Graph 이름은 필수입니다")
    private String name;

    private String description;
    private String graphData;
    private String tags;
    private String versionDescription;
    
    @Builder.Default
    private Boolean isPublic = false;
    
    @Builder.Default
    private Boolean isActive = true;
}
