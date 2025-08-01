package com.skax.aiplatform.client.sktax.auth.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 프로젝트 역할 생성 DTO
 * 
 * <p>OpenAPI 스키마명: CreateProjectRole</p>
 * 
 * @author ByounggwanLee
 * @since 2025-08-01
 * @version 1.0
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "프로젝트 역할 생성")
public class CreateProjectRole {

    @JsonProperty("role_name")
    @Schema(description = "역할명", required = true)
    private String roleName;

    @JsonProperty("role_description")
    @Schema(description = "역할 설명")
    private String roleDescription;

    @JsonProperty("permissions")
    @Schema(description = "권한 목록")
    private java.util.List<String> permissions;

    @JsonProperty("is_active")
    @Schema(description = "활성 상태", defaultValue = "true")
    @Builder.Default
    private Boolean isActive = true;
}
