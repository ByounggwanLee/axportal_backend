package com.skax.aiportal.client.sktai.data.dto.request;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
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
 * <p>SKT AI Data 플랫폼에서 새로운 데이터셋을 생성하기 위한 요청 정보를 담는 객체입니다.
 * 파인튜닝, 벤치마크, RAG 평가 등 다양한 용도의 데이터셋을 생성할 수 있습니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-07-19
 * @version 1.0
 */
@Schema(
    title = "데이터셋 생성 요청",
    description = "SKT AI Data 플랫폼에서 새로운 데이터셋을 생성하기 위한 요청 정보"
)
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class DatasetCreateRequest {

    /**
     * 데이터셋 이름
     * 
     * <p>생성할 데이터셋의 이름입니다.</p>
     */
    @Schema(
        description = "데이터셋 이름",
        example = "고객 상담 파인튜닝 데이터셋",
        requiredMode = Schema.RequiredMode.REQUIRED,
        maxLength = 100
    )
    @NotBlank(message = "데이터셋 이름은 필수입니다.")
    @Size(max = 100, message = "데이터셋 이름은 100자를 초과할 수 없습니다.")
    private String name;

    /**
     * 데이터셋 타입
     * 
     * <p>데이터셋의 용도를 나타냅니다. 파인튜닝, 벤치마크, RAG 평가 등으로 구분됩니다.</p>
     */
    @Schema(
        description = "데이터셋 타입",
        example = "supervised_finetuning",
        defaultValue = "unsupervised_finetuning",
        allowableValues = {
            "unsupervised_finetuning", 
            "supervised_finetuning", 
            "model_benchmark", 
            "rag_evaluation"
        }
    )
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
