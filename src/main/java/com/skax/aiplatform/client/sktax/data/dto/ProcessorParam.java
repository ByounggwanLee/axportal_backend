package com.skax.aiplatform.client.sktax.data.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 프로세서 파라미터 DTO
 * 
 * <p>데이터 프로세싱을 위한 파라미터 정보입니다.
 * OpenAPI 명세의 ProcessorParam 스키마와 일치합니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-08-02
 * @version 1.0
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProcessorParam {
    
    /**
     * 프로세서 ID 목록
     * 기본값: 빈 배열
     */
    @JsonProperty("ids")
    @Builder.Default
    private List<String> ids = List.of();
    
    /**
     * 중복 제거 시 기준이 되는 컬럼들
     */
    @JsonProperty("duplicate_subset_columns")
    private List<String> duplicateSubsetColumns;
    
    /**
     * 정규표현식 목록
     */
    @JsonProperty("regular_expression")
    private List<String> regularExpression;
}
