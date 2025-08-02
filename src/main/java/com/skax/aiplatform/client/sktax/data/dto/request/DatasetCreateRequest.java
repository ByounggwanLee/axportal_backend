package com.skax.aiplatform.client.sktax.data.dto.request;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.skax.aiplatform.client.sktax.data.dto.BasePolicyPayload;
import com.skax.aiplatform.client.sktax.data.dto.DatasetTags;
import com.skax.aiplatform.client.sktax.data.dto.ProcessorParam;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 데이터셋 생성 요청 DTO
 * 
 * @author ByounggwanLee
 * @since 2025-08-02
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DatasetCreateRequest {

    /**
     * 데이터셋 이름
     */
    @JsonProperty("name")
    private String name;

    /**
     * 데이터셋 타입
     * unsupervised_finetuning, supervised_finetuning, model_benchmark, rag_evaluation
     */
    @JsonProperty("type")
    private String type;

    /**
     * 데이터셋 설명
     */
    @JsonProperty("description")
    private String description;

    /**
     * 데이터셋 태그 목록
     */
    @JsonProperty("tags")
    private List<DatasetTags> tags;

    /**
     * 데이터셋 상태
     */
    @JsonProperty("status")
    private String status;

    /**
     * 프로젝트 ID
     */
    @JsonProperty("project_id")
    private String projectId;

    /**
     * 삭제 여부
     */
    @JsonProperty("is_deleted")
    private Boolean isDeleted;

    /**
     * 데이터소스 ID
     */
    @JsonProperty("datasource_id")
    private String datasourceId;

    /**
     * 프로세서 파라미터
     */
    @JsonProperty("processor")
    private ProcessorParam processor;

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

    /**
     * 정책 페이로드
     */
    @JsonProperty("policy")
    private List<BasePolicyPayload> policy;
}
