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
 * <p>OpenAPI 스키마명: ProjectRoleMappingsRead</p>
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
public class ProjectRoleMappingsReadRes {

    @JsonProperty("mapping_id")
    @Schema(description = "매핑 ID")
    private Long mappingId;

    @JsonProperty("project_id")
    @Schema(description = "프로젝트 ID")
    private Long projectId;

    @JsonProperty("role_id")
    @Schema(description = "역할 ID")
    private Long roleId;

    @JsonProperty("role_name")
    @Schema(description = "역할명")
    private String roleName;

    @JsonProperty("user_id")
    @Schema(description = "사용자 ID")
    private Long userId;

    @JsonProperty("username")
    @Schema(description = "사용자명")
    private String username;

    @JsonProperty("permissions")
    @Schema(description = "권한 목록")
    private java.util.List<String> permissions;

    @JsonProperty("is_active")
    @Schema(description = "활성 상태")
    private Boolean isActive;

    @JsonProperty("assigned_at")
    @Schema(description = "할당 일시")
    private String assignedAt;
}
