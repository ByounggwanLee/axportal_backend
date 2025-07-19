package com.skax.aiportal.client.sktai.authorization.dto.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.skax.aiportal.client.sktai.authorization.dto.ProjectPayload;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * SKT AI 현재 사용자 정보 응답 DTO
 * 
 * @author ByounggwanLee
 * @since 2025-07-19
 * @version 1.0
 */
@Schema(description = "현재 로그인 사용자 정보")
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MeResponse {

    @Schema(description = "사용자 ID")
    @JsonProperty("id")
    private String id;

    @Schema(description = "사용자명")
    @JsonProperty("username")
    private String username;

    @Schema(description = "이메일")
    @JsonProperty("email")
    private String email;

    @Schema(description = "이름")
    @JsonProperty("first_name")
    private String firstName;

    @Schema(description = "성")
    @JsonProperty("last_name")
    private String lastName;

    @Schema(description = "역할 목록")
    @JsonProperty("roles")
    private List<Object> roles;

    @Schema(description = "프로젝트 정보")
    @JsonProperty("project")
    private ProjectPayload project;

    @Schema(description = "그룹 목록")
    @JsonProperty("groups")
    private List<Object> groups;
}
