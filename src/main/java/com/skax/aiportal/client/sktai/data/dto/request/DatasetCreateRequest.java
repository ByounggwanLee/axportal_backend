package com.skax.aiportal.client.sktai.data.dto.request;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.skax.aiportal.client.sktai.data.dto.DatasetTag;
import com.skax.aiportal.client.sktai.data.dto.ProcessorParam;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 데이터셋 생성 요청 DTO
 * 
 * <p>SKT AI 플랫폼에서 새로운 데이터셋을 생성할 때 사용하는 요청 데이터입니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-07-19
 * @version 1.0
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DatasetCreateRequest {

    /**
     * 데이터셋 이름
     */
    @NotBlank(message = "데이터셋 이름은 필수입니다")
    private String name;

    /**
     * 데이터셋 타입
     * unsupervised_finetuning, supervised_finetuning, model_benchmark, rag_evaluation
     */
    @JsonProperty("type")
    @Builder.Default
    private String type = "unsupervised_finetuning";

    /**
     * 데이터셋 설명
     */
    private String description;

    /**
     * 데이터셋 태그 목록
     */
    private List<DatasetTag> tags;

    /**
     * 데이터셋 상태
     */
    @Builder.Default
    private String status = "processing";

    /**
     * 프로젝트 ID
     */
    @NotBlank(message = "프로젝트 ID는 필수입니다")
    @JsonProperty("project_id")
    private String projectId;

    /**
     * 삭제 여부
     */
    @JsonProperty("is_deleted")
    @Builder.Default
    private Boolean isDeleted = false;

    /**
     * 데이터소스 ID
     */
    @NotNull(message = "데이터소스 ID는 필수입니다")
    @JsonProperty("datasource_id")
    private String datasourceId;

    /**
     * 프로세서 매개변수
     */
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
    private Object policy;
}
