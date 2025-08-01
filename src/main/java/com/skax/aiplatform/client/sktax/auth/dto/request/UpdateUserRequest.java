package com.skax.aiplatform.client.sktax.auth.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 사용자 수정 요청 DTO
 * 
 * <p>OpenAPI 스키마명: UpdateUserRequest</p>
 * 
 * @author ByounggwanLee
 * @since 2025-08-01
 * @version 1.0
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "사용자 수정 요청")
public class UpdateUserRequest {

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

    @JsonProperty("groups")
    @Schema(description = "그룹 ID 목록")
    private java.util.List<Long> groups;

    @JsonProperty("roles")
    @Schema(description = "역할 ID 목록")
    private java.util.List<Long> roles;
}
