package com.skax.aiplatform.client.sktax.data.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * DataProcessor 실행 요청 DTO
 * 
 * <p>데이터 프로세서를 실행하기 위한 요청 데이터 모델입니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-08-02
 * @version 1.0
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DataProcessorExecute {

    /**
     * 프로세서 ID 목록 (기본값: [])
     */
    @JsonProperty("ids")
    @Builder.Default
    private List<String> ids = List.of();

    /**
     * 입력 데이터 (필수)
     */
    @JsonProperty("input_data")
    private String inputData;

    /**
     * 중복 제거 서브셋 컬럼 (기본값: [])
     */
    @JsonProperty("duplicate_subset_columns")
    @Builder.Default
    private List<String> duplicateSubsetColumns = List.of();

    /**
     * 정규 표현식 (기본값: [])
     */
    @JsonProperty("regular_expressions")
    @Builder.Default
    private List<String> regularExpressions = List.of();
}
