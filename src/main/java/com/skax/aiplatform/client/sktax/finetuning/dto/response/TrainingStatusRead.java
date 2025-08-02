package com.skax.aiplatform.client.sktax.finetuning.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.skax.aiplatform.client.sktax.finetuning.dto.TrainingStatusEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Training 상태 조회 응답 DTO
 * 훈련 상태 조회 결과를 반환합니다.
 *
 * @author ByounggwanLee
 * @since 2025-01-01
 * @version 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TrainingStatusRead {

    /**
     * 현재 상태
     */
    @JsonProperty("status")
    private TrainingStatusEnum status;

    /**
     * 이전 상태
     */
    @JsonProperty("prev_status")
    private TrainingStatusEnum prevStatus;
}
