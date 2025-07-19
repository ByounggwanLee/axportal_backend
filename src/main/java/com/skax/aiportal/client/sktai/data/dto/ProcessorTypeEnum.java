package com.skax.aiportal.client.sktai.data.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * 프로세서 타입 열거형
 * 
 * <p>SKT AI 플랫폼의 프로세서 타입을 정의합니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-07-19
 * @version 1.0
 */
@Getter
@RequiredArgsConstructor
public enum ProcessorTypeEnum {

    /**
     * 기본
     */
    DEFAULT("default", "기본"),

    /**
     * 규칙
     */
    RULE("rule", "규칙"),

    /**
     * 코드
     */
    CODE("code", "코드");

    private final String code;
    private final String description;

    /**
     * 코드로 ProcessorTypeEnum을 찾습니다.
     * 
     * @param code 프로세서 타입 코드
     * @return ProcessorTypeEnum
     */
    public static ProcessorTypeEnum fromCode(String code) {
        for (ProcessorTypeEnum type : values()) {
            if (type.getCode().equals(code)) {
                return type;
            }
        }
        throw new IllegalArgumentException("Unknown processor type code: " + code);
    }
}
