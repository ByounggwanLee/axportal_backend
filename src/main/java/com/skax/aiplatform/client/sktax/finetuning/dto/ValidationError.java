package com.skax.aiplatform.client.sktax.finetuning.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 검증 오류 DTO
 * Fine-tuning API의 검증 오류 상세 정보를 정의합니다.
 *
 * @author ByounggwanLee
 * @since 2025-01-01
 * @version 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ValidationError {

    /**
     * 오류 위치
     */
    @JsonProperty("loc")
    private List<Object> loc;

    /**
     * 오류 메시지
     */
    @JsonProperty("msg")
    private String msg;

    /**
     * 오류 타입
     */
    @JsonProperty("type")
    private String type;
}
