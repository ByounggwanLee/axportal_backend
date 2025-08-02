package com.skax.aiplatform.client.sktax.evaluation.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.skax.aiplatform.client.sktax.evaluation.dto.PaginationPayload;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 모델 정보가 포함된 모델 벤치마크 로그 목록 응답 DTO
 * 
 * @author ByounggwanLee
 * @since 2025-08-02
 * @version 1.0
 */
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ModelBenchmarkLogWithModelListResponse {
    
    @JsonProperty("data")
    private List<ModelBenchmarkLogWithModelResponse> data;
    
    @JsonProperty("payload")
    private PaginationPayload payload;
}
