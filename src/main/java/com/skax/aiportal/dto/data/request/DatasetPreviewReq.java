package com.skax.aiportal.dto.data.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 데이터셋 미리보기 요청 DTO
 * 
 * <p>데이터셋의 일부 데이터를 미리보기로 조회하기 위한 요청 정보를 담는 DTO입니다.
 * 데이터셋 ID와 청크 크기를 지정하여 미리보기 데이터를 요청합니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-07-23
 * @version 1.0
 */
@Schema(description = "데이터셋 미리보기 요청")
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class DatasetPreviewReq {

    /**
     * 데이터셋 ID
     */
    @Schema(
        description = "미리보기할 데이터셋의 고유 식별자", 
        example = "dataset-12345",
        requiredMode = Schema.RequiredMode.REQUIRED
    )
    @NotBlank(message = "데이터셋 ID는 필수입니다")
    private String datasetId;

    /**
     * 청크 크기
     */
    @Schema(
        description = "미리보기로 가져올 데이터 크기 (행 수)", 
        example = "100",
        minimum = "1",
        maximum = "1000",
        requiredMode = Schema.RequiredMode.REQUIRED
    )
    @Min(value = 1, message = "청크 크기는 1 이상이어야 합니다")
    @Max(value = 1000, message = "청크 크기는 1000 이하여야 합니다")
    private Integer chunksize;
}
