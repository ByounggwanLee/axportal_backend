package com.skax.aiportal.client.sktai.data.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * 작업 상태 열거형
 * 
 * <p>SKT AI 플랫폼의 작업 상태를 정의합니다.
 * 데이터 처리, 모델 학습 등 다양한 작업의 진행 상태를 나타냅니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-07-19
 * @version 1.0
 */
@Schema(
    title = "작업 상태",
    description = "SKT AI 플랫폼의 작업 진행 상태"
)
@Getter
@RequiredArgsConstructor
public enum TaskStatusEnum {

    /**
     * 대기중 상태
     * 
     * <p>작업이 대기열에 등록된 상태입니다.</p>
     */
    @Schema(description = "대기중 - 작업이 대기열에 등록된 상태")
    PENDING("pending", "대기중"),

    /**
     * 진행중 상태
     * 
     * <p>작업이 현재 처리되고 있는 상태입니다.</p>
     */
    @Schema(description = "진행중 - 작업이 현재 처리되고 있는 상태")
    IN_PROGRESS("in_progress", "진행중"),

    /**
     * 완료 상태
     * 
     * <p>작업이 성공적으로 완료된 상태입니다.</p>
     */
    @Schema(description = "완료 - 작업이 성공적으로 완료된 상태")
    COMPLETED("completed", "완료"),

    /**
     * 실패 상태
     * 
     * <p>작업 처리 중 오류가 발생하여 실패한 상태입니다.</p>
     */
    @Schema(description = "실패 - 작업 처리 중 오류가 발생한 상태")
    FAILED("failed", "실패");

    /**
     * 상태 코드
     */
    @Schema(description = "상태 코드", example = "pending")
    private final String code;
    
    /**
     * 상태 설명
     */
    @Schema(description = "상태 설명", example = "대기중")
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
