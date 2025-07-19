package com.skax.aiportal.client.sktai.authorization.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * SKT AI 시스템 로그인 요청 DTO
 * 
 * <p>시스템에서 사용자 정보를 업데이트하고 토큰을 발급받는 요청입니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-07-19
 * @version 1.0
 */
@Schema(description = "SKT AI 시스템 로그인 요청")
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SystemLoginRequest {

    /**
     * 사용자명
     */
    @Schema(description = "사용자명", example = "system_user", required = true)
    @JsonProperty("username")
    private String username;

    /**
     * 역할 목록
     */
    @Schema(description = "사용자 역할 목록", example = "[]")
    @JsonProperty("roles")
    @Builder.Default
    private List<Object> roles = List.of();

    /**
     * 그룹 목록
     */
    @Schema(description = "사용자 그룹 목록", example = "[]")
    @JsonProperty("groups")
    @Builder.Default
    private List<Object> groups = List.of();
}
