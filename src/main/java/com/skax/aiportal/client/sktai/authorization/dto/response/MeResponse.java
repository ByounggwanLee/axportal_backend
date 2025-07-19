package com.skax.aiportal.client.sktai.authorization.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.ToString;

/**
 * 로그인한 사용자 정보 응답 DTO
 * <p>SKT AI 플랫폼의 사용자 정보 응답을 매핑합니다.</p>
 * @author ByounggwanLee
 * @since 2025-07-19
 * @version 1.0
 */
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class MeResponse {
    private String id;
    private String username;
    private String email;
    private String firstName;
    private String lastName;
    private Boolean enabled;
    private Boolean emailVerified;
    // 필요시 추가 필드 정의
}
