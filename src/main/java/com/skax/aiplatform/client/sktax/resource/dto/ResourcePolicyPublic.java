package com.skax.aiplatform.client.sktax.resource.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 리소스 정책 공개 정보
 * 
 * <p>Task별 리소스 정책 설정 정보를 정의합니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-08-02
 * @version 1.0
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "리소스 정책 공개 정보")
public class ResourcePolicyPublic {

    /**
     * Task 타입
     */
    @JsonProperty("task_type")
    @Schema(description = "Task 타입", example = "finetuning", allowableValues = {"finetuning", "serving", "evaluation", "knowledge"})
    private String taskType;

    /**
     * 리소스 크기
     */
    @JsonProperty("size")
    @Schema(description = "리소스 크기", example = "small", allowableValues = {"small", "medium", "large", "max"})
    private String size;

    /**
     * CPU 할당량
     */
    @JsonProperty("cpu")
    @Schema(description = "CPU 할당량", example = "4")
    private Integer cpu;

    /**
     * 메모리 할당량
     */
    @JsonProperty("memory")
    @Schema(description = "메모리 할당량 (GB)", example = "8")
    private Integer memory;

    /**
     * GPU 할당량
     */
    @JsonProperty("gpu")
    @Schema(description = "GPU 할당량", example = "1")
    private Integer gpu;
}
