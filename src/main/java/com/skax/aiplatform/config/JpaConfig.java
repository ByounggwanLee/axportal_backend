package com.skax.aiplatform.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Optional;

/**
 * JPA 설정
 * 
 * <p>JPA Auditing 설정과 데이터베이스 관련 설정을 담당합니다.
 * 엔티티의 생성자/수정자 자동 설정 기능을 포함합니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-08-01
 * @version 1.0.0
 */
@Configuration
@EnableJpaAuditing(auditorAwareRef = "auditorProvider")
public class JpaConfig {

    /**
     * JPA Auditing용 사용자 정보 제공자
     * 
     * <p>현재 인증된 사용자의 정보를 엔티티의 생성자/수정자 필드에 자동으로 설정합니다.
     * Spring Security Context에서 현재 사용자 정보를 가져옵니다.</p>
     * 
     * @return AuditorAware 구현체
     */
    @Bean
    public AuditorAware<String> auditorProvider() {
        return new AuditorAwareImpl();
    }

    /**
     * AuditorAware 구현 클래스
     */
    private static class AuditorAwareImpl implements AuditorAware<String> {

        @Override
        public Optional<String> getCurrentAuditor() {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            
            // 인증되지 않은 경우 또는 익명 사용자인 경우
            if (authentication == null || 
                !authentication.isAuthenticated() || 
                "anonymousUser".equals(authentication.getPrincipal())) {
                return Optional.of("system");
            }
            
            // 인증된 사용자의 경우
            Object principal = authentication.getPrincipal();
            if (principal instanceof String) {
                return Optional.of((String) principal);
            }
            
            // UserDetails 구현체인 경우 (향후 User 엔티티 구현 시)
            // if (principal instanceof UserDetails) {
            //     return Optional.of(((UserDetails) principal).getUsername());
            // }
            
            // 기본값
            return Optional.of("system");
        }
    }
}
