package com.skax.aiplatform.client.sktax.finetuning.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.skax.aiplatform.client.sktax.finetuning.dto.Payload;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Trainer 목록 조회 응답 DTO
 * 트레이너 목록 조회 결과를 반환합니다.
 *
 * @author ByounggwanLee
 * @since 2025-01-01
 * @version 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TrainersRead {

    /**
     * Trainer 목록
     */
    @JsonProperty("data")
    private List<TrainerRead> data;

    /**
     * 페이지네이션 정보
     */
    @JsonProperty("payload")
    private Payload payload;
}
