package com.skax.aiplatform.client.sktax.resource.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Task 할당량 정보
 * 
 * <p>Task의 할당량 및 사용량 정보를 정의합니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-08-02
 * @version 1.0
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Task 할당량 정보")
public class TaskQuota {

    /**
     * 할당량
     */
    @JsonProperty("quota")
    @Schema(description = "할당량", example = "2")
    private Integer quota;

    /**
     * 사용량
     */
    @JsonProperty("used")
    @Schema(description = "사용량", example = "0")
    private Integer used;
}
