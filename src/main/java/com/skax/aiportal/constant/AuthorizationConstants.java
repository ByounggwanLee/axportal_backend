package com.skax.aiportal.constant;

/**
 * 인증/인가 관련 상수 클래스
 * 
 * <p>SKT AI 플랫폼의 인증/인가 관련 모든 상수값들을 관리하는 클래스입니다.
 * 에러 코드, 메시지, 기본값, API 경로 등을 정의합니다.</p>
 * 
 * <p>주요 카테고리:</p>
 * <ul>
 *   <li>API 경로 상수</li>
 *   <li>에러 코드 및 메시지</li>
 *   <li>성공 메시지</li>
 *   <li>토큰 관련 상수</li>
 *   <li>OAuth2/SSO/SAML 기본값</li>
 * </ul>
 * 
 * @author ByounggwanLee
 * @since 2025-07-24
 * @version 1.0
 */
public final class AuthorizationConstants {

    private AuthorizationConstants() {
        // 유틸리티 클래스는 인스턴스화 방지
    }

    // ===== API 경로 상수 =====
    public static final String API_BASE_PATH = "/api/v1/auth";
    public static final String LOGIN_PATH = "/login";
    public static final String SSO_LOGIN_PATH = "/sso/login";
    public static final String SSO_CALLBACK_PATH = "/sso/callback";
    public static final String SAML_METADATA_PATH = "/saml/metadata";
    public static final String SYSTEM_LOGIN_PATH = "/system/login";
    public static final String LOGOUT_PATH = "/logout";
    public static final String REFRESH_TOKEN_PATH = "/refresh";
    public static final String TOKEN_EXCHANGE_PATH = "/token/exchange";

    // ===== 에러 코드 =====
    public static final String AUTH_LOGIN_ERROR_CODE = "AUTH_001";
    public static final String AUTH_SSO_LOGIN_ERROR_CODE = "AUTH_002";
    public static final String AUTH_SSO_CALLBACK_ERROR_CODE = "AUTH_003";
    public static final String AUTH_SAML_METADATA_ERROR_CODE = "AUTH_004";
    public static final String AUTH_SYSTEM_LOGIN_ERROR_CODE = "AUTH_005";
    public static final String AUTH_LOGOUT_ERROR_CODE = "AUTH_006";
    public static final String AUTH_REFRESH_TOKEN_ERROR_CODE = "AUTH_007";
    public static final String AUTH_TOKEN_EXCHANGE_ERROR_CODE = "AUTH_008";
    public static final String AUTH_TOKEN_VALIDATION_ERROR_CODE = "AUTH_009";
    public static final String AUTH_UNAUTHORIZED_ERROR_CODE = "AUTH_010";

    // ===== 에러 메시지 =====
    public static final String AUTH_LOGIN_ERROR_MESSAGE = "OAuth2 로그인에 실패했습니다: %s";
    public static final String AUTH_SSO_LOGIN_ERROR_MESSAGE = "SSO 로그인 초기화에 실패했습니다: %s";
    public static final String AUTH_SSO_CALLBACK_ERROR_MESSAGE = "SSO 콜백 처리에 실패했습니다: %s";
    public static final String AUTH_SAML_METADATA_ERROR_MESSAGE = "SAML 메타데이터 조회에 실패했습니다: %s";
    public static final String AUTH_SYSTEM_LOGIN_ERROR_MESSAGE = "시스템 로그인에 실패했습니다: %s";
    public static final String AUTH_LOGOUT_ERROR_MESSAGE = "로그아웃 처리에 실패했습니다: %s";
    public static final String AUTH_REFRESH_TOKEN_ERROR_MESSAGE = "토큰 갱신에 실패했습니다: %s";
    public static final String AUTH_TOKEN_EXCHANGE_ERROR_MESSAGE = "토큰 교환에 실패했습니다: %s";
    public static final String AUTH_TOKEN_VALIDATION_ERROR_MESSAGE = "토큰 검증에 실패했습니다: %s";
    public static final String AUTH_UNAUTHORIZED_ERROR_MESSAGE = "인증되지 않은 요청입니다: %s";

    // ===== 성공 메시지 =====
    public static final String AUTH_LOGIN_SUCCESS_MESSAGE = "로그인이 성공적으로 완료되었습니다.";
    public static final String AUTH_SSO_LOGIN_SUCCESS_MESSAGE = "SSO 로그인이 성공적으로 완료되었습니다.";
    public static final String AUTH_SSO_CALLBACK_SUCCESS_MESSAGE = "SSO 콜백 처리가 성공적으로 완료되었습니다.";
    public static final String AUTH_SAML_METADATA_SUCCESS_MESSAGE = "SAML 메타데이터 조회가 성공적으로 완료되었습니다.";
    public static final String AUTH_SYSTEM_LOGIN_SUCCESS_MESSAGE = "시스템 로그인이 성공적으로 완료되었습니다.";
    public static final String AUTH_LOGOUT_SUCCESS_MESSAGE = "로그아웃이 성공적으로 처리되었습니다.";
    public static final String AUTH_REFRESH_TOKEN_SUCCESS_MESSAGE = "토큰 갱신이 성공적으로 완료되었습니다.";
    public static final String AUTH_TOKEN_EXCHANGE_SUCCESS_MESSAGE = "토큰 교환이 성공적으로 완료되었습니다.";

    // ===== 토큰 관련 상수 =====
    public static final String TOKEN_TYPE_BEARER = "Bearer";
    public static final String TOKEN_TYPE_ACCESS = "access_token";
    public static final String TOKEN_TYPE_REFRESH = "refresh_token";
    public static final String TOKEN_TYPE_ID = "id_token";
    public static final String GRANT_TYPE_AUTHORIZATION_CODE = "authorization_code";
    public static final String GRANT_TYPE_REFRESH_TOKEN = "refresh_token";
    public static final String GRANT_TYPE_CLIENT_CREDENTIALS = "client_credentials";

    // ===== OAuth2/SSO/SAML 기본값 =====
    public static final String DEFAULT_SSO_STATE = "skt_ai_sso_state";
    public static final String DEFAULT_ENTITY_ID = "https://aip-stg.sktai.io/saml/metadata";
    public static final String DEFAULT_SSO_URL = "https://aip-stg.sktai.io/saml/sso";
    public static final String DEFAULT_REDIRECT_URI = "/auth/callback";
    public static final String DEFAULT_SCOPE = "openid profile email";
    public static final String DEFAULT_RESPONSE_TYPE = "code";

    // ===== HTTP 상태 코드 설명 =====
    public static final String HTTP_200_DESCRIPTION = "인증 성공";
    public static final String HTTP_201_DESCRIPTION = "로그인 성공";
    public static final String HTTP_400_DESCRIPTION = "잘못된 요청 - 필수 파라미터 누락 또는 유효하지 않은 형식";
    public static final String HTTP_401_DESCRIPTION = "인증 실패 - 유효하지 않은 자격 증명";
    public static final String HTTP_403_DESCRIPTION = "접근 권한 없음";
    public static final String HTTP_500_DESCRIPTION = "서버 내부 오류";

    // ===== API 문서화 관련 상수 =====
    public static final String API_TAG_NAME = "Authentication API";
    public static final String API_TAG_DESCRIPTION = "SKT AI 플랫폼 인증/인가 API";

    // ===== 검증 메시지 =====
    public static final String VALIDATION_USERNAME_REQUIRED = "사용자명은 필수입니다";
    public static final String VALIDATION_PASSWORD_REQUIRED = "비밀번호는 필수입니다";
    public static final String VALIDATION_TOKEN_REQUIRED = "토큰은 필수입니다";
    public static final String VALIDATION_STATE_REQUIRED = "상태값은 필수입니다";
    public static final String VALIDATION_CODE_REQUIRED = "인증 코드는 필수입니다";
    public static final String VALIDATION_CLIENT_ID_REQUIRED = "클라이언트 ID는 필수입니다";
    public static final String VALIDATION_REDIRECT_URI_REQUIRED = "리다이렉트 URI는 필수입니다";

    // ===== 파라미터 설명 =====
    public static final String PARAM_USERNAME_DESCRIPTION = "사용자명";
    public static final String PARAM_PASSWORD_DESCRIPTION = "비밀번호";
    public static final String PARAM_TOKEN_DESCRIPTION = "인증 토큰";
    public static final String PARAM_STATE_DESCRIPTION = "SSO 상태값";
    public static final String PARAM_CODE_DESCRIPTION = "OAuth2 인증 코드";
    public static final String PARAM_CLIENT_ID_DESCRIPTION = "OAuth2 클라이언트 ID";
    public static final String PARAM_REDIRECT_URI_DESCRIPTION = "OAuth2 리다이렉트 URI";

    // ===== API 작업 설명 =====
    public static final String OPERATION_LOGIN = "OAuth2 로그인";
    public static final String OPERATION_SSO_LOGIN = "SSO 로그인 초기화";
    public static final String OPERATION_SSO_CALLBACK = "SSO 콜백 처리";
    public static final String OPERATION_SAML_METADATA = "SAML 메타데이터 조회";
    public static final String OPERATION_SYSTEM_LOGIN = "시스템 로그인";
    public static final String OPERATION_LOGOUT = "로그아웃";
    public static final String OPERATION_REFRESH_TOKEN = "토큰 갱신";
    public static final String OPERATION_TOKEN_EXCHANGE = "토큰 교환";

    // ===== API 작업 상세 설명 =====
    public static final String OPERATION_LOGIN_DESC = "OAuth2 프로토콜을 사용하여 사용자 로그인을 처리합니다.";
    public static final String OPERATION_SSO_LOGIN_DESC = "SSO 로그인 세션을 초기화하고 인증 URL을 생성합니다.";
    public static final String OPERATION_SSO_CALLBACK_DESC = "SSO 인증 완료 후 콜백을 처리하고 토큰을 발급합니다.";
    public static final String OPERATION_SAML_METADATA_DESC = "SAML 인증에 필요한 메타데이터를 조회합니다.";
    public static final String OPERATION_SYSTEM_LOGIN_DESC = "시스템 계정으로 로그인을 처리합니다.";
    public static final String OPERATION_LOGOUT_DESC = "사용자 세션을 종료하고 로그아웃을 처리합니다.";
    public static final String OPERATION_REFRESH_TOKEN_DESC = "리프레시 토큰을 사용하여 액세스 토큰을 갱신합니다.";
    public static final String OPERATION_TOKEN_EXCHANGE_DESC = "토큰 교환을 통해 다른 형태의 토큰을 발급합니다.";

    // ===== SSO 상수 =====
    public static final String SSO_PROVIDER_KEYCLOAK = "keycloak";
    public static final String SSO_PROVIDER_OKTA = "okta";
    public static final String SSO_PROVIDER_AZURE_AD = "azure_ad";
    public static final String SSO_PROVIDER_GOOGLE = "google";

    // ===== SAML 상수 =====
    public static final String SAML_BINDING_HTTP_POST = "urn:oasis:names:tc:SAML:2.0:bindings:HTTP-POST";
    public static final String SAML_BINDING_HTTP_REDIRECT = "urn:oasis:names:tc:SAML:2.0:bindings:HTTP-Redirect";
    public static final String SAML_NAMEID_FORMAT_EMAIL = "urn:oasis:names:tc:SAML:1.1:nameid-format:emailAddress";
    public static final String SAML_NAMEID_FORMAT_PERSISTENT = "urn:oasis:names:tc:SAML:2.0:nameid-format:persistent";

    // ===== 세션 관련 상수 =====
    public static final String SESSION_USER_KEY = "authenticated_user";
    public static final String SESSION_TOKEN_KEY = "access_token";
    public static final String SESSION_REFRESH_TOKEN_KEY = "refresh_token";
    public static final int SESSION_TIMEOUT_MINUTES = 30;
    public static final int TOKEN_EXPIRY_MINUTES = 60;
    public static final int REFRESH_TOKEN_EXPIRY_DAYS = 7;
}
