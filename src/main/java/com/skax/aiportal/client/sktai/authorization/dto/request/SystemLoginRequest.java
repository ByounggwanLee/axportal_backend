package com.skax.aiportal.client.sktai.authorization.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import java.util.List;

/**
 * 시스템 로그인 요청 DTO
 * 
 * <p>시스템 간 인증을 위한 로그인 요청 정보를 담는 DTO입니다.
 * 시스템 사용자명, 역할, 그룹 정보를 포함합니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-07-23
 * @version 1.0
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class SystemLoginRequest {

    /**
     * 시스템 사용자명
     */
    @NotBlank(message = "시스템 사용자명은 필수입니다")
    @Size(max = 100, message = "시스템 사용자명은 100자 이하여야 합니다")
    @JsonProperty("username")
    private String username;

    /**
     * 시스템 역할 목록
     */
    @JsonProperty("roles")
    private List<String> roles;

    /**
     * 시스템 그룹 목록
     */
    @JsonProperty("groups")
    private List<String> groups;
}
