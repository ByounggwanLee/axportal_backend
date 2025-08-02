package com.skax.aiplatform.client.sktax.resource.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Task 할당량 공개 정보
 * 
 * <p>Task별 할당량 및 사용량 정보를 포함합니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-08-02
 * @version 1.0
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Task 할당량 공개 정보")
public class TaskQuotaPublic {

    /**
     * 전체 GPU 수
     */
    @JsonProperty("gpu_total")
    @Schema(description = "전체 GPU 수", example = "16", required = true)
    private Integer gpuTotal;

    /**
     * Task 할당량 목록
     */
    @JsonProperty("task_quota")
    @Valid
    @Schema(description = "Task 할당량 상세 정보", required = true)
    private List<TaskQuotaBase> taskQuota;

    /**
     * Task 사용량 목록
     */
    @JsonProperty("task_used")
    @Valid
    @Schema(description = "Task 사용량 목록", required = true)
    private List<TaskUsage> taskUsed;
}
