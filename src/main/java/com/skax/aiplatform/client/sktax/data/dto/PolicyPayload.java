package com.skax.aiplatform.client.sktax.data.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * SKT AX Data API 정책 페이로드
 * 
 * <p>리소스에 대한 접근 권한 정책을 정의합니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-01-21
 * @version 1.0
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PolicyPayload {
    
    /**
     * 스코프 목록 (GET, POST, PUT, DELETE)
     */
    @JsonProperty("scopes")
    private String[] scopes;
    
    /**
     * 정책 목록
     */
    @JsonProperty("policies")
    private BasePolicy[] policies;
    
    /**
     * 로직 타입 (NEGATIVE, POSITIVE)
     */
    @JsonProperty("logic")
    private String logic;
    
    /**
     * 결정 전략 (AFFIRMATIVE, CONSENSUS, UNANIMOUS)
     */
    @JsonProperty("decision_strategy")
    private String decisionStrategy;
}
