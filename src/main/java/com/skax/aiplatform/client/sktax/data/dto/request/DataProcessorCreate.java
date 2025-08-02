package com.skax.aiplatform.client.sktax.data.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.skax.aiplatform.client.sktax.data.dto.PolicyPayload;
import com.skax.aiplatform.client.sktax.data.dto.ProcessorDataTypeEnum;
import com.skax.aiplatform.client.sktax.data.dto.ProcessorTypeEnum;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * DataProcessor 생성 요청 DTO
 * 
 * <p>새로운 데이터 프로세서를 생성하기 위한 요청 데이터 모델입니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-08-02
 * @version 1.0
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DataProcessorCreate {

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

    /**
     * 프로세서 타입 (필수)
     */
    @JsonProperty("type")
    private ProcessorTypeEnum type;

    /**
     * 정책
     */
    @JsonProperty("policy")
    private PolicyPayload policy;
}
