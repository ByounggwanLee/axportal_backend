package com.skax.aiportal.client.sktai.data.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.extern.jackson.Jacksonized;

import jakarta.validation.constraints.NotBlank;
import java.util.List;

/**
 * 데이터 프로세서 실행 요청 DTO
 * 
 * <p>SKT AI 플랫폼의 데이터 프로세서 실행 요청 정보를 담는 클래스입니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-07-19
 * @version 1.0
 */
@Getter
@Builder
@Jacksonized
public class DataProcessorExecuteRequest {

    /**
     * 프로세서 ID 목록
     */
    @JsonProperty("ids")
    @Builder.Default
    private List<String> ids = List.of();

    /**
     * 입력 데이터
     */
    @NotBlank(message = "입력 데이터는 필수입니다")
    @JsonProperty("input_data")
    private String inputData;

    /**
     * 중복 제거 서브셋 컬럼
     */
    @JsonProperty("duplicate_subset_columns")
    @Builder.Default
    private List<String> duplicateSubsetColumns = List.of();

    /**
     * 정규식 목록
     */
    @JsonProperty("regular_expressions")
    @Builder.Default
    private List<String> regularExpressions = List.of();
}
