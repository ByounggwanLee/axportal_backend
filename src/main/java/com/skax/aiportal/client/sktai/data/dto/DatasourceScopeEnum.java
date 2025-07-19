package com.skax.aiportal.client.sktai.data.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * 데이터소스 범위 열거형
 * 
 * <p>SKT AI 플랫폼의 데이터소스 접근 범위를 정의합니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-07-19
 * @version 1.0
 */
@Getter
@RequiredArgsConstructor
public enum DatasourceScopeEnum {

    /**
     * 공개
     */
    PUBLIC("public", "공개"),

    /**
     * 비공개
     */
    PRIVATE("private", "비공개");

    private final String code;
    private final String description;

    /**
     * 코드로 DatasourceScopeEnum을 찾습니다.
     * 
     * @param code 데이터소스 범위 코드
     * @return DatasourceScopeEnum
     */
    public static DatasourceScopeEnum fromCode(String code) {
        for (DatasourceScopeEnum scope : values()) {
            if (scope.getCode().equals(code)) {
                return scope;
            }
        }
        throw new IllegalArgumentException("Unknown datasource scope code: " + code);
    }
}
