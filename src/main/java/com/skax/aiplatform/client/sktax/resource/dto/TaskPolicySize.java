package com.skax.aiplatform.client.sktax.resource.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Task 정책 크기별 설정
 * 
 * <p>Task의 크기별 리소스 할당 정책을 정의합니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-08-02
 * @version 1.0
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Task 정책 크기별 설정")
public class TaskPolicySize {

    /**
     * CPU 할당량
     */
    @JsonProperty("cpu_quota")
    @Schema(description = "CPU 할당량", example = "4")
    private Integer cpuQuota;

    /**
     * 메모리 할당량
     */
    @JsonProperty("mem_quota")
    @Schema(description = "메모리 할당량", example = "8")
    private Integer memQuota;

    /**
     * GPU 할당량
     */
    @JsonProperty("gpu_quota")
    @Schema(description = "GPU 할당량", example = "1")
    private Integer gpuQuota;
}
