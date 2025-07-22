package com.skax.aiportal.client.sktai.safetyfilter.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 안전성 검사 요청 DTO
 * 
 * 특정 발화의 안전성을 검사하기 위한 요청 정보를 담습니다.
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CheckSafeOrNotRequest {

    /**
     * 검사할 발화 (필수)
     */
    @NotBlank(message = "발화는 필수입니다")
    @JsonProperty("utterance")
    private String utterance;
}
