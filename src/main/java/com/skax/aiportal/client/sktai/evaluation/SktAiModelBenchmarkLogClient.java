package com.skax.aiportal.client.sktai.evaluation;

import com.skax.aiportal.client.sktai.config.SktAiClientConfig;
import com.skax.aiportal.client.sktai.evaluation.dto.request.ModelBenchmarkLogUpdateStatusRequest;
import com.skax.aiportal.client.sktai.evaluation.dto.response.EvaluationResponse;
import com.skax.aiportal.client.sktai.evaluation.dto.response.ModelBenchmarkLogResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * SKT AI Evaluation API - 모델 벤치마크 로그 관리 Feign 클라이언트
 * 모델 벤치마크 로그 조회 및 상태 업데이트
 */
@FeignClient(
    name = "skt-ai-model-benchmark-log", url = "${sktai.api.base-url:https://aip-stg.sktai.io}", configuration = {
        com.skax.aiportal.client.sktai.config.SktAiClientConfig.class,
        com.skax.aiportal.client.sktai.interceptor.SktAiAuthInterceptor.class,
        com.skax.aiportal.client.sktai.interceptor.SktAiLoggingInterceptor.class
})
public interface SktAiModelBenchmarkLogClient {
    
    /**
     * 모델 벤치마크 로그 목록 조회
     */
    @GetMapping("/api/v1/model-benchmark-logs")
    EvaluationResponse<List<Object>> getLogs(
        @RequestParam(name = "page", defaultValue = "1") Integer page,
        @RequestParam(name = "size", defaultValue = "20") Integer size,
        @RequestParam(name = "sort", required = false) String sort,
        @RequestParam(name = "filter", required = false) String filter,
        @RequestParam(name = "search", required = false) String search
    );
    
    /**
     * 모델 벤치마크 로그 상태 업데이트
     */
    @PutMapping("/api/v1/model-benchmark-logs/{id}")
    ModelBenchmarkLogResponse updateLogStatus(
        @PathVariable("id") Integer id,
        @RequestBody ModelBenchmarkLogUpdateStatusRequest request
    );
}
