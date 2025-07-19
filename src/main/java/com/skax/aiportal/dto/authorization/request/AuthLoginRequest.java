package com.skax.aiportal.dto.authorization.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import jakarta.validation.constraints.NotBlank;

/**
 * 인증 로그인 요청 DTO
 * 
 * <p>사용자 로그인 요청 시 사용하는 데이터 전송 객체입니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-07-19
 * @version 1.0
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AuthLoginRequest {

    /**
     * 사용자명 또는 이메일
     */
    @NotBlank(message = "사용자명은 필수입니다")
    private String username;

    /**
     * 비밀번호
     */
    @NotBlank(message = "비밀번호는 필수입니다")
    private String password;

    /**
     * 자동 로그인 여부
     */
    @JsonProperty("remember_me")
    @Builder.Default
    private Boolean rememberMe = false;
}
