package com.skax.aiportal.config;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;
import java.util.List;

/**
 * Spring Security 설정 클래스
 * 
 * <p>애플리케이션의 보안 설정을 담당합니다.
 * CORS, 인증, 인가 등의 보안 정책을 정의합니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-07-19
 * @version 1.0
 */
@Slf4j
@Configuration
@EnableWebSecurity
@EnableMethodSecurity(prePostEnabled = true)
@Tag(name = "보안 설정", description = "Spring Security 보안 설정 관리")
public class SecurityConfig {

    /**
     * 비밀번호 암호화를 위한 BCryptPasswordEncoder를 빈으로 등록합니다.
     * 
     * @return BCryptPasswordEncoder 인스턴스
     */
    @Bean
    @Operation(summary = "비밀번호 암호화 빈 등록", description = "BCryptPasswordEncoder를 Spring 빈으로 등록합니다.")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "비밀번호 암호화 빈 등록 성공")
    })
    public PasswordEncoder passwordEncoder() {
        log.info("비밀번호 암호화 빈 등록 시작 - BCryptPasswordEncoder 생성");
        PasswordEncoder encoder = new BCryptPasswordEncoder();
        log.debug("BCryptPasswordEncoder 인스턴스 생성 완료: {}", encoder.getClass().getSimpleName());
        log.info("비밀번호 암호화 빈 등록 완료");
        return encoder;
    }

    /**
     * HTTP 보안 설정을 정의합니다.
     * 
     * @param http HttpSecurity 객체
     * @return SecurityFilterChain
     * @throws Exception 설정 중 발생할 수 있는 예외
     */
    @Bean
    @Operation(summary = "HTTP 보안 필터 체인 설정", description = "Spring Security의 HTTP 보안 설정을 정의합니다.")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "보안 필터 체인 설정 성공"),
        @ApiResponse(responseCode = "500", description = "보안 설정 중 오류 발생")
    })
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        log.info("HTTP 보안 필터 체인 설정 시작");
        
        log.debug("CSRF 보호 비활성화 설정 중 - API 서버 특성으로 인한 비활성화");
        http
                // CSRF 보호 비활성화 (API 서버이므로)
                .csrf(AbstractHttpConfigurer::disable);
        
        log.debug("CORS 설정 적용 중 - corsConfigurationSource() 메서드 사용");        
        http
                // CORS 설정 적용
                .cors(cors -> cors.configurationSource(corsConfigurationSource()));
        
        log.debug("프레임 옵션 설정 중 - H2 콘솔 접근을 위한 SAMEORIGIN 허용");
        http
                // 프레임 옵션 설정 (H2 콘솔을 위해 SAMEORIGIN 허용)
                .headers(headers -> headers
                        .frameOptions(HeadersConfigurer.FrameOptionsConfig::sameOrigin));
        
        log.debug("세션 정책 설정 중 - STATELESS 정책 적용");
        http
                // 세션 정책 설정 (Stateless)
                .sessionManagement(session -> session
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS));
        
        log.debug("URL별 접근 권한 설정 중");
        http
                // URL별 접근 권한 설정
                .authorizeHttpRequests(auth -> {
                    log.debug("공개 엔드포인트 설정: API 문서, H2 콘솔, 인증 관련 URL 허용");
                    auth
                        // 공개 엔드포인트
                        .requestMatchers(
                                "/v3/api-docs/**",
                                "/swagger-ui/**",
                                "/swagger-ui.html",
                                "/h2-console/**",
                                "/actuator/health",
                                "/auth/login",
                                "/auth/register",
                                "/**"
                        ).permitAll();
                    
                    log.debug("나머지 요청에 대한 인증 필수 설정");
                    auth
                        // 나머지 요청은 인증 필요
                        .anyRequest().authenticated();
                });

        SecurityFilterChain filterChain = http.build();
        log.info("HTTP 보안 필터 체인 설정 완료 - 필터 체인 개수: {}", 
                filterChain.getFilters().size());
        log.debug("설정된 필터들: {}", 
                filterChain.getFilters().stream()
                    .map(filter -> filter.getClass().getSimpleName())
                    .toList());
        
        return filterChain;
    }

    /**
     * CORS 설정을 정의합니다.
     * 
     * @return CorsConfigurationSource
     */
    @Bean
    @Operation(summary = "CORS 설정 정의", description = "Cross-Origin Resource Sharing 정책을 설정합니다.")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "CORS 설정 성공")
    })
    public CorsConfigurationSource corsConfigurationSource() {
        log.info("CORS 설정 시작");
        
        CorsConfiguration configuration = new CorsConfiguration();
        
        log.debug("허용할 오리진 패턴 설정 중: 모든 오리진 허용");
        // 허용할 오리진 설정
        configuration.setAllowedOriginPatterns(List.of("*"));
        
        log.debug("허용할 HTTP 메서드 설정 중: GET, POST, PUT, DELETE, PATCH, OPTIONS");
        // 허용할 HTTP 메서드 설정
        List<String> allowedMethods = Arrays.asList(
                "GET", "POST", "PUT", "DELETE", "PATCH", "OPTIONS"
        );
        configuration.setAllowedMethods(allowedMethods);
        log.debug("설정된 HTTP 메서드: {}", allowedMethods);
        
        log.debug("허용할 헤더 설정 중: 모든 헤더 허용");
        // 허용할 헤더 설정
        configuration.setAllowedHeaders(List.of("*"));
        
        log.debug("인증 정보 포함 여부 설정 중: true");
        // 인증 정보 포함 여부
        configuration.setAllowCredentials(true);
        
        log.debug("preflight 요청 캐시 시간 설정 중: 3600초");
        // preflight 요청 캐시 시간 설정
        configuration.setMaxAge(3600L);

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        
        log.info("CORS 설정 완료 - 모든 경로에 대해 CORS 정책 적용");
        log.debug("CORS 설정 상세 정보:");
        log.debug("  - 허용 오리진: {}", configuration.getAllowedOriginPatterns());
        log.debug("  - 허용 메서드: {}", configuration.getAllowedMethods());
        log.debug("  - 인증 정보 포함: {}", configuration.getAllowCredentials());
        log.debug("  - 캐시 시간: {}초", configuration.getMaxAge());
        
        return source;
    }
}
