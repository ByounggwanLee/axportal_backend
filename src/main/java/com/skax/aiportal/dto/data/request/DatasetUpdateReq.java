package com.skax.aiportal.dto.data.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 데이터셋 정보 수정 요청 DTO
 * 
 * <p>기존 데이터셋의 정보를 수정하기 위한 요청 정보를 담는 DTO입니다.
 * 데이터셋 ID와 함께 수정할 정보들을 포함합니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-07-23
 * @version 1.0
 */
@Schema(description = "데이터셋 정보 수정 요청")
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class DatasetUpdateReq {

    /**
     * 데이터셋 ID
     */
    @Schema(
        description = "수정할 데이터셋의 고유 식별자", 
        example = "dataset-12345",
        requiredMode = Schema.RequiredMode.REQUIRED
    )
    @NotBlank(message = "데이터셋 ID는 필수입니다")
    private String datasetId;

    /**
     * 데이터셋 설명
     */
    @Schema(
        description = "수정할 데이터셋 설명", 
        example = "고객의 온라인 쇼핑 행동 패턴을 분석하기 위한 개선된 데이터셋입니다.",
        requiredMode = Schema.RequiredMode.REQUIRED
    )
    @NotBlank(message = "데이터셋 설명은 필수입니다")
    @Size(max = 1000, message = "데이터셋 설명은 1000자 이하여야 합니다")
    private String description;

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
}
