package com.skax.aiplatform.client.sktax.safetyfilter.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 안전성 검사 요청 DTO
 * 지정된 발화에 대한 유해성 판정을 요청합니다.
 *
 * @author ByounggwanLee
 * @since 2025-01-01
 * @version 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CheckSafeOrNot {

    /**
     * 검사할 발화 내용
     */
    @JsonProperty("utterance")
    @NotBlank(message = "발화 내용은 필수입니다")
    private String utterance;
}
