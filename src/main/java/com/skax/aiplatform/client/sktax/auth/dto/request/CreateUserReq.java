package com.skax.aiplatform.client.sktax.auth.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 사용자 생성 요청 DTO
 * 
 * <p>OpenAPI 스키마명: CreateUserRequest</p>
 * 
 * @author ByounggwanLee
 * @since 2025-08-01
 * @version 1.0
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "사용자 생성 요청")
public class CreateUserReq {

    @JsonProperty("username")
    @Schema(description = "사용자명", required = true)
    private String username;

    @JsonProperty("email")
    @Schema(description = "이메일", required = true)
    private String email;

    @JsonProperty("password")
    @Schema(description = "비밀번호", required = true)
    private String password;

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
    @Schema(description = "활성 상태", defaultValue = "true")
    @Builder.Default
    private Boolean isActive = true;

    @JsonProperty("groups")
    @Schema(description = "그룹 ID 목록")
    private java.util.List<Long> groups;

    @JsonProperty("roles")
    @Schema(description = "역할 ID 목록")
    private java.util.List<Long> roles;
}
