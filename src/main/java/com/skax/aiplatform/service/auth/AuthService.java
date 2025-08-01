package com.skax.aiplatform.service.auth;

import com.skax.aiplatform.dto.auth.request.LoginReq;
import com.skax.aiplatform.dto.auth.request.RefreshTokenReq;
import com.skax.aiplatform.dto.auth.response.JwtTokenRes;
import com.skax.aiplatform.dto.auth.response.UserInfoRes;

/**
 * 인증 서비스 인터페이스
 * 
 * <p>사용자 로그인, 토큰 발급, 토큰 갱신 등의 인증 관련 비즈니스 로직을 정의합니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-08-02
 * @version 1.0.0
 */
public interface AuthService {

    /**
     * 사용자 로그인
     * 
     * @param loginReq 로그인 요청
     * @return JWT 토큰 응답
     */
    JwtTokenRes login(LoginReq loginReq);

    /**
     * Access Token 갱신
     * 
     * @param refreshTokenReq 토큰 갱신 요청
     * @return 새로운 JWT 토큰 응답
     */
    JwtTokenRes refreshToken(RefreshTokenReq refreshTokenReq);

    /**
     * 현재 인증된 사용자 정보 조회
     * 
     * @return 사용자 정보 응답
     */
    UserInfoRes getCurrentUserInfo();

    /**
     * 로그아웃 (토큰 무효화)
     * 
     * @param accessToken Access Token
     */
    void logout(String accessToken);
}
