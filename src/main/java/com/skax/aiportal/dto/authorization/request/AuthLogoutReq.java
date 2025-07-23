package com.skax.aiportal.dto.authorization.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

/**
 * 로그아웃 요청 DTO
 * 
 * <p>사용자 로그아웃 요청 정보를 담는 DTO입니다.
 * 서버 측에서 토큰을 무효화하고 세션을 종료합니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-07-23
 * @version 1.0
 */
@Schema(description = "로그아웃 요청")
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AuthLogoutReq {

    /**
     * 로그아웃할 사용자명
     */
    @Schema(description = "사용자명", example = "testuser", maxLength = 100)
    @NotBlank(message = "사용자명은 필수입니다")
    @Size(max = 100, message = "사용자명은 100자 이하여야 합니다")
    @JsonProperty("username")
    private String username;
}
