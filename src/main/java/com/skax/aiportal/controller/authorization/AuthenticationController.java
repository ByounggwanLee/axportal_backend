package com.skax.aiportal.controller.authorization;

import static com.skax.aiportal.constant.AuthorizationConstants.*;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skax.aiportal.dto.CustomApiResponse;
import com.skax.aiportal.dto.authorization.request.AuthLoginReq;
import com.skax.aiportal.dto.authorization.request.AuthLogoutReq;
import com.skax.aiportal.dto.authorization.request.AuthRefreshTokenReq;
import com.skax.aiportal.dto.authorization.request.AuthSystemLoginReq;
import com.skax.aiportal.dto.authorization.request.AuthTokenExchangeReq;
import com.skax.aiportal.dto.authorization.response.AuthLoginRes;
import com.skax.aiportal.dto.authorization.response.AuthLogoutRes;
import com.skax.aiportal.dto.authorization.response.AuthRefreshTokenRes;
import com.skax.aiportal.dto.authorization.response.AuthSamlMetadataRes;
import com.skax.aiportal.dto.authorization.response.AuthSsoCallbackRes;
import com.skax.aiportal.dto.authorization.response.AuthSsoLoginRes;
import com.skax.aiportal.dto.authorization.response.AuthSystemLoginRes;
import com.skax.aiportal.dto.authorization.response.AuthTokenExchangeRes;
import com.skax.aiportal.service.authorization.AuthenticationService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * 인증 API 컨트롤러
 * 
 * <p>SKT AI 플랫폼의 인증 관련 REST API를 제공하는 컨트롤러입니다.
 * OAuth2, SSO, SAML, 시스템 로그인, 토큰 관리 등의 인증 기능을 제공합니다.</p>
 * 
 * <p>주요 기능:</p>
 * <ul>
 *   <li>OAuth2 패스워드 플로우 로그인</li>
 *   <li>Single Sign-On (SSO) 인증</li>
 *   <li>SAML 기반 인증</li>
 *   <li>시스템 간 인증</li>
 *   <li>토큰 갱신 및 교환</li>
 *   <li>로그아웃 처리</li>
 * </ul>
 * 
 * @author ByounggwanLee
 * @since 2025-07-23
 * @version 1.0
 */
@Tag(
    name = API_TAG_NAME,
    description = API_TAG_DESCRIPTION
)
@Slf4j
@RestController
@RequestMapping(API_BASE_PATH)
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    /**
     * OAuth2 패스워드 플로우 로그인
     * 
     * <p>사용자 이름과 비밀번호를 사용하여 OAuth2 인증을 수행합니다.
     * 성공 시 액세스 토큰과 리프레시 토큰, 사용 가능한 프로젝트 목록을 반환합니다.</p>
     * 
     * @param request OAuth2 로그인 요청 정보
     * @return OAuth2 로그인 응답
     */
    @Operation(
        summary = OPERATION_LOGIN,
        description = OPERATION_LOGIN_DESC
    )
    @ApiResponses({
        @ApiResponse(
            responseCode = "200",
            description = HTTP_200_DESCRIPTION,
            content = @Content(
                mediaType = MediaType.APPLICATION_JSON_VALUE,
                schema = @Schema(implementation = CustomApiResponse.class)
            )
        ),
        @ApiResponse(
            responseCode = "400",
            description = HTTP_400_DESCRIPTION,
            content = @Content(
                mediaType = MediaType.APPLICATION_JSON_VALUE,
                schema = @Schema(implementation = CustomApiResponse.class)
            )
        ),
        @ApiResponse(
            responseCode = "401",
            description = HTTP_401_DESCRIPTION,
            content = @Content(
                mediaType = MediaType.APPLICATION_JSON_VALUE,
                schema = @Schema(implementation = CustomApiResponse.class)
            )
        ),
        @ApiResponse(
            responseCode = "500",
            description = HTTP_500_DESCRIPTION,
            content = @Content(
                mediaType = MediaType.APPLICATION_JSON_VALUE,
                schema = @Schema(implementation = CustomApiResponse.class)
            )
        )
    })
    @PostMapping(value = LOGIN_PATH, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CustomApiResponse<AuthLoginRes>> login(
            @Parameter(description = "OAuth2 로그인 요청 정보", required = true)
            @Valid @RequestBody AuthLoginReq request) {
        
        log.info("OAuth2 로그인 요청: username={}", request.getUsername());
        
        AuthLoginRes response = authenticationService.login(request);
        
        log.info("OAuth2 로그인 성공: username={}", request.getUsername());
        
        return ResponseEntity.ok(
            CustomApiResponse.success(response)
        );
    }

    /**
     * SSO 로그인 초기화
     * 
     * <p>Single Sign-On 로그인 프로세스를 시작합니다.
     * SSO 제공자로의 리디렉션 URL이나 관련 정보를 반환합니다.</p>
     * 
     * @return SSO 로그인 초기화 응답
     */
    @Operation(
        summary = "SSO 로그인 초기화",
        description = "Single Sign-On 로그인 프로세스를 시작하고 리디렉션 정보를 반환합니다."
    )
    @ApiResponses({
        @ApiResponse(
            responseCode = "200",
            description = "SSO 초기화 성공",
            content = @Content(
                mediaType = MediaType.APPLICATION_JSON_VALUE,
                schema = @Schema(implementation = CustomApiResponse.class)
            )
        ),
        @ApiResponse(
            responseCode = "500",
            description = "서버 내부 오류",
            content = @Content(
                mediaType = MediaType.APPLICATION_JSON_VALUE,
                schema = @Schema(implementation = CustomApiResponse.class)
            )
        )
    })
    @GetMapping(value = "/sso/login", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CustomApiResponse<AuthSsoLoginRes>> ssoLogin() {
        
        log.info("SSO 로그인 초기화 요청");
        
        AuthSsoLoginRes response = authenticationService.ssoLogin();
        
        log.info("SSO 로그인 초기화 성공");
        
        return ResponseEntity.ok(
            CustomApiResponse.success(response)
        );
    }

    /**
     * SSO 콜백 처리
     * 
     * <p>SSO 제공자로부터의 콜백을 처리합니다.
     * 인증 코드를 액세스 토큰으로 교환하고 사용자 정보를 반환합니다.</p>
     * 
     * @return SSO 콜백 처리 응답
     */
    @Operation(
        summary = "SSO 콜백 처리",
        description = "SSO 제공자로부터의 콜백을 처리하고 사용자 인증을 완료합니다."
    )
    @ApiResponses({
        @ApiResponse(
            responseCode = "200",
            description = "SSO 콜백 처리 성공",
            content = @Content(
                mediaType = MediaType.APPLICATION_JSON_VALUE,
                schema = @Schema(implementation = CustomApiResponse.class)
            )
        ),
        @ApiResponse(
            responseCode = "400",
            description = "잘못된 콜백 요청",
            content = @Content(
                mediaType = MediaType.APPLICATION_JSON_VALUE,
                schema = @Schema(implementation = CustomApiResponse.class)
            )
        ),
        @ApiResponse(
            responseCode = "500",
            description = "서버 내부 오류",
            content = @Content(
                mediaType = MediaType.APPLICATION_JSON_VALUE,
                schema = @Schema(implementation = CustomApiResponse.class)
            )
        )
    })
    @GetMapping(value = "/sso/callback", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CustomApiResponse<AuthSsoCallbackRes>> ssoCallback() {
        
        log.info("SSO 콜백 처리 요청");
        
        AuthSsoCallbackRes response = authenticationService.ssoCallback();
        
        log.info("SSO 콜백 처리 성공");
        
        return ResponseEntity.ok(
            CustomApiResponse.success(response, AUTH_SSO_CALLBACK_SUCCESS_MESSAGE)
        );
    }

    /**
     * SAML IdP 메타데이터 조회
     * 
     * <p>SAML Identity Provider의 메타데이터 정보를 조회합니다.
     * SAML SP 설정에 필요한 IdP 정보를 제공합니다.</p>
     * 
     * @return SAML IdP 메타데이터 응답
     */
    @Operation(
        summary = "SAML 메타데이터 조회",
        description = "SAML Identity Provider의 메타데이터 정보를 조회합니다."
    )
    @ApiResponses({
        @ApiResponse(
            responseCode = "200",
            description = "SAML 메타데이터 조회 성공",
            content = @Content(
                mediaType = MediaType.APPLICATION_JSON_VALUE,
                schema = @Schema(implementation = CustomApiResponse.class)
            )
        ),
        @ApiResponse(
            responseCode = "500",
            description = "서버 내부 오류",
            content = @Content(
                mediaType = MediaType.APPLICATION_JSON_VALUE,
                schema = @Schema(implementation = CustomApiResponse.class)
            )
        )
    })
    @GetMapping(value = "/saml/metadata", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CustomApiResponse<AuthSamlMetadataRes>> getSamlMetadata() {
        
        log.info("SAML 메타데이터 조회 요청");
        
        AuthSamlMetadataRes response = authenticationService.getSamlMetadata();
        
        log.info("SAML 메타데이터 조회 성공");
        
        return ResponseEntity.ok(
            CustomApiResponse.success(response, AUTH_SAML_METADATA_SUCCESS_MESSAGE)
        );
    }

    /**
     * 시스템 로그인
     * 
     * <p>시스템 간 인증을 위한 로그인을 수행합니다.
     * 클라이언트 시크릿을 사용하여 시스템 레벨의 액세스 토큰을 발급받습니다.</p>
     * 
     * @param request 시스템 로그인 요청 정보
     * @return 시스템 로그인 응답
     */
    @Operation(
        summary = "시스템 로그인",
        description = "클라이언트 시크릿을 사용한 시스템 간 인증을 수행합니다."
    )
    @ApiResponses({
        @ApiResponse(
            responseCode = "200",
            description = "시스템 로그인 성공",
            content = @Content(
                mediaType = MediaType.APPLICATION_JSON_VALUE,
                schema = @Schema(implementation = CustomApiResponse.class)
            )
        ),
        @ApiResponse(
            responseCode = "400",
            description = "잘못된 요청 - 필수 파라미터 누락 또는 유효하지 않은 형식",
            content = @Content(
                mediaType = MediaType.APPLICATION_JSON_VALUE,
                schema = @Schema(implementation = CustomApiResponse.class)
            )
        ),
        @ApiResponse(
            responseCode = "401",
            description = "인증 실패 - 잘못된 클라이언트 시크릿",
            content = @Content(
                mediaType = MediaType.APPLICATION_JSON_VALUE,
                schema = @Schema(implementation = CustomApiResponse.class)
            )
        ),
        @ApiResponse(
            responseCode = "500",
            description = "서버 내부 오류",
            content = @Content(
                mediaType = MediaType.APPLICATION_JSON_VALUE,
                schema = @Schema(implementation = CustomApiResponse.class)
            )
        )
    })
    @PostMapping(value = "/system/login", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CustomApiResponse<AuthSystemLoginRes>> systemLogin(
            @Parameter(description = "시스템 로그인 요청 정보", required = true)
            @Valid @RequestBody AuthSystemLoginReq request) {
        
        log.info("시스템 로그인 요청: clientName={}", request.getClientName());
        
        AuthSystemLoginRes response = authenticationService.systemLogin(request);
        
        log.info("시스템 로그인 성공: clientName={}", request.getClientName());
        
        return ResponseEntity.ok(
            CustomApiResponse.success(response, AUTH_SYSTEM_LOGIN_SUCCESS_MESSAGE)
        );
    }

    /**
     * 로그아웃
     * 
     * <p>사용자의 로그아웃을 처리합니다.
     * 서버 측에서 토큰을 무효화하고 세션을 종료합니다.</p>
     * 
     * @param request 로그아웃 요청 정보
     * @return 로그아웃 처리 응답
     */
    @Operation(
        summary = "로그아웃",
        description = "사용자의 로그아웃을 처리하고 토큰을 무효화합니다."
    )
    @ApiResponses({
        @ApiResponse(
            responseCode = "200",
            description = "로그아웃 성공",
            content = @Content(
                mediaType = MediaType.APPLICATION_JSON_VALUE,
                schema = @Schema(implementation = CustomApiResponse.class)
            )
        ),
        @ApiResponse(
            responseCode = "400",
            description = "잘못된 요청 - 필수 파라미터 누락",
            content = @Content(
                mediaType = MediaType.APPLICATION_JSON_VALUE,
                schema = @Schema(implementation = CustomApiResponse.class)
            )
        ),
        @ApiResponse(
            responseCode = "500",
            description = "서버 내부 오류",
            content = @Content(
                mediaType = MediaType.APPLICATION_JSON_VALUE,
                schema = @Schema(implementation = CustomApiResponse.class)
            )
        )
    })
    @PostMapping(value = "/logout", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CustomApiResponse<AuthLogoutRes>> logout(
            @Parameter(description = "로그아웃 요청 정보", required = true)
            @Valid @RequestBody AuthLogoutReq request) {
        
        log.info("로그아웃 요청: username={}", request.getUsername());
        
        AuthLogoutRes response = authenticationService.logout(request);
        
        log.info("로그아웃 성공: username={}", request.getUsername());
        
        return ResponseEntity.ok(
            CustomApiResponse.success(response, AUTH_LOGOUT_SUCCESS_MESSAGE)
        );
    }

    /**
     * 리프레시 토큰을 사용한 액세스 토큰 갱신
     * 
     * <p>만료된 액세스 토큰을 리프레시 토큰을 사용하여 갱신합니다.
     * 새로운 액세스 토큰과 사용 가능한 프로젝트 목록을 반환합니다.</p>
     * 
     * @param request 토큰 갱신 요청 정보
     * @return 토큰 갱신 응답
     */
    @Operation(
        summary = "토큰 갱신",
        description = "리프레시 토큰을 사용하여 만료된 액세스 토큰을 갱신합니다."
    )
    @ApiResponses({
        @ApiResponse(
            responseCode = "200",
            description = "토큰 갱신 성공",
            content = @Content(
                mediaType = MediaType.APPLICATION_JSON_VALUE,
                schema = @Schema(implementation = CustomApiResponse.class)
            )
        ),
        @ApiResponse(
            responseCode = "400",
            description = "잘못된 요청 - 유효하지 않은 리프레시 토큰",
            content = @Content(
                mediaType = MediaType.APPLICATION_JSON_VALUE,
                schema = @Schema(implementation = CustomApiResponse.class)
            )
        ),
        @ApiResponse(
            responseCode = "401",
            description = "인증 실패 - 만료되었거나 유효하지 않은 리프레시 토큰",
            content = @Content(
                mediaType = MediaType.APPLICATION_JSON_VALUE,
                schema = @Schema(implementation = CustomApiResponse.class)
            )
        ),
        @ApiResponse(
            responseCode = "500",
            description = "서버 내부 오류",
            content = @Content(
                mediaType = MediaType.APPLICATION_JSON_VALUE,
                schema = @Schema(implementation = CustomApiResponse.class)
            )
        )
    })
    @PostMapping(value = "/token/refresh", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CustomApiResponse<AuthRefreshTokenRes>> refreshToken(
            @Parameter(description = "토큰 갱신 요청 정보", required = true)
            @Valid @RequestBody AuthRefreshTokenReq request) {
        
        log.info("토큰 갱신 요청");
        
        AuthRefreshTokenRes response = authenticationService.refreshToken(request);
        
        log.info("토큰 갱신 성공");
        
        return ResponseEntity.ok(
            CustomApiResponse.success(response, AUTH_REFRESH_TOKEN_SUCCESS_MESSAGE)
        );
    }

    /**
     * 토큰 교환
     * 
     * <p>현재 토큰을 다른 클라이언트용 토큰으로 교환합니다.
     * 마이크로서비스 간 토큰 전달 시 사용됩니다.</p>
     * 
     * @param request 토큰 교환 요청 정보
     * @return 토큰 교환 응답
     */
    @Operation(
        summary = "토큰 교환",
        description = "현재 토큰을 다른 클라이언트용 토큰으로 교환합니다."
    )
    @ApiResponses({
        @ApiResponse(
            responseCode = "200",
            description = "토큰 교환 성공",
            content = @Content(
                mediaType = MediaType.APPLICATION_JSON_VALUE,
                schema = @Schema(implementation = CustomApiResponse.class)
            )
        ),
        @ApiResponse(
            responseCode = "400",
            description = "잘못된 요청 - 유효하지 않은 클라이언트명",
            content = @Content(
                mediaType = MediaType.APPLICATION_JSON_VALUE,
                schema = @Schema(implementation = CustomApiResponse.class)
            )
        ),
        @ApiResponse(
            responseCode = "401",
            description = "인증 실패 - 유효하지 않은 토큰",
            content = @Content(
                mediaType = MediaType.APPLICATION_JSON_VALUE,
                schema = @Schema(implementation = CustomApiResponse.class)
            )
        ),
        @ApiResponse(
            responseCode = "500",
            description = "서버 내부 오류",
            content = @Content(
                mediaType = MediaType.APPLICATION_JSON_VALUE,
                schema = @Schema(implementation = CustomApiResponse.class)
            )
        )
    })
    @PostMapping(value = "/token/exchange", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CustomApiResponse<AuthTokenExchangeRes>> exchangeToken(
            @Parameter(description = "토큰 교환 요청 정보", required = true)
            @Valid @RequestBody AuthTokenExchangeReq request) {
        
        log.info("토큰 교환 요청: toExchangeClientName={}", request.getToExchangeClientName());
        
        AuthTokenExchangeRes response = authenticationService.exchangeToken(request);
        
        log.info("토큰 교환 성공: toExchangeClientName={}", request.getToExchangeClientName());
        
        return ResponseEntity.ok(
            CustomApiResponse.success(response, AUTH_TOKEN_EXCHANGE_SUCCESS_MESSAGE)
        );
    }
}
