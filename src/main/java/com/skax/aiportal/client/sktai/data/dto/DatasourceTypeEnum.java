package com.skax.aiportal.client.sktai.data.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * 데이터소스 타입 열거형
 * 
 * <p>SKT AI 플랫폼의 데이터소스 타입을 정의합니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-07-19
 * @version 1.0
 */
@Getter
@RequiredArgsConstructor
public enum DatasourceTypeEnum {

    /**
     * 파일
     */
    FILE("file", "파일"),

    /**
     * 데이터베이스
     */
    DATABASE("database", "데이터베이스"),

    /**
     * S3
     */
    S3("s3", "S3");

    private final String code;
    private final String description;

    /**
     * 코드로 DatasourceTypeEnum을 찾습니다.
     * 
     * @param code 데이터소스 타입 코드
     * @return DatasourceTypeEnum
     */
    public static DatasourceTypeEnum fromCode(String code) {
        for (DatasourceTypeEnum type : values()) {
            if (type.getCode().equals(code)) {
                return type;
            }
        }
        throw new IllegalArgumentException("Unknown datasource type code: " + code);
    }
}
