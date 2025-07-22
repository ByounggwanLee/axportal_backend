package com.skax.aiportal.client.sktai.safetyfilter.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 기본 정책 클래스
 * 
 * 안전 필터의 접근 제어를 위한 정책 정보를 담습니다.
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BasePolicy {

    /**
     * 정책 타입
     */
    @JsonProperty("type")
    private PolicyType type;

    /**
     * 논리 연산자
     */
    @JsonProperty("logic")
    private PolicyLogic logic;

    /**
     * 이름 목록
     */
    @JsonProperty("names")
    private String[] names;

    /**
     * 정책 타입 열거형
     */
    public enum PolicyType {
        @JsonProperty("user")
        USER,
        @JsonProperty("group")
        GROUP,
        @JsonProperty("role")
        ROLE,
        @JsonProperty("token-exchange")
        TOKEN_EXCHANGE
    }

    /**
     * 정책 논리 열거형
     */
    public enum PolicyLogic {
        @JsonProperty("NEGATIVE")
        NEGATIVE,
        @JsonProperty("POSITIVE")
        POSITIVE
    }
}
