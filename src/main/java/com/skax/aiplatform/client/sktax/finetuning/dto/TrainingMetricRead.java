package com.skax.aiplatform.client.sktax.finetuning.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Training Metric 조회 DTO
 * 훈련 메트릭 정보를 정의합니다.
 *
 * @author ByounggwanLee
 * @since 2025-01-01
 * @version 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TrainingMetricRead {

    /**
     * 스텝
     */
    @JsonProperty("step")
    private Integer step;

    /**
     * 손실값
     */
    @JsonProperty("loss")
    private Double loss;

    /**
     * 커스텀 메트릭
     */
    @JsonProperty("custom_metric")
    private Object customMetric;

    /**
     * ID
     */
    @JsonProperty("id")
    private UUID id;

    /**
     * 생성일시
     */
    @JsonProperty("created_at")
    private LocalDateTime createdAt;

    /**
     * 수정일시
     */
    @JsonProperty("updated_at")
    private LocalDateTime updatedAt;
}
