package com.skax.aiplatform.client.sktax.finetuning.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.skax.aiplatform.client.sktax.finetuning.dto.TrainingEventBase;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Training 이벤트 조회 응답 DTO
 * 훈련 이벤트 조회 결과를 반환합니다.
 *
 * @author ByounggwanLee
 * @since 2025-01-01
 * @version 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TrainingEventsRead {

    /**
     * 이벤트 목록
     */
    @JsonProperty("data")
    private List<TrainingEventBase> data;

    /**
     * 마지막 이벤트 식별자
     */
    @JsonProperty("last")
    private String last;
}
