package com.skax.aiportal.client.sktai.data.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * 작업 상태 열거형
 * 
 * <p>SKT AI 플랫폼의 작업 상태를 정의합니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-07-19
 * @version 1.0
 */
@Getter
@RequiredArgsConstructor
public enum TaskStatusEnum {

    /**
     * 대기중
     */
    PENDING("pending", "대기중"),

    /**
     * 진행중
     */
    IN_PROGRESS("in_progress", "진행중"),

    /**
     * 완료
     */
    COMPLETED("completed", "완료"),

    /**
     * 실패
     */
    FAILED("failed", "실패");

    private final String code;
    private final String description;

    /**
     * 코드로 TaskStatusEnum을 찾습니다.
     * 
     * @param code 상태 코드
     * @return TaskStatusEnum
     */
    public static TaskStatusEnum fromCode(String code) {
        for (TaskStatusEnum status : values()) {
            if (status.getCode().equals(code)) {
                return status;
            }
        }
        throw new IllegalArgumentException("Unknown task status code: " + code);
    }
}
