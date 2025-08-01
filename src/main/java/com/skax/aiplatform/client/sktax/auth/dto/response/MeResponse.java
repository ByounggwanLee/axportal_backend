package com.skax.aiplatform.client.sktax.auth.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.skax.aiplatform.client.sktax.auth.dto.ProjectPayload;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 로그인된 사용자 정보 응답 DTO
 * 
 * <p>OpenAPI 스키마명: MeResponse</p>
 * 
 * @author ByounggwanLee
 * @since 2025-08-01
 * @version 1.0
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "로그인된 사용자 정보 응답")
public class MeResponse {

    @JsonProperty("id")
    @Schema(description = "사용자 ID", required = true)
    private String id;

    @JsonProperty("username")
    @Schema(description = "사용자명", required = true)
    private String username;

    @JsonProperty("email")
    @Schema(description = "이메일", required = true)
    private String email;

    @JsonProperty("first_name")
    @Schema(description = "이름", required = true)
    private String firstName;

    @JsonProperty("last_name")
    @Schema(description = "성", required = true)
    private String lastName;

    @JsonProperty("roles")
    @Schema(description = "역할 목록", required = true)
    private List<Object> roles;

    @JsonProperty("project")
    @Schema(description = "프로젝트 정보", required = true)
    private ProjectPayload project;

    @JsonProperty("groups")
    @Schema(description = "그룹 목록", required = true)
    private List<Object> groups;
}
