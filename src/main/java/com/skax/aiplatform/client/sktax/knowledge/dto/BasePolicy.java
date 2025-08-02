package com.skax.aiplatform.client.sktax.knowledge.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 기본 정책 정보 DTO
 * 
 * @author ByounggwanLee
 * @since 2025-01-01
 * @version 1.0
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
     * 로직 (NEGATIVE 또는 POSITIVE)
     */
    @JsonProperty("logic")
    private String logic;

    /**
     * 정책 이름 목록
     */
    @JsonProperty("names")
    private List<String> names;
}
