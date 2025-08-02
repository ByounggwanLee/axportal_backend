package com.skax.aiplatform.client.sktax.resource.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Task 할당량 기본 정보
 * 
 * <p>Task별 할당량 기본 설정을 정의합니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-08-02
 * @version 1.0
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Task 할당량 기본 정보")
public class TaskQuotaBase {

    /**
     * Task 타입
     */
    @JsonProperty("task_type")
    @Schema(description = "Task 타입", example = "finetuning")
    private String taskType;

    /**
     * 할당량
     */
    @JsonProperty("quota")
    @Builder.Default
    @Schema(description = "할당량", example = "4", defaultValue = "0")
    private Integer quota = 0;
}
