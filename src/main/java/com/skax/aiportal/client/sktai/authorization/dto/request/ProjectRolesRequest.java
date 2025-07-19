package com.skax.aiportal.client.sktai.authorization.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.skax.aiportal.client.sktai.authorization.dto.ProjectPayload;
import com.skax.aiportal.client.sktai.authorization.dto.response.RoleResponse;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * SKT AI 프로젝트 역할 요청 DTO
 * 
 * @author ByounggwanLee
 * @since 2025-07-19
 * @version 1.0
 */
@Schema(description = "프로젝트 역할 요청")
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProjectRolesRequest {

    @Schema(description = "프로젝트 정보")
    @JsonProperty("project")
    private ProjectPayload project;

    @Schema(description = "역할 정보")
    @JsonProperty("role")
    private RoleResponse role;
}
