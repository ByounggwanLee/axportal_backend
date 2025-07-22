package com.skax.aiportal.client.sktai.safetyfilter.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 유효 태그 타입 열거형
 * 
 * 안전 필터의 유효 태그 타입을 정의합니다.
 */
@Getter
@AllArgsConstructor
public enum ValidTagType {

    /**
     * 모든 형태소 매칭
     */
    @JsonProperty("ALL")
    ALL("ALL"),

    /**
     * 명사만 매칭
     */
    @JsonProperty("NN")
    NN("NN");

    private final String value;
}
