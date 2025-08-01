package com.skax.aiplatform.controller.auth;

import com.skax.aiplatform.common.response.AxResponse;
import com.skax.aiplatform.dto.auth.request.LoginReq;
import com.skax.aiplatform.dto.auth.request.RefreshTokenReq;
import com.skax.aiplatform.dto.auth.response.JwtTokenRes;
import com.skax.aiplatform.dto.auth.response.UserInfoRes;
import com.skax.aiplatform.service.auth.AuthService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

/**
 * 인증 컨트롤러
 * 
 * <p>사용자 인증과 관련된 API를 제공합니다.
 * 로그인, 토큰 갱신, 사용자 정보 조회, 로그아웃 등의 기능을 포함합니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-08-01
 * @version 1.0.0
 */
@Slf4j
@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
@Tag(name = "Authentication", description = "인증 관리 API")
public class AuthController {

    private final AuthService authService;

    /**
     * 사용자 로그인
     * 
     * @param loginReq 로그인 요청
     * @return JWT 토큰 응답
     */
    @PostMapping("/login")
    @Operation(summary = "사용자 로그인", description = "사용자명과 비밀번호로 로그인하여 JWT 토큰을 발급받습니다.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "로그인 성공"),
            @ApiResponse(responseCode = "400", description = "잘못된 요청 데이터"),
            @ApiResponse(responseCode = "401", description = "인증 실패")
    })
    public ResponseEntity<AxResponse<JwtTokenRes>> login(@Valid @RequestBody LoginReq loginReq) {
        log.info("로그인 요청: {}", loginReq.getUsername());

        JwtTokenRes tokenResponse = authService.login(loginReq);

        return ResponseEntity.ok(AxResponse.success(tokenResponse, "로그인이 성공했습니다"));
    }

    /**
     * Access Token 갱신
     * 
     * @param refreshTokenReq 토큰 갱신 요청
     * @return 새로운 JWT 토큰 응답
     */
    @PostMapping("/refe")
    @Operation(summary = "토큰 갱신", description = "Refresh Token을 사용하여 새로운 Access Token을 발급받습니다.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "토큰 갱신 성공"),
            @ApiResponse(responseCode = "400", description = "잘못된 요청 데이터"),
            @ApiResponse(responseCode = "401", description = "유효하지 않은 Refresh Token")
    })
    public ResponseEntity<AxResponse<JwtTokenRes>> refeToken(@Valid @RequestBody RefreshTokenReq refreshTokenReq) {
        log.info("토큰 갱신 요청");

        JwtTokenRes tokenResponse = authService.refeToken(refreshTokenReq);

        return ResponseEntity.ok(AxResponse.success(tokenResponse, "토큰이 갱신되었습니다"));
    }

    /**
     * 현재 사용자 정보 조회
     * 
     * @return 사용자 정보 응답
     */
    @GetMapping("/me")
    @SecurityRequirement(name = "bearerAuth")
    @Operation(summary = "현재 사용자 정보", description = "현재 인증된 사용자의 정보를 조회합니다.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "사용자 정보 조회 성공"),
            @ApiResponse(responseCode = "401", description = "인증되지 않은 사용자")
    })
    public ResponseEntity<AxResponse<UserInfoRes>> getCurrentUser() {
        log.info("현재 사용자 정보 조회 요청");

        UserInfoRes userInfo = authService.getCurrentUserInfo();

        return ResponseEntity.ok(AxResponse.success(userInfo, "사용자 정보를 조회했습니다"));
    }

    /**
     * 사용자 로그아웃
     * 
     * @param request HTTP 요청
     * @return 로그아웃 응답
     */
    @PostMapping("/logout")
    @SecurityRequirement(name = "bearerAuth")
    @Operation(summary = "사용자 로그아웃", description = "현재 사용자를 로그아웃하고 토큰을 무효화합니다.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "로그아웃 성공"),
            @ApiResponse(responseCode = "401", description = "인증되지 않은 사용자")
    })
    public ResponseEntity<AxResponse<Void>> logout(HttpServletRequest request) {
        log.info("로그아웃 요청");

        String accessToken = extrTokenFromRequest(request);
        if (StringUtils.hasText(accessToken)) {
            authService.logout(accessToken);
        }

        return ResponseEntity.ok(AxResponse.success(null, "로그아웃이 완료되었습니다"));
    }

    /**
     * 토큰 유효성 검증
     * 
     * @return 검증 결과
     */
    @GetMapping("/validate")
    @SecurityRequirement(name = "bearerAuth")
    @Operation(summary = "토큰 유효성 검증", description = "현재 토큰의 유효성을 검증합니다.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "유효한 토큰"),
            @ApiResponse(responseCode = "401", description = "유효하지 않은 토큰")
    })
    public ResponseEntity<AxResponse<String>> validToken() {
        log.info("토큰 유효성 검증 요청");

        return ResponseEntity.ok(AxResponse.success("valid", "유효한 토큰입니다"));
    }

    /**
     * HTTP 요청에서 JWT 토큰 추출
     * 
     * @param request HTTP 요청
     * @return JWT 토큰
     */
    private String extrTokenFromRequest(HttpServletRequest request) {
        String bearerToken = request.getHeader("Authorization");
        if (StringUtils.hasText(bearerToken) && bearerToken.startsWith("Bearer ")) {
            return bearerToken.substring(7);
        }
        return null;
    }
}
