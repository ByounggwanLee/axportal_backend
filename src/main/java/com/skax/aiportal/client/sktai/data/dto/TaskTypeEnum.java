package com.skax.aiportal.client.sktai.data.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * 작업 타입 열거형
 * 
 * <p>SKT AI 플랫폼의 작업 타입을 정의합니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-07-19
 * @version 1.0
 */
@Getter
@RequiredArgsConstructor
public enum TaskTypeEnum {

    /**
     * 파일 생성
     */
    FILE_CREATE("file_create", "파일 생성"),

    /**
     * 파일 업데이트
     */
    FILE_UPDATE("file_update", "파일 업데이트"),

    /**
     * S3 생성
     */
    S3_CREATE("s3_create", "S3 생성"),

    /**
     * S3 업데이트
     */
    S3_UPDATE("s3_update", "S3 업데이트");

    private final String code;
    private final String description;

    /**
     * 코드로 TaskTypeEnum을 찾습니다.
     * 
     * @param code 작업 타입 코드
     * @return TaskTypeEnum
     */
    public static TaskTypeEnum fromCode(String code) {
        for (TaskTypeEnum type : values()) {
            if (type.getCode().equals(code)) {
                return type;
            }
        }
        throw new IllegalArgumentException("Unknown task type code: " + code);
    }
}
