package com.skax.aiportal.client.sktai.data.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * 프로세서 데이터 타입 열거형
 * 
 * <p>SKT AI 플랫폼의 프로세서가 처리하는 데이터 타입을 정의합니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-07-19
 * @version 1.0
 */
@Getter
@RequiredArgsConstructor
public enum ProcessorDataTypeEnum {

    /**
     * 데이터프레임
     */
    DATAFRAME("dataframe", "데이터프레임"),

    /**
     * 텍스트
     */
    TEXT("text", "텍스트"),

    /**
     * 전체
     */
    ALL("all", "전체");

    private final String code;
    private final String description;

    /**
     * 코드로 ProcessorDataTypeEnum을 찾습니다.
     * 
     * @param code 프로세서 데이터 타입 코드
     * @return ProcessorDataTypeEnum
     */
    public static ProcessorDataTypeEnum fromCode(String code) {
        for (ProcessorDataTypeEnum type : values()) {
            if (type.getCode().equals(code)) {
                return type;
            }
        }
        throw new IllegalArgumentException("Unknown processor data type code: " + code);
    }
}
