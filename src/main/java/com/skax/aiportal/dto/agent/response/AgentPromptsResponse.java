package com.skax.aiportal.dto.agent.response;

import java.time.LocalDateTime;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Agent Prompts 응답 DTO
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AgentPromptsResponse {

    private String uuid;
    private String projectId;
    private String name;
    private String description;
    private String promptContent;
    private String promptType;
    private List<String> tags;
    private String currentVersionId;
    private String versionDescription;
    private Boolean isPublic;
    private Boolean isActive;
    private String status;
    private String createdBy;
    private String updatedBy;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private Boolean isDeleted;
}
