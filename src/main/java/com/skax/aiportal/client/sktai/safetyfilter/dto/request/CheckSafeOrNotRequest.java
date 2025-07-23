package com.skax.aiportal.client.sktai.safetyfilter.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 안전성 검사 요청 DTO
 * 
 * <p>SKT AI Safety Filter 플랫폼에서 특정 발화의 안전성을 검사하기 위한 요청 정보를 담는 객체입니다.
 * 유해 콘텐츠, 부적절한 표현 등을 탐지합니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-07-23
 * @version 1.0
 */
@Schema(
    title = "안전성 검사 요청",
    description = "SKT AI Safety Filter 플랫폼에서 텍스트의 안전성을 검사하기 위한 요청 정보"
)
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CheckSafeOrNotRequest {

    /**
     * 검사할 발화 (필수)
     * 
     * <p>안전성을 검사할 텍스트 내용입니다. 유해 콘텐츠, 욕설, 차별적 표현 등이 포함되어 있는지 검사됩니다.</p>
     */
    @Schema(
        description = "안전성 검사 대상 텍스트",
        example = "안녕하세요. 오늘 날씨가 좋네요.",
        requiredMode = Schema.RequiredMode.REQUIRED,
        maxLength = 5000
    )
    @NotBlank(message = "검사할 발화는 필수입니다.")
    @Size(max = 5000, message = "검사할 발화는 5000자를 초과할 수 없습니다.")
    @JsonProperty("utterance")
    private String utterance;
}
