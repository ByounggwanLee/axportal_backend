package com.skax.aiportal.client.sktai.data.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * 생성 상태 열거형
 * 
 * <p>SKT AI 플랫폼의 생성 작업 상태를 정의합니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-07-19
 * @version 1.0
 */
@Getter
@RequiredArgsConstructor
public enum GenerationStatusEnum {

    /**
     * 초기화됨
     */
    INITIALIZED("initialized", "초기화됨"),

    /**
     * 시작중
     */
    STARTING("starting", "시작중"),

    /**
     * 시작됨
     */
    STARTED("started", "시작됨"),

    /**
     * 중지중
     */
    STOPPING("stopping", "중지중"),

    /**
     * 중지됨
     */
    STOPPED("stopped", "중지됨"),

    /**
     * 오류
     */
    ERROR("error", "오류"),

    /**
     * 완료됨
     */
    COMPLETED("completed", "완료됨");

    private final String code;
    private final String description;

    /**
     * 코드로 GenerationStatusEnum을 찾습니다.
     * 
     * @param code 생성 상태 코드
     * @return GenerationStatusEnum
     */
    public static GenerationStatusEnum fromCode(String code) {
        for (GenerationStatusEnum status : values()) {
            if (status.getCode().equals(code)) {
                return status;
            }
        }
        throw new IllegalArgumentException("Unknown generation status code: " + code);
    }
}
