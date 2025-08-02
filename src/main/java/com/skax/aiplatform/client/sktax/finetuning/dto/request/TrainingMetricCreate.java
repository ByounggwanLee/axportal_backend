package com.skax.aiplatform.client.sktax.finetuning.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.skax.aiplatform.client.sktax.finetuning.dto.TrainingMetricTypeEnum;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Training Metric 생성 요청 DTO
 * 훈련 메트릭을 생성하기 위한 요청 데이터입니다.
 *
 * @author ByounggwanLee
 * @since 2025-01-01
 * @version 1.0
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TrainingMetricCreate {

    /**
     * 스텝
     */
    @JsonProperty("step")
    @NotNull(message = "스텝은 필수입니다")
    private Integer step;

    /**
     * 손실값
     */
    @JsonProperty("loss")
    @NotNull(message = "손실값은 필수입니다")
    private Double loss;

    /**
     * 커스텀 메트릭
     * 추적하고자 하는 커스텀 메트릭을 입력합니다.
     */
    @JsonProperty("custom_metric")
    @NotNull(message = "커스텀 메트릭은 필수입니다")
    private Object customMetric;

    /**
     * 메트릭 타입
     */
    @JsonProperty("type")
    @NotNull(message = "메트릭 타입은 필수입니다")
    private TrainingMetricTypeEnum type;
}
