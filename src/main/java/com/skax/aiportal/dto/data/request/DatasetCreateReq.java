package com.skax.aiportal.dto.data.request;

import java.util.List;

import com.skax.aiportal.client.sktai.data.dto.DatasetTag;
import com.skax.aiportal.client.sktai.data.dto.ProcessorParam;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 데이터셋 생성 요청 DTO
 * 
 * <p>새로운 데이터셋을 생성하기 위한 요청 정보를 담는 DTO입니다.
 * 파인튜닝, 벤치마크, RAG 평가 등 다양한 용도의 데이터셋을 생성할 수 있습니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-07-23
 * @version 1.0
 */
@Schema(description = "데이터셋 생성 요청")
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class DatasetCreateReq {

    /**
     * 데이터셋 이름
     */
    @Schema(
        description = "데이터셋 이름", 
        example = "고객 상담 파인튜닝 데이터셋",
        requiredMode = Schema.RequiredMode.REQUIRED
    )
    @NotBlank(message = "데이터셋 이름은 필수입니다")
    @Size(max = 100, message = "데이터셋 이름은 100자 이하여야 합니다")
    private String name;

    /**
     * 데이터셋 타입
     */
    @Schema(
        description = "데이터셋 타입 (예: unsupervised_finetuning, supervised_finetuning, model_benchmark, rag_evaluation)", 
        example = "supervised_finetuning",
        defaultValue = "unsupervised_finetuning",
        allowableValues = {
            "unsupervised_finetuning", 
            "supervised_finetuning", 
            "model_benchmark", 
            "rag_evaluation"
        }
    )
    @Size(max = 50, message = "데이터셋 타입은 50자 이하여야 합니다")
    @Builder.Default
    private String type = "unsupervised_finetuning";

    /**
     * 데이터셋 설명
     */
    @Schema(
        description = "데이터셋에 대한 상세 설명", 
        example = "고객 상담 데이터를 활용한 파인튜닝용 데이터셋입니다."
    )
    @Size(max = 1000, message = "데이터셋 설명은 1000자 이하여야 합니다")
    private String description;

    /**
     * 데이터셋 태그 목록
     */
    @Schema(
        description = "데이터셋 태그 목록"
    )
    @Valid
    private List<DatasetTag> tags;

    /**
     * 데이터셋 상태
     */
    @Schema(
        description = "데이터셋 상태 (예: processing, active, inactive)", 
        example = "processing",
        defaultValue = "processing"
    )
    @Size(max = 20, message = "데이터셋 상태는 20자 이하여야 합니다")
    @Builder.Default
    private String status = "processing";

    /**
     * 프로젝트 ID
     */
    @Schema(
        description = "데이터셋이 속할 프로젝트 ID", 
        example = "project-12345",
        requiredMode = Schema.RequiredMode.REQUIRED
    )
    @NotBlank(message = "프로젝트 ID는 필수입니다")
    @Size(max = 50, message = "프로젝트 ID는 50자 이하여야 합니다")
    private String projectId;

    /**
     * 삭제 여부
     */
    @Schema(
        description = "삭제 여부", 
        example = "false",
        defaultValue = "false"
    )
    @Builder.Default
    private Boolean isDeleted = false;

    /**
     * 데이터소스 ID
     */
    @Schema(
        description = "데이터소스 ID", 
        example = "datasource-12345",
        requiredMode = Schema.RequiredMode.REQUIRED
    )
    @NotNull(message = "데이터소스 ID는 필수입니다")
    @Size(max = 50, message = "데이터소스 ID는 50자 이하여야 합니다")
    private String datasourceId;

    /**
     * 프로세서 매개변수
     */
    @Schema(
        description = "프로세서 매개변수"
    )
    @Valid
    private ProcessorParam processor;

    /**
     * 생성자
     */
    @Schema(
        description = "데이터셋 생성자 정보", 
        example = "user@example.com"
    )
    @Size(max = 100, message = "생성자 정보는 100자 이하여야 합니다")
    private String createdBy;

    /**
     * 수정자
     */
    @Schema(
        description = "데이터셋 수정자 정보", 
        example = "admin@example.com"
    )
    @Size(max = 100, message = "수정자 정보는 100자 이하여야 합니다")
    private String updatedBy;

    /**
     * 정책 페이로드
     */
    @Schema(
        description = "정책 페이로드 (JSON 형태)", 
        example = "{\"access_policy\": \"restricted\", \"retention_days\": 365}"
    )
    private Object policy;
}
