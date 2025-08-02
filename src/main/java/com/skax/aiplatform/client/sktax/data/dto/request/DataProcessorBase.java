package com.skax.aiplatform.client.sktax.data.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.skax.aiplatform.client.sktax.data.dto.ProcessorDataTypeEnum;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * DataProcessor 기본 요청 DTO
 * 
 * <p>데이터 프로세서의 기본 정보를 담는 요청 데이터 모델입니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-08-02
 * @version 1.0
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DataProcessorBase {

    /**
     * 프로세서명
     */
    @JsonProperty("name")
    private String name;

    /**
     * 설명
     */
    @JsonProperty("description")
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
    @JsonProperty("code")
    private String code;

    /**
     * 데이터 타입 (필수)
     */
    @JsonProperty("data_type")
    private ProcessorDataTypeEnum dataType;
}
