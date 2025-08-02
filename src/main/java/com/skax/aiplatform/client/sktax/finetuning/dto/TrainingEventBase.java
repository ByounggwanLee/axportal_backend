package com.skax.aiplatform.client.sktax.finetuning.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Training 이벤트 기본 DTO
 * 훈련 이벤트의 기본 정보를 정의합니다.
 *
 * @author ByounggwanLee
 * @since 2025-01-01
 * @version 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TrainingEventBase {

    /**
     * 시간
     */
    @JsonProperty("time")
    private String time;

    /**
     * 로그
     */
    @JsonProperty("log")
    private String log;
}
