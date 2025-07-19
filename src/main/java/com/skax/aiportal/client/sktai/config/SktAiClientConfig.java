package com.skax.aiportal.client.sktai.config;

import feign.Client;
import feign.Logger;
import feign.RequestInterceptor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

/**
 * SKT AI 클라이언트 설정 클래스
 * 
 * <p>SKT AI API 연동을 위한 Feign Client 설정을 담당합니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-07-19
 * @version 1.0
 */
@Slf4j
@Configuration
public class SktAiClientConfig {

    @Value("${sktai.api.base-url:https://aip-stg.sktai.io}")
    private String baseUrl;

    @Value("${sktai.api.timeout.connect:5000}")
    private int connectTimeout;

    @Value("${sktai.api.timeout.read:30000}")
    private int readTimeout;

    /**
     * Feign 로깅 레벨을 설정합니다.
     * 
     * @return Logger.Level
     */
    @Bean
    public Logger.Level feignLoggerLevel() {
        log.info("SKT AI Feign 로깅 레벨 설정 - FULL");
        return Logger.Level.FULL;
    }

    /**
     * SKT AI API 요청 인터셉터를 설정합니다.
     * 
     * @return RequestInterceptor
     */
    @Bean("sktAiRequestInterceptor")
    public RequestInterceptor sktAiRequestInterceptor() {
        log.info("SKT AI 요청 인터셉터 설정 시작");
        log.debug("기본 URL: {}", baseUrl);
        log.debug("연결 타임아웃: {}ms", connectTimeout);
        log.debug("읽기 타임아웃: {}ms", readTimeout);
        
        return requestTemplate -> {
            log.debug("SKT AI API 요청 인터셉터 실행 - URL: {}", requestTemplate.url());
            
            // 공통 헤더 설정
            requestTemplate.header("Accept", "application/json");
            //-- LBG requestTemplate.header("Content-Type", "application/x-www-form-urlencoded");
            requestTemplate.header("User-Agent", "AXPORTAL-Backend/1.0");
            
            log.debug("공통 헤더 설정 완료 - Accept: application/json, Content-Type: application/x-www-form-urlencoded");
        };
    }

    /**
     * 설정 정보를 반환합니다.
     * 
     * @return SktAiConfig
     */
    @Bean
    public SktAiConfig sktAiConfig() {
        log.info("SKT AI 설정 정보 생성");
        SktAiConfig config = SktAiConfig.builder()
                .baseUrl(baseUrl)
                .connectTimeout(connectTimeout)
                .readTimeout(readTimeout)
                .build();
        
        log.debug("SKT AI 설정 정보: {}", config);
        return config;
    }

    /**
     * SKT AI 설정 정보 클래스
     */
    @lombok.Builder
    @lombok.Getter
    @lombok.ToString
    public static class SktAiConfig {
        private final String baseUrl;
        private final int connectTimeout;
        private final int readTimeout;
    }

    /**
     * 개발/테스트 환경에서 모든 SSL 인증서를 신뢰하는 Feign Client (운영 환경에서는 사용 금지)
     */
    @Bean
    public Client feignClient() {
       try {
            // 개발 환경용 - 모든 SSL 인증서를 신뢰하는 TrustManager
            // 운영 환경에서는 이 설정을 제거하고 적절한 인증서 검증을 사용해야 합니다
            TrustManager[] trustAllCerts = new TrustManager[] {
                new X509TrustManager() {
                    @Override
                    public void checkClientTrusted(X509Certificate[] chain, String authType) 
                            throws CertificateException {
                        // 개발 환경용 - 클라이언트 인증서 검증 생략
                    }

                    @Override
                    public void checkServerTrusted(X509Certificate[] chain, String authType) 
                            throws CertificateException {
                        // 개발 환경용 - 서버 인증서 검증 생략
                        log.debug("SSL 인증서 검증 생략 (개발 환경)");
                    }

                    @Override
                    public X509Certificate[] getAcceptedIssuers() {
                        return new X509Certificate[0];
                    }
                }
            };

            // SSL Context 설정
            SSLContext sslContext = SSLContext.getInstance("SSL");
            sslContext.init(null, trustAllCerts, new java.security.SecureRandom());
            
            SSLSocketFactory sslSocketFactory = sslContext.getSocketFactory();

            log.info("HTTPS 지원 Feign Client가 설정되었습니다.");
            return new Client.Default(sslSocketFactory, (hostname, session) -> true);
            
        } catch (Exception e) {
            log.error("HTTPS Feign Client 설정 중 오류 발생: {}", e.getMessage(), e);
            log.warn("기본 Feign Client를 사용합니다.");
            return new Client.Default(null, null);
        }
    }
}
