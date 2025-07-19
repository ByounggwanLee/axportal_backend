package com.skax.aiportal.client.sktai.authorization.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.ToString;

/**
 * 로그인 응답 DTO
 * <p>SKT AI 플랫폼의 로그인 응답 정보를 매핑합니다.</p>
 * @author ByounggwanLee
 * @since 2025-07-19
 * @version 1.0
 */
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class LoginResponse {
    private String accessToken;
    private String refreshToken;
    private String tokenType;
    private Long expiresIn;
    private String scope;
    // 필요시 추가 필드 정의
}
