package com.skax.aiportal.client.sktai.safetyfilter.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 유효 태그 타입 열거형
 * 
 * <p>SKT AI 안전 필터에서 사용되는 형태소 분석 태그 타입을 정의합니다.
 * 텍스트 필터링 시 어떤 품사를 대상으로 할지 결정하는 데 사용됩니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-07-23
 * @version 1.0
 */
@Schema(
    title = "유효 태그 타입",
    description = "안전 필터링에서 사용할 형태소 분석 태그 타입"
)
@Getter
@AllArgsConstructor
public enum ValidTagType {

    /**
     * 모든 형태소 매칭
     * 
     * <p>모든 품사를 대상으로 필터링을 수행합니다.</p>
     */
    @Schema(description = "모든 형태소 - 모든 품사를 대상으로 필터링")
    @JsonProperty("ALL")
    ALL("ALL"),

    /**
     * 명사만 매칭
     * 
     * <p>명사 품사만을 대상으로 필터링을 수행합니다.</p>
     */
    @Schema(description = "명사만 - 명사 품사만을 대상으로 필터링")
    @JsonProperty("NN")
    NN("NN");

    /**
     * 태그 값
     */
    @Schema(description = "태그 타입 값", example = "ALL")
    private final String value;
}
