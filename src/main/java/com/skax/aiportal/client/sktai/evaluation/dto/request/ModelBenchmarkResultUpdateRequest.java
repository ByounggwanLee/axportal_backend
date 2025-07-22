package com.skax.aiportal.client.sktai.evaluation.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 모델 벤치마크 결과 업데이트 요청 DTO
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ModelBenchmarkResultUpdateRequest {
    
    @JsonProperty("model_benchmark_log_id")
    private Integer modelBenchmarkLogId;
    
    @JsonProperty("policy")
    private List<Object> policy;
}
