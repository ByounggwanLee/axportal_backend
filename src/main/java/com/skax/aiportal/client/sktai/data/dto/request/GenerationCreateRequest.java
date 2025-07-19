package com.skax.aiportal.client.sktai.data.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 생성 작업 생성 요청 DTO
 * 
 * <p>
 * SKT AI 플랫폼에서 새로운 데이터 생성 작업을 만들 때 사용하는 요청 데이터입니다.
 * </p>
 * 
 * @author ByounggwanLee
 * @since 2025-07-19
 * @version 1.0
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GenerationCreateRequest {

    /**
     * 프로젝트 ID
     */
    @JsonProperty("project_id")
    private String projectId;

    /**
     * 생성 작업 설명
     */
    private String description;

    /**
     * 생성 작업 상태
     */
    @Builder.Default
    private String status = "initialized";

    /**
     * 이전 상태
     */
    private String prevstatus;

    /**
     * 진행 상황
     */
    private Object progress;

    /**
     * 작업 ID
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
    private Object envs;

    /**
     * 매개변수
     */
    private String params;

    /**
     * 생성 작업 이름
     */
    @NotBlank(message = "생성 작업 이름은 필수입니다")
    private String name;

    /**
     * 작업 타입
     * openbook_qna, rag_qna, intent_classification, cs_type_classification,
     * emotion_classification, cs_summarization, keyword
     */
    @NotBlank(message = "작업 타입은 필수입니다")
    @JsonProperty("task_type")
    private String taskType;

    /**
     * 생성기 ID
     */
    @NotBlank(message = "생성기 ID는 필수입니다")
    @JsonProperty("generator_id")
    private String generatorId;

    /**
     * 생성자
     */
    @JsonProperty("created_by")
    private String createdBy;

    /**
     * 정책 페이로드
     */
    private Object policy;
}
