package com.skax.aiportal.dto.agent.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Agent Graphs 수정 요청 DTO
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AgentGraphsUpdateRequest {

    private String name;
    private String description;
    private String graphData;
    private String tags;
    private String versionDescription;
    private Boolean isPublic;
    private Boolean isActive;
}
