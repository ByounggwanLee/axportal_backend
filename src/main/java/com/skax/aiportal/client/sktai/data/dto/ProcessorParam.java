package com.skax.aiportal.client.sktai.data.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 프로세서 매개변수 클래스
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProcessorParam {

    /**
     * 프로세서 ID 목록
     */
    private List<String> ids;

    /**
     * 중복 제거 컬럼 목록
     */
    @JsonProperty("duplicate_subset_columns")
    private List<String> duplicateSubsetColumns;

    /**
     * 정규표현식 목록
     */
    @JsonProperty("regular_expression")
    private List<String> regularExpression;
}