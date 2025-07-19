package com.skax.aiportal.dto.authorization.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import jakarta.validation.constraints.NotBlank;

/**
 * 토큰 갱신 요청 DTO
 * 
 * <p>Access Token 갱신 요청 시 사용하는 데이터 전송 객체입니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-07-19
 * @version 1.0
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TokenRefreshRequest {

    /**
     * 갱신 토큰
     */
    @NotBlank(message = "리프레시 토큰은 필수입니다")
    private String refreshToken;

    /**
     * 만료된 액세스 토큰
     */
    private String accessToken;
}
