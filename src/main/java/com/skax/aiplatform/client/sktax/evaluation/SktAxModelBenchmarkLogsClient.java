package com.skax.aiplatform.client.sktax.evaluation;

import com.skax.aiplatform.client.sktax.evaluation.dto.request.ModelBenchmarkLogUpdateStatusRequest;
import com.skax.aiplatform.client.sktax.evaluation.dto.response.ModelBenchmarkLog;
import com.skax.aiplatform.client.sktax.evaluation.dto.response.ModelBenchmarkLogWithModelListResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * SKT Ax Model Benchmark Logs API Client
 * 
 * @author ByounggwanLee
 * @since 2025-08-02
 * @version 1.0
 */
@FeignClient(
    name = "sktax-model-benchmark-logs",
    url = "${client.sktax.evaluation.url:https://aip-stg.sktai.io}",
    configuration = com.skax.aiplatform.client.sktax.config.SktAxFeignConfig.class
)
public interface SktAxModelBenchmarkLogsClient {

    /**
     * 모델 벤치마크 로그 목록 조회
     */
    @GetMapping("/api/v1/model-benchmark-logs")
    ModelBenchmarkLogWithModelListResponse getModelBenchmarkLogs(
        @RequestParam(required = false, defaultValue = "1") Integer page,
        @RequestParam(required = false, defaultValue = "20") Integer size,
        @RequestParam(required = false) String sort,
        @RequestParam(required = false) String filter,
        @RequestParam(required = false) String search
    );

    /**
     * 모델 벤치마크 로그 상태 업데이트
     */
    @PutMapping("/api/v1/model-benchmark-logs/{id}")
    ModelBenchmarkLog updateModelBenchmarkLogStatus(
        @PathVariable Integer id,
        @RequestBody ModelBenchmarkLogUpdateStatusRequest request
    );
}
