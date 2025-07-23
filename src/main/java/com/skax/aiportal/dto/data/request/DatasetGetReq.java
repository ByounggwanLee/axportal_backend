package com.skax.aiportal.dto.data.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 데이터셋 조회 요청 DTO
 * 
 * <p>데이터셋 ID로 특정 데이터셋을 조회하기 위한 요청 정보를 담는 DTO입니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-07-23
 * @version 1.0
 */
@Schema(description = "데이터셋 조회 요청")
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class DatasetGetReq {

    /**
     * 데이터셋 ID
     */
    @Schema(
        description = "조회할 데이터셋의 고유 식별자", 
        example = "01803db6-24bd-4189-9ddd-9b6ca12c36fa",
        requiredMode = Schema.RequiredMode.REQUIRED
    )
    @NotBlank(message = "데이터셋 ID는 필수입니다")
    private String datasetId;
}
