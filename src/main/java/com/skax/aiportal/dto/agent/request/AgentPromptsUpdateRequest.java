package com.skax.aiportal.dto.agent.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Agent Prompts 수정 요청 DTO
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AgentPromptsUpdateRequest {

    private String name;
    private String description;
    private String promptContent;
    private String promptType;
    private String tags;
    private String versionDescription;
    private Boolean isPublic;
    private Boolean isActive;
}
