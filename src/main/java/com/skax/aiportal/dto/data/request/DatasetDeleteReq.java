package com.skax.aiportal.dto.data.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 데이터셋 삭제 요청 DTO
 * 
 * <p>데이터셋을 소프트 삭제하기 위한 요청 정보를 담는 DTO입니다.
 * 데이터셋은 즉시 삭제되지 않고 삭제 상태로 표시됩니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-07-23
 * @version 1.0
 */
@Schema(description = "데이터셋 삭제 요청")
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class DatasetDeleteReq {

    /**
     * 데이터셋 ID
     */
    @Schema(
        description = "삭제할 데이터셋의 고유 식별자", 
        example = "dataset-12345",
        requiredMode = Schema.RequiredMode.REQUIRED
    )
    @NotBlank(message = "데이터셋 ID는 필수입니다")
    private String datasetId;
}
