package com.skax.aiportal.client.sktai.data.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import jakarta.validation.constraints.NotBlank;

/**
 * 데이터 프로세서 생성 요청 DTO
 * 
 * <p>SKT AI 플랫폼에서 새로운 데이터 프로세서를 생성할 때 사용하는 요청 데이터입니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-07-19
 * @version 1.0
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProcessorCreateRequest {

    /**
     * 프로세서 이름
     */
    private String name;

    /**
     * 프로세서 설명
     */
    private String description;

    /**
     * 규칙 패턴
     */
    @JsonProperty("rule_pattern")
    private String rulePattern;

    /**
     * 규칙 값
     */
    @JsonProperty("rule_value")
    private String ruleValue;

    /**
     * 코드
     */
    private String code;

    /**
     * 데이터 타입 (dataframe, text, all)
     */
    @NotBlank(message = "데이터 타입은 필수입니다")
    @JsonProperty("data_type")
    private String dataType;

    /**
     * 프로세서 타입 (default, rule, code)
     */
    @NotBlank(message = "프로세서 타입은 필수입니다")
    private String type;

    /**
     * 정책 페이로드
     */
    private Object policy;
}
