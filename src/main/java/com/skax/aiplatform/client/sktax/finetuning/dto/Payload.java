package com.skax.aiplatform.client.sktax.finetuning.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 페이로드 DTO
 * Fine-tuning API의 페이로드 래퍼를 정의합니다.
 *
 * @author ByounggwanLee
 * @since 2025-01-01
 * @version 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Payload {

    /**
     * 페이지네이션 정보
     */
    @JsonProperty("pagination")
    private Pagination pagination;
}
