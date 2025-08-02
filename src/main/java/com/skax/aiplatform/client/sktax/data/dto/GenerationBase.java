package com.skax.aiplatform.client.sktax.data.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Generation 기본 DTO
 * 
 * <p>데이터 생성의 기본 정보를 담는 데이터 모델입니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-08-02
 * @version 1.0
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GenerationBase {

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
}
