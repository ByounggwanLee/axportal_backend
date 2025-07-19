package com.skax.aiportal.controller.authorization;

import com.skax.aiportal.dto.authorization.request.AuthLoginRequest;
import com.skax.aiportal.dto.authorization.request.AuthSystemLoginRequest;
import com.skax.aiportal.dto.authorization.response.AuthTokenResponse;
import com.skax.aiportal.dto.authorization.response.AuthTokenWithProjectResponse;
import com.skax.aiportal.dto.CustomApiResponse;
import com.skax.aiportal.service.authorization.AuthenticationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

/**
 * 인증 컨트롤러
 * 
 * <p>SKT AI 플랫폼의 인증 관련 API 엔드포인트를 제공합니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-07-19
 * @version 1.0
 */
@Tag(name = "인증 API", description = "SKT AI 플랫폼 인증 관련 API")
@Slf4j
@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    /**
     * OAuth2 패스워드 플로우 로그인
     */
    @Operation(summary = "OAuth2 로그인", description = "사용자명과 비밀번호를 사용하여 OAuth2 패스워드 플로우로 로그인합니다.")
    @ApiResponses({
        @ApiResponse(responseCode = "201", description = "로그인 성공"),
        @ApiResponse(responseCode = "400", description = "잘못된 요청 데이터"),
        @ApiResponse(responseCode = "401", description = "인증 실패"),
        @ApiResponse(responseCode = "500", description = "서버 내부 오류")
    })
    @PostMapping("/login")
    public ResponseEntity<CustomApiResponse<?>> login(@Valid @RequestBody AuthLoginRequest request) {
        log.info("OAuth2 로그인 요청: 사용자={}", request.getUsername());
        
        try {
            AuthTokenWithProjectResponse response = authenticationService.login(request);
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(CustomApiResponse.success(response, "로그인이 성공했습니다."));
        } catch (Exception e) {
            log.error("OAuth2 로그인 실패: 사용자={}, 오류={}", request.getUsername(), e.getMessage());
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body(CustomApiResponse.failure("로그인에 실패했습니다."));
        }
    }

    /**
     * 시스템 로그인
     */
    @Operation(summary = "시스템 로그인", description = "시스템에서 사용자 정보를 업데이트하고 액세스 토큰을 발급받습니다.")
    @ApiResponses({
        @ApiResponse(responseCode = "201", description = "시스템 로그인 성공"),
        @ApiResponse(responseCode = "400", description = "잘못된 요청 데이터"),
        @ApiResponse(responseCode = "401", description = "인증 실패"),
        @ApiResponse(responseCode = "500", description = "서버 내부 오류")
    })
    @PostMapping("/login/system")
    public ResponseEntity<CustomApiResponse<?>> systemLogin(
            @Parameter(description = "클라이언트 시크릿", required = true)
            @RequestParam("client_secret") String clientSecret,
            @Parameter(description = "클라이언트명")
            @RequestParam(value = "client_name", defaultValue = "default") String clientName,
            @Valid @RequestBody AuthSystemLoginRequest request) {
        
        log.info("시스템 로그인 요청: 사용자={}, 클라이언트={}", request.getUsername(), clientName);
        
        try {
            AuthTokenResponse response = authenticationService.systemLogin(clientSecret, clientName, request);
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(CustomApiResponse.success(response, "시스템 로그인이 성공했습니다."));
        } catch (Exception e) {
            log.error("시스템 로그인 실패: 사용자={}, 오류={}", request.getUsername(), e.getMessage());
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body(CustomApiResponse.failure("시스템 로그인에 실패했습니다."));
        }
    }

    /**
     * SSO 로그인
     */
    @Operation(summary = "SSO 로그인", description = "Single Sign-On 로그인을 수행합니다.")
    @GetMapping("/login/sso")
    public ResponseEntity<CustomApiResponse<?>> ssoLogin() {
        log.info("SSO 로그인 요청");
        
        try {
            Object response = authenticationService.ssoLogin();
            return ResponseEntity.ok(CustomApiResponse.success(response, "SSO 로그인 처리가 완료되었습니다."));
        } catch (Exception e) {
            log.error("SSO 로그인 실패: 오류={}", e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(CustomApiResponse.failure("SSO 로그인에 실패했습니다."));
        }
    }

    /**
     * SSO 콜백
     */
    @Operation(summary = "SSO 콜백", description = "SSO 로그인 후 콜백을 처리합니다.")
    @GetMapping("/login/sso/callback")
    public ResponseEntity<CustomApiResponse<?>> ssoCallback() {
        log.info("SSO 콜백 요청");
        
        try {
            Object response = authenticationService.ssoCallback();
            return ResponseEntity.ok(CustomApiResponse.success(response, "SSO 콜백 처리가 완료되었습니다."));
        } catch (Exception e) {
            log.error("SSO 콜백 실패: 오류={}", e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(CustomApiResponse.failure("SSO 콜백 처리에 실패했습니다."));
        }
    }

    /**
     * SAML 메타데이터 조회
     */
    @Operation(summary = "SAML 메타데이터", description = "SAML Identity Provider 메타데이터를 조회합니다.")
    @GetMapping("/saml/metadata")
    public ResponseEntity<CustomApiResponse<?>> getSamlMetadata() {
        log.info("SAML 메타데이터 조회 요청");
        
        try {
            Object response = authenticationService.getSamlMetadata();
            return ResponseEntity.ok(CustomApiResponse.success(response, "SAML 메타데이터 조회가 완료되었습니다."));
        } catch (Exception e) {
            log.error("SAML 메타데이터 조회 실패: 오류={}", e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(CustomApiResponse.failure("SAML 메타데이터 조회에 실패했습니다."));
        }
    }

    /**
     * SAML 로그인 폼
     */
    @Operation(summary = "SAML 로그인 폼", description = "SAML SSO 로그인 폼을 반환합니다.")
    @GetMapping(value = "/saml/login", produces = "text/html")
    public ResponseEntity<String> getSamlLoginForm() {
        log.info("SAML 로그인 폼 요청");
        
        try {
            String response = authenticationService.getSamlLoginForm();
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            log.error("SAML 로그인 폼 조회 실패: 오류={}", e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("<html><body><h1>오류가 발생했습니다</h1><p>" + e.getMessage() + "</p></body></html>");
        }
    }

    /**
     * 로그아웃
     */
    @Operation(summary = "로그아웃", description = "현재 사용자를 로그아웃하고 액세스 토큰을 무효화합니다.")
    @PostMapping("/logout")
    public ResponseEntity<CustomApiResponse<?>> logout(
            @Parameter(description = "사용자명", required = true)
            @RequestParam("username") String username) {
        
        log.info("로그아웃 요청: 사용자={}", username);
        
        try {
            Object response = authenticationService.logout(username);
            return ResponseEntity.ok(CustomApiResponse.success(response, "로그아웃이 완료되었습니다."));
        } catch (Exception e) {
            log.error("로그아웃 실패: 사용자={}, 오류={}", username, e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(CustomApiResponse.failure("로그아웃에 실패했습니다."));
        }
    }

    /**
     * 토큰 갱신
     */
    @Operation(summary = "토큰 갱신", description = "리프레시 토큰을 사용하여 새로운 액세스 토큰을 발급받습니다.")
    @PostMapping("/token/refresh")
    public ResponseEntity<CustomApiResponse<?>> refreshToken(
            @Parameter(description = "리프레시 토큰", required = true)
            @RequestParam("refresh_token") String refreshToken) {
        
        log.info("토큰 갱신 요청");
        
        try {
            AuthTokenWithProjectResponse response = authenticationService.refreshToken(refreshToken);
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(CustomApiResponse.success(response, "토큰 갱신이 완료되었습니다."));
        } catch (Exception e) {
            log.error("토큰 갱신 실패: 오류={}", e.getMessage());
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body(CustomApiResponse.failure("토큰 갱신에 실패했습니다."));
        }
    }

    /**
     * 토큰 교환
     */
    @Operation(summary = "토큰 교환", description = "선택된 프로젝트에 대한 인증 토큰을 재발급합니다.")
    @GetMapping("/token/exchange")
    public ResponseEntity<CustomApiResponse<?>> exchangeToken(
            @Parameter(description = "교환할 클라이언트명")
            @RequestParam(value = "to_exchange_client_name", defaultValue = "default") String toExchangeClientName) {
        
        log.info("토큰 교환 요청: 클라이언트={}", toExchangeClientName);
        
        try {
            AuthTokenWithProjectResponse response = authenticationService.exchangeToken(toExchangeClientName);
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(CustomApiResponse.success(response, "토큰 교환이 완료되었습니다."));
        } catch (Exception e) {
            log.error("토큰 교환 실패: 클라이언트={}, 오류={}", toExchangeClientName, e.getMessage());
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body(CustomApiResponse.failure("토큰 교환에 실패했습니다."));
        }
    }

    /**
     * 현재 사용자 정보 조회
     */
    @Operation(summary = "현재 사용자 정보", description = "현재 로그인한 사용자의 정보를 조회합니다.")
    @GetMapping("/me")
    public ResponseEntity<CustomApiResponse<?>> getCurrentUser() {
        log.info("현재 사용자 정보 조회 요청");
        
        try {
            Object response = authenticationService.getCurrentUser();
            return ResponseEntity.ok(CustomApiResponse.success(response, "사용자 정보 조회가 완료되었습니다."));
        } catch (Exception e) {
            log.error("사용자 정보 조회 실패: 오류={}", e.getMessage());
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body(CustomApiResponse.failure("사용자 정보 조회에 실패했습니다."));
        }
    }
}
