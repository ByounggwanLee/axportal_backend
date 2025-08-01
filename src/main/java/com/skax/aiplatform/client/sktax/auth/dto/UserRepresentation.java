package com.skax.aiplatform.client.sktax.auth.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 사용자 표현 DTO
 * 
 * <p>OpenAPI 스키마명: UserRepresentation</p>
 * 
 * @author ByounggwanLee
 * @since 2025-08-01
 * @version 1.0
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "사용자 표현")
public class UserRepresentation {

    @JsonProperty("id")
    @Schema(description = "사용자 ID", required = true)
    private String id;

    @JsonProperty("username")
    @Schema(description = "사용자명", required = true)
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

    @JsonProperty("roles")
    @Schema(description = "역할 목록")
    private List<Object> roles;

    @JsonProperty("groups")
    @Schema(description = "그룹 목록")
    private List<Object> groups;
}
