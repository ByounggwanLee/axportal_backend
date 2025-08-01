package com.skax.aiplatform.client.sktax.auth.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 프로젝트 역할 DTO
 * 
 * <p>OpenAPI 스키마명: ProjectRoles</p>
 * 
 * @author ByounggwanLee
 * @since 2025-08-01
 * @version 1.0
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "프로젝트 역할")
public class ProjectRoles {

    @JsonProperty("project")
    @Schema(description = "프로젝트 정보", required = true)
    private ProjectPayload project;

    @JsonProperty("role")
    @Schema(description = "역할 정보", required = true)
    private RoleBase role;
}
