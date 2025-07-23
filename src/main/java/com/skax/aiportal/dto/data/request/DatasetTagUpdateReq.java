package com.skax.aiportal.dto.data.request;

import java.util.List;

import com.skax.aiportal.client.sktai.data.dto.DatasetTag;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 데이터셋 태그 업데이트 요청 DTO
 * 
 * <p>데이터셋의 태그 정보를 업데이트하기 위한 요청 정보를 담는 DTO입니다.
 * 데이터셋 ID와 함께 추가하거나 업데이트할 태그 목록을 포함합니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-07-23
 * @version 1.0
 */
@Schema(description = "데이터셋 태그 업데이트 요청")
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class DatasetTagUpdateReq {

    /**
     * 데이터셋 ID
     */
    @Schema(
        description = "태그를 업데이트할 데이터셋의 고유 식별자", 
        example = "dataset-12345",
        requiredMode = Schema.RequiredMode.REQUIRED
    )
    @NotBlank(message = "데이터셋 ID는 필수입니다")
    private String datasetId;

    /**
     * 태그 목록
     */
    @Schema(
        description = "업데이트할 태그 정보 목록",
        requiredMode = Schema.RequiredMode.REQUIRED
    )
    @Valid
    @NotEmpty(message = "태그 목록은 비어있을 수 없습니다")
    private List<DatasetTag> tags;
}
