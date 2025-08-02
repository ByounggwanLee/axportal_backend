package com.skax.aiplatform.client.sktax.auth.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 프로젝트 역할 매핑 조회 응답 DTO
 * 
 * <p>OpenAPI 스키마명: ProjectRoleMappingsReadResponse</p>
 * 
 * @author ByounggwanLee
 * @since 2025-08-01
 * @version 1.0
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "프로젝트 역할 매핑 조회 응답")
public class ProjectRoleMappingsReadResponse {

    @JsonProperty("mapping_id")
    @Schema(description = "매핑 ID", required = true)
    private String mappingId;

    @JsonProperty("project_id")
    @Schema(description = "프로젝트 ID", required = true)
    private String projectId;

    @JsonProperty("project_name")
    @Schema(description = "프로젝트명", required = true)
    private String projectName;

    @JsonProperty("role_id")
    @Schema(description = "역할 ID", required = true)
    private String roleId;

    @JsonProperty("role_name")
    @Schema(description = "역할명", required = true)
    private String roleName;

    @JsonProperty("user_id")
    @Schema(description = "사용자 ID")
    private String userId;

    @JsonProperty("username")
    @Schema(description = "사용자명")
    private String username;

    @JsonProperty("is_active")
    @Schema(description = "활성 상태", required = true)
    private Boolean isActive;

    @JsonProperty("created_at")
    @Schema(description = "생성 일시", required = true)
    private String createdAt;

    @JsonProperty("updated_at")
    @Schema(description = "수정 일시")
    private String updatedAt;
}
