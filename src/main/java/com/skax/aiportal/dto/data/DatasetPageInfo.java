package com.skax.aiportal.dto.data;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 애플리케이션용 데이터셋 페이지네이션 정보 DTO
 * 
 * <p>애플리케이션 계층에서 사용하는 데이터셋 관련 페이지네이션 정보를 담는 DTO입니다.
 * Client DTO와 독립적으로 설계되어 애플리케이션의 요구사항에 맞게 구성됩니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-07-24
 * @version 1.0
 */
@Schema(description = "애플리케이션용 데이터셋 페이지네이션 정보")
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class DatasetPageInfo {

    /**
     * 현재 페이지 번호
     */
    @Schema(description = "현재 페이지 번호 (0부터 시작)", example = "0")
    private Integer page;

    /**
     * 페이지당 아이템 수
     */
    @Schema(description = "페이지당 아이템 수", example = "20")
    @JsonProperty("items_per_page")
    private Integer itemsPerPage;

    /**
     * 전체 아이템 수
     */
    @Schema(description = "전체 아이템 수", example = "150")
    private Integer total;

    /**
     * 전체 페이지 수
     */
    @Schema(description = "전체 페이지 수", example = "8")
    @JsonProperty("last_page")
    private Integer lastPage;

    /**
     * 현재 페이지 시작 아이템 번호
     */
    @Schema(description = "현재 페이지 시작 아이템 번호", example = "1")
    @JsonProperty("from_")
    private Integer from;

    /**
     * 현재 페이지 마지막 아이템 번호
     */
    @Schema(description = "현재 페이지 마지막 아이템 번호", example = "20")
    private Integer to;

    /**
     * 다음 페이지 존재 여부
     */
    @Schema(description = "다음 페이지 존재 여부", example = "true")
    @JsonProperty("has_next")
    private Boolean hasNext;

    /**
     * 이전 페이지 존재 여부
     */
    @Schema(description = "이전 페이지 존재 여부", example = "false")
    @JsonProperty("has_prev")
    private Boolean hasPrev;
}
