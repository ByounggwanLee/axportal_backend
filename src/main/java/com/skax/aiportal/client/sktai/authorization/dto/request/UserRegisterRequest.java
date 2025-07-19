package com.skax.aiportal.client.sktai.authorization.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * SKT AI 사용자 등록 요청 DTO
 * 
 * @author ByounggwanLee
 * @since 2025-07-19
 * @version 1.0
 */
@Schema(description = "사용자 등록 요청")
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserRegisterRequest {

    @Schema(description = "사용자명", required = true)
    @JsonProperty("username")
    private String username;

    @Schema(description = "비밀번호", required = true)
    @JsonProperty("password")
    private String password;

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
    private List<String> roles;

    @Schema(description = "그룹 목록")
    @JsonProperty("groups")
    private List<String> groups;
}

