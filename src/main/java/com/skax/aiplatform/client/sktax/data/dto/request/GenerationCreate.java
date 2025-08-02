package com.skax.aiplatform.client.sktax.data.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.skax.aiplatform.client.sktax.data.dto.PolicyPayload;
import com.skax.aiplatform.client.sktax.data.dto.GenerationStatusEnum;
import com.skax.aiplatform.client.sktax.data.dto.GenerationTypeEnum;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Generation 생성 요청 DTO
 * 
 * <p>새로운 데이터 생성을 위한 요청 데이터 모델입니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-08-02
 * @version 1.0
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GenerationCreate {

    /**
     * 프로젝트 ID
     */
    @JsonProperty("project_id")
    private String projectId;

    /**
     * 설명
     */
    @JsonProperty("description")
    private String description;

    /**
     * 상태 (기본값: initialized)
     */
    @JsonProperty("status")
    @Builder.Default
    private GenerationStatusEnum status = GenerationStatusEnum.INITIALIZED;

    /**
     * 이전 상태
     */
    @JsonProperty("prevstatus")
    private GenerationStatusEnum prevstatus;

    /**
     * 진행률
     */
    @JsonProperty("progress")
    private Object progress;

    /**
     * 태스크 ID
     */
    @JsonProperty("task_id")
    private String taskId;

    /**
     * 데이터소스 ID
     */
    @JsonProperty("datasource_id")
    private String datasourceId;

    /**
     * 모델 ID
     */
    @JsonProperty("model_id")
    private String modelId;

    /**
     * 환경 설정
     */
    @JsonProperty("envs")
    private Object envs;

    /**
     * 파라미터
     */
    @JsonProperty("params")
    private String params;

    /**
     * 생성명 (필수)
     */
    @JsonProperty("name")
    private String name;

    /**
     * 태스크 타입 (필수)
     */
    @JsonProperty("task_type")
    private GenerationTypeEnum taskType;

    /**
     * 생성기 ID (필수)
     */
    @JsonProperty("generator_id")
    private String generatorId;

    /**
     * 생성한 사용자
     */
    @JsonProperty("created_by")
    private String createdBy;

    /**
     * 정책
     */
    @JsonProperty("policy")
    private PolicyPayload policy;
}
