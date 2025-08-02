package com.skax.aiplatform.client.sktax.resource.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Task 정책 정보
 * 
 * <p>Task별 리소스 정책 설정을 정의합니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-08-02
 * @version 1.0
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Task 정책 정보")
public class TaskPolicy {

    /**
     * Small 크기 정책
     */
    @JsonProperty("small")
    @Schema(description = "Small 크기 정책")
    private TaskPolicySize small;

    /**
     * Medium 크기 정책
     */
    @JsonProperty("medium")
    @Schema(description = "Medium 크기 정책")
    private TaskPolicySize medium;

    /**
     * Large 크기 정책
     */
    @JsonProperty("large")
    @Schema(description = "Large 크기 정책")
    private TaskPolicySize large;

    /**
     * Max 크기 정책
     */
    @JsonProperty("max")
    @Schema(description = "Max 크기 정책")
    private TaskPolicySize max;
}
