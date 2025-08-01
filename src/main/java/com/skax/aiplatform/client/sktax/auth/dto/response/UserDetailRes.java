package com.skax.aiplatform.client.sktax.auth.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 사용자 상세 정보 응답 DTO
 * 
 * <p>OpenAPI 스키마명: UserDetailResponse</p>
 * 
 * @author ByounggwanLee
 * @since 2025-08-01
 * @version 1.0
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "사용자 상세 정보 응답")
public class UserDetailRes {

    @JsonProperty("user_id")
    @Schema(description = "사용자 ID")
    private Long userId;

    @JsonProperty("username")
    @Schema(description = "사용자명")
    private String username;

    @JsonProperty("email")
    @Schema(description = "이메일")
    private String email;

    @JsonProperty("first_name")
    @Schema(description = "이름")
    private String firstName;

    @JsonProperty("last_name")
    @Schema(description = "성")
    private String lastName;

    @JsonProperty("phone")
    @Schema(description = "전화번호")
    private String phone;

    @JsonProperty("is_active")
    @Schema(description = "활성 상태")
    private Boolean isActive;

    @JsonProperty("last_login")
    @Schema(description = "마지막 로그인 일시")
    private String lastLogin;

    @JsonProperty("login_count")
    @Schema(description = "로그인 횟수")
    private Integer loginCount;

    @JsonProperty("groups")
    @Schema(description = "그룹 목록")
    private java.util.List<com.skax.aiplatform.client.sktax.auth.dto.GroupBase> groups;

    @JsonProperty("roles")
    @Schema(description = "역할 목록")
    private java.util.List<com.skax.aiplatform.client.sktax.auth.dto.RoleBase> roles;

    @JsonProperty("permissions")
    @Schema(description = "권한 목록")
    private java.util.List<com.skax.aiplatform.client.sktax.auth.dto.PermissionBase> permissions;

    @JsonProperty("projects")
    @Schema(description = "프로젝트 목록")
    private java.util.List<com.skax.aiplatform.client.sktax.auth.dto.ProjectPayload> projects;

    @JsonProperty("created_at")
    @Schema(description = "생성 일시")
    private String createdAt;

    @JsonProperty("updated_at")
    @Schema(description = "수정 일시")
    private String updatedAt;
}
