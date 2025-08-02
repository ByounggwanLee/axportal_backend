package com.skax.aiplatform.client.sktax.evaluation;

import com.skax.aiplatform.client.sktax.evaluation.dto.request.ModelBenchmarkTaskCreateRequest;
import com.skax.aiplatform.client.sktax.evaluation.dto.response.ModelBenchmarkTaskResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * SKT Ax Model Benchmark Tasks API Client
 * 
 * @author ByounggwanLee
 * @since 2025-08-02
 * @version 1.0
 */
@FeignClient(
    name = "sktax-model-benchmark-tasks",
    url = "${client.sktax.evaluation.url:https://aip-stg.sktai.io}",
    configuration = com.skax.aiplatform.client.sktax.config.SktAxFeignConfig.class
)
public interface SktAxModelBenchmarkTasksClient {

    /**
     * 모델 벤치마크 태스크 저장 및 시작
     */
    @PostMapping("/api/v1/model-benchmark-tasks")
    ModelBenchmarkTaskResponse createModelBenchmarkTask(@RequestBody ModelBenchmarkTaskCreateRequest request);
}
