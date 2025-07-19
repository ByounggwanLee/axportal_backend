package com.skax.aiportal.client.sktai.authorization.dto.request;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.ToString;

import jakarta.validation.constraints.NotBlank;

/**
 * 로그인 요청 DTO
 * <p>SKT AI 플랫폼의 로그인 요청 정보를 매핑합니다.</p>
 * @author ByounggwanLee
 * @since 2025-07-19
 * @version 1.0
 */
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class LoginRequest {
    @NotBlank(message = "아이디는 필수입니다.")
    private String username;
    @NotBlank(message = "비밀번호는 필수입니다.")
    private String password;
}
