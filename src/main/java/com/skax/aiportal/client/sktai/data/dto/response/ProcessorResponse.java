package com.skax.aiportal.client.sktai.data.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * 데이터 프로세서 응답 DTO
 * 
 * <p>SKT AI 플랫폼에서 데이터 프로세서 정보를 반환할 때 사용하는 응답 데이터입니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-07-19
 * @version 1.0
 */
@Getter
@NoArgsConstructor
public class ProcessorResponse {

    /**
     * 프로세서 ID
     */
    private String id;

    /**
     * 프로젝트 ID
     */
    @JsonProperty("project_id")
    private String projectId;

    /**
     * 프로세서 이름
     */
    private String name;

    /**
     * 프로세서 설명
     */
    private String description;

    /**
     * 프로세서 타입
     */
    private String type;

    /**
     * 데이터 타입
     */
    @JsonProperty("data_type")
    private String dataType;

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
    private String code;

    /**
     * 생성일시
     */
    @JsonProperty("created_at")
    private LocalDateTime createdAt;

    /**
     * 수정일시
     */
    @JsonProperty("updated_at")
    private LocalDateTime updatedAt;

    /**
     * 생성자
     */
    @JsonProperty("created_by")
    private String createdBy;

    /**
     * 수정자
     */
    @JsonProperty("updated_by")
    private String updatedBy;
}
