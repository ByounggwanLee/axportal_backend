package com.skax.aiplatform.client.sktax.data.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * DataProcessor DTO
 * 
 * <p>데이터 프로세서 정보를 담는 데이터 모델입니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-08-02
 * @version 1.0
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DataProcessor {

    /**
     * 프로세서 ID (필수)
     */
    @JsonProperty("id")
    private String id;

    /**
     * 프로젝트 ID
     */
    @JsonProperty("project_id")
    private String projectId;

    /**
     * 프로세서명 (필수)
     */
    @JsonProperty("name")
    private String name;

    /**
     * 설명
     */
    @JsonProperty("description")
    private String description;

    /**
     * 프로세서 타입 (기본값: rule)
     */
    @JsonProperty("type")
    @Builder.Default
    private ProcessorTypeEnum type = ProcessorTypeEnum.RULE;

    /**
     * 데이터 타입 (기본값: all)
     */
    @JsonProperty("data_type")
    @Builder.Default
    private ProcessorDataTypeEnum dataType = ProcessorDataTypeEnum.ALL;

    /**
     * 기본 키
     */
    @JsonProperty("default_key")
    private String defaultKey;

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
     * 생성일시 (필수)
     */
    @JsonProperty("created_at")
    private LocalDateTime createdAt;

    /**
     * 업데이트일시 (필수)
     */
    @JsonProperty("updated_at")
    private LocalDateTime updatedAt;

    /**
     * 생성한 사용자
     */
    @JsonProperty("created_by")
    private String createdBy;

    /**
     * 업데이트한 사용자
     */
    @JsonProperty("updated_by")
    private String updatedBy;
}
