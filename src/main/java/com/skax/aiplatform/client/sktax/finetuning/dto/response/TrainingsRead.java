package com.skax.aiplatform.client.sktax.finetuning.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.skax.aiplatform.client.sktax.finetuning.dto.Payload;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Training 목록 조회 응답 DTO
 * 훈련 목록 조회 결과를 반환합니다.
 *
 * @author ByounggwanLee
 * @since 2025-01-01
 * @version 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TrainingsRead {

    /**
     * Training 목록
     */
    @JsonProperty("data")
    private List<TrainingRead> data;

    /**
     * 페이지네이션 정보
     */
    @JsonProperty("payload")
    private Payload payload;
}
