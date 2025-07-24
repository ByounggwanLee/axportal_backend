package com.skax.aiportal.dto.data;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 애플리케이션용 데이터셋 미리보기 정보 DTO
 * 
 * <p>애플리케이션 계층에서 사용하는 데이터셋 미리보기 정보를 담는 DTO입니다.
 * Client DTO와 독립적으로 설계되어 애플리케이션의 요구사항에 맞게 구성됩니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-07-24
 * @version 1.0
 */
@Schema(description = "애플리케이션용 데이터셋 미리보기 정보")
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class DatasetPreviewInfo {

    /**
     * 미리보기 데이터
     */
    @Schema(description = "미리보기 데이터 목록")
    @JsonProperty("data")
    private List<Object> data;

    /**
     * 총 데이터 행 수
     */
    @Schema(description = "총 데이터 행 수", example = "1000")
    @JsonProperty("total_rows")
    private Long totalRows;

    /**
     * 미리보기 행 수
     */
    @Schema(description = "미리보기 행 수", example = "100")
    @JsonProperty("preview_rows")
    private Integer previewRows;

    /**
     * 컬럼 정보
     */
    @Schema(description = "컬럼 정보 목록")
    @JsonProperty("columns")
    private List<String> columns;

    /**
     * 데이터 타입 정보
     */
    @Schema(description = "데이터 타입 정보")
    @JsonProperty("data_types")
    private List<String> dataTypes;
}
