package com.skax.aiplatform.client.sktax.resource.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Task 사용량 정보
 * 
 * <p>Task별 리소스 사용량을 정의합니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-08-02
 * @version 1.0
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Task 사용량 정보")
public class TaskUsage {

    /**
     * Task 타입
     */
    @JsonProperty("task_type")
    @Schema(description = "Task 타입", example = "finetuning", allowableValues = {"finetuning", "serving", "evaluation", "knowledge"}, required = true)
    private String taskType;

    /**
     * 사용된 GPU 수
     */
    @JsonProperty("used")
    @Schema(description = "사용된 GPU 수", example = "1", required = true)
    private Integer used;
}
