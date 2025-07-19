package com.skax.aiportal.client.sktai.data.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * 생성 작업 응답 DTO
 * 
 * <p>SKT AI 플랫폼에서 데이터 생성 작업 정보를 반환할 때 사용하는 응답 데이터입니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-07-19
 * @version 1.0
 */
@Getter
@NoArgsConstructor
public class GenerationResponse {

    /**
     * 생성 작업 ID
     */
    private String id;

    /**
     * 프로젝트 ID
     */
    @JsonProperty("project_id")
    private String projectId;

    /**
     * 생성 작업 이름
     */
    private String name;

    /**
     * 생성 작업 설명
     */
    private String description;

    /**
     * 생성 작업 상태
     */
    private String status;

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
     * 작업 타입
     */
    @JsonProperty("task_type")
    private String taskType;

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
     * 생성기 ID
     */
    @JsonProperty("generator_id")
    private String generatorId;

    /**
     * 삭제 여부
     */
    @JsonProperty("is_deleted")
    private Boolean isDeleted;

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
