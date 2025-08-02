package com.skax.aiplatform.client.sktax.data.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.skax.aiplatform.client.sktax.data.dto.DataProcessor;
import com.skax.aiplatform.client.sktax.data.dto.Pagination;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * SKT AX Data API 데이터 프로세서 목록 응답
 * 
 * <p>데이터 프로세서 목록과 페이징 정보를 포함하는 응답 DTO입니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-01-21
 * @version 1.0
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DataProcessorList {
    
    /**
     * 프로세서 목록
     */
    @JsonProperty("items")
    private List<DataProcessor> items;
    
    /**
     * 페이지네이션 정보
     */
    @JsonProperty("pagination")
    private Pagination pagination;
    
    /**
     * 총 개수
     */
    @JsonProperty("total")
    private Integer total;
    
    /**
     * 페이지 번호 (0부터 시작)
     */
    @JsonProperty("page")
    private Integer page;
    
    /**
     * 페이지 크기
     */
    @JsonProperty("size")
    private Integer size;
    
    /**
     * 총 페이지 수
     */
    @JsonProperty("pages")
    private Integer pages;
}
