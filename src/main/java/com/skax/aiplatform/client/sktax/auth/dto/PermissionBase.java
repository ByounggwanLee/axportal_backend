package com.skax.aiplatform.client.sktax.auth.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 권한 기본 정보 DTO
 * 
 * <p>OpenAPI 스키마명: PermissionBase</p>
 * 
 * @author ByounggwanLee
 * @since 2025-08-01
 * @version 1.0
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "권한 기본 정보")
public class PermissionBase {

    @JsonProperty("permission_id")
    @Schema(description = "권한 ID")
    private Long permissionId;

    @JsonProperty("permission_name")
    @Schema(description = "권한명")
    private String permissionName;

    @JsonProperty("permission_code")
    @Schema(description = "권한 코드")
    private String permissionCode;

    @JsonProperty("permission_description")
    @Schema(description = "권한 설명")
    private String permissionDescription;

    @JsonProperty("resource")
    @Schema(description = "리소스")
    private String resource;

    @JsonProperty("action")
    @Schema(description = "액션")
    private String action;

    @JsonProperty("is_active")
    @Schema(description = "활성 상태")
    private Boolean isActive;

    @JsonProperty("created_at")
    @Schema(description = "생성 일시")
    private String createdAt;
}
