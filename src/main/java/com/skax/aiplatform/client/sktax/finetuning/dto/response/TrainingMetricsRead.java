package com.skax.aiplatform.client.sktax.finetuning.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.skax.aiplatform.client.sktax.finetuning.dto.Payload;
import com.skax.aiplatform.client.sktax.finetuning.dto.TrainingMetricRead;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Training 메트릭 목록 조회 응답 DTO
 * 훈련 메트릭 목록 조회 결과를 반환합니다.
 *
 * @author ByounggwanLee
 * @since 2025-01-01
 * @version 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TrainingMetricsRead {

    /**
     * Training Metric 목록
     */
    @JsonProperty("data")
    private List<TrainingMetricRead> data;

    /**
     * 페이지네이션 정보
     */
    @JsonProperty("payload")
    private Payload payload;
}
