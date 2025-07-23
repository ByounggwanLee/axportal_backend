package com.skax.aiportal.constant;

/**
 * 인증 관련 상수 클래스
 * 
 * <p>SKT AI 플랫폼의 인증 관련 에러 코드, 메시지, 기본값 등을 정의하는 상수 클래스입니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-07-23
 * @version 1.0
 */
public final class AuthConstants {

    private AuthConstants() {
        // 유틸리티 클래스는 인스턴스화 금지
    }

    // ========== 에러 코드 ==========
    
    /**
     * OAuth2 로그인 에러 코드
     */
    public static final String LOGIN_ERROR_CODE = "AUTH_001";
    
    /**
     * SSO 로그인 초기화 에러 코드
     */
    public static final String SSO_LOGIN_ERROR_CODE = "AUTH_002";
    
    /**
     * SSO 콜백 처리 에러 코드
     */
    public static final String SSO_CALLBACK_ERROR_CODE = "AUTH_003";
    
    /**
     * SAML 메타데이터 조회 에러 코드
     */
    public static final String SAML_METADATA_ERROR_CODE = "AUTH_004";
    
    /**
     * 시스템 로그인 에러 코드
     */
    public static final String SYSTEM_LOGIN_ERROR_CODE = "AUTH_005";
    
    /**
     * 로그아웃 에러 코드
     */
    public static final String LOGOUT_ERROR_CODE = "AUTH_006";
    
    /**
     * 토큰 갱신 에러 코드
     */
    public static final String REFRESH_TOKEN_ERROR_CODE = "AUTH_007";
    
    /**
     * 토큰 교환 에러 코드
     */
    public static final String TOKEN_EXCHANGE_ERROR_CODE = "AUTH_008";

    // ========== 에러 메시지 ==========
    
    /**
     * OAuth2 로그인 에러 메시지
     */
    public static final String LOGIN_ERROR_MESSAGE = "OAuth2 로그인에 실패했습니다";
    
    /**
     * SSO 로그인 초기화 에러 메시지
     */
    public static final String SSO_LOGIN_ERROR_MESSAGE = "SSO 로그인 초기화에 실패했습니다";
    
    /**
     * SSO 콜백 처리 에러 메시지
     */
    public static final String SSO_CALLBACK_ERROR_MESSAGE = "SSO 콜백 처리에 실패했습니다";
    
    /**
     * SAML 메타데이터 조회 에러 메시지
     */
    public static final String SAML_METADATA_ERROR_MESSAGE = "SAML 메타데이터 조회에 실패했습니다";
    
    /**
     * 시스템 로그인 에러 메시지
     */
    public static final String SYSTEM_LOGIN_ERROR_MESSAGE = "시스템 로그인에 실패했습니다";
    
    /**
     * 로그아웃 에러 메시지
     */
    public static final String LOGOUT_ERROR_MESSAGE = "로그아웃 처리에 실패했습니다";
    
    /**
     * 토큰 갱신 에러 메시지
     */
    public static final String REFRESH_TOKEN_ERROR_MESSAGE = "토큰 갱신에 실패했습니다";
    
    /**
     * 토큰 교환 에러 메시지
     */
    public static final String TOKEN_EXCHANGE_ERROR_MESSAGE = "토큰 교환에 실패했습니다";

    // ========== 성공 메시지 ==========
    
    /**
     * SSO 성공 메시지
     */
    public static final String SSO_SUCCESS_MESSAGE = "SSO 인증이 성공적으로 완료되었습니다";
    
    /**
     * 로그아웃 성공 메시지
     */
    public static final String LOGOUT_SUCCESS_MESSAGE = "로그아웃이 성공적으로 처리되었습니다";

    // ========== 기본값 ==========
    
    /**
     * 기본 SSO 상태값
     */
    public static final String DEFAULT_SSO_STATE = "skt_ai_sso_state";
    
    /**
     * 기본 Entity ID
     */
    public static final String DEFAULT_ENTITY_ID = "https://aip-stg.sktai.io/saml/metadata";
    
    /**
     * 기본 SSO URL
     */
    public static final String DEFAULT_SSO_URL = "https://aip-stg.sktai.io/saml/sso";
}
