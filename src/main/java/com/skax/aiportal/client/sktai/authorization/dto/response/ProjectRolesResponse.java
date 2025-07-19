package com.skax.aiportal.client.sktai.authorization.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.skax.aiportal.client.sktai.authorization.dto.ProjectPayload;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 프로젝트 역할 응답 DTO
 */
@Schema(description = "프로젝트 역할 정보")
@Getter 
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProjectRolesResponse {

    @Schema(description = "프로젝트 정보")
    @JsonProperty("project")
    private ProjectPayload project;

    @Schema(description = "역할 정보")
    @JsonProperty("role")
    private RoleResponse role;
}
