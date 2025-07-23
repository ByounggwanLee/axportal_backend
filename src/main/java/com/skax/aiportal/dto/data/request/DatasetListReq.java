package com.skax.aiportal.dto.data.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 데이터셋 목록 조회 요청 DTO
 * 
 * <p>데이터셋 목록을 페이징하여 조회하기 위한 요청 정보를 담는 DTO입니다.
 * 페이지 번호, 크기, 정렬, 필터, 검색 조건을 설정할 수 있습니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-07-23
 * @version 1.0
 */
@Schema(description = "데이터셋 목록 조회 요청")
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class DatasetListReq {

    /**
     * 페이지 번호 (1부터 시작)
     */
    @Schema(
        description = "페이지 번호 (1부터 시작)", 
        example = "1", 
        minimum = "1",
        defaultValue = "1"
    )
    @Min(value = 1, message = "페이지 번호는 1 이상이어야 합니다")
    @Builder.Default
    private Integer page = 1;

    /**
     * 페이지 크기 (1-100)
     */
    @Schema(
        description = "페이지 크기", 
        example = "10", 
        minimum = "1", 
        maximum = "100",
        defaultValue = "10"
    )
    @Min(value = 1, message = "페이지 크기는 1 이상이어야 합니다")
    @Max(value = 100, message = "페이지 크기는 100 이하여야 합니다")
    @Builder.Default
    private Integer size = 10;

    /**
     * 정렬 기준
     */
    @Schema(
        description = "정렬 기준 (예: name:asc, created_at:desc)", 
        example = ""
    )
    @Size(max = 100, message = "정렬 기준은 100자 이하여야 합니다")
    private String sort;

    /**
     * 필터 조건
     */
    @Schema(
        description = "필터 조건 (예: type:image, status:active)", 
        example = ""
    )
    @Size(max = 200, message = "필터 조건은 200자 이하여야 합니다")
    private String filter;

    /**
     * 검색어
     */
    @Schema(
        description = "데이터셋 이름 또는 설명에서 검색할 키워드", 
        example = ""
    )
    @Size(max = 100, message = "검색어는 100자 이하여야 합니다")
    private String search;
}
