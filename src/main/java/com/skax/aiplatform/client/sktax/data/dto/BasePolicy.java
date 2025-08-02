package com.skax.aiplatform.client.sktax.data.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * SKT AX Data API 기본 정책
 * 
 * <p>정책의 기본 정보를 정의합니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-01-21
 * @version 1.0
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BasePolicy {
    
    /**
     * 정책 타입 (user, group, role, token-exchange)
     */
    @JsonProperty("type")
    private String type;
    
    /**
     * 로직 타입 (NEGATIVE, POSITIVE)
     */
    @JsonProperty("logic")
    private String logic;
    
    /**
     * 정책 대상 이름들
     */
    @JsonProperty("names")
    private String[] names;
}
