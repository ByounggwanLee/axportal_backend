package com.skax.aiportal.dto.agent.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Agent Prompts 생성 요청 DTO
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AgentPromptsCreateRequest {

    @NotBlank(message = "프로젝트 ID는 필수입니다")
    private String projectId;

    @NotBlank(message = "Prompt 이름은 필수입니다")
    private String name;

    private String description;
    private String promptContent;
    private String promptType;
    private String tags;
    private String versionDescription;
    
    @Builder.Default
    private Boolean isPublic = false;
    
    @Builder.Default
    private Boolean isActive = true;
}
