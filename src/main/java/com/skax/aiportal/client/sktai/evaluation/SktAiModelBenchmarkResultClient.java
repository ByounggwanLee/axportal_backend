package com.skax.aiportal.client.sktai.evaluation;

import com.skax.aiportal.client.sktai.config.SktAiClientConfig;
import com.skax.aiportal.client.sktai.evaluation.dto.request.ModelBenchmarkResultCreateRequest;
import com.skax.aiportal.client.sktai.evaluation.dto.request.ModelBenchmarkResultUpdateRequest;
import com.skax.aiportal.client.sktai.evaluation.dto.response.*;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * SKT AI Evaluation API - 모델 벤치마크 결과 관리 Feign 클라이언트
 * 모델 벤치마크 결과 생성, 조회, 수정, 삭제
 */
@FeignClient(
    name = "skt-ai-model-benchmark-result",
    url = "${sktai.api.base-url}",
    configuration = SktAiClientConfig.class
)
public interface SktAiModelBenchmarkResultClient {
    
    /**
     * 모델 벤치마크 결과 생성
     */
    @PostMapping("/api/v1/model-benchmark-results")
    ModelBenchmarkResultReadResponse createResult(@RequestBody ModelBenchmarkResultCreateRequest request);
    
    /**
     * 모델 벤치마크 결과 목록 조회
     */
    @GetMapping("/api/v1/model-benchmark-results")
    EvaluationResponse<List<Object>> getResults(
        @RequestParam(name = "page", defaultValue = "1") Integer page,
        @RequestParam(name = "size", defaultValue = "20") Integer size,
        @RequestParam(name = "sort", required = false) String sort,
        @RequestParam(name = "filter", required = false) String filter,
        @RequestParam(name = "search", required = false) String search
    );
    
    /**
     * 모델 벤치마크 결과 상세 조회
     */
    @GetMapping("/api/v1/model-benchmark-results/{id}")
    Object getResult(@PathVariable("id") Integer id);
    
    /**
     * 모델 벤치마크 결과 삭제
     */
    @DeleteMapping("/api/v1/model-benchmark-results/{id}")
    void deleteResult(@PathVariable("id") Integer id);
    
    /**
     * 모델 벤치마크 결과 요약 조회
     */
    @GetMapping("/api/v1/model-benchmark-results/summary")
    List<ModelBenchmarkResultSummaryResponse> getResultsSummary(
        @RequestParam(name = "filter", required = false) String filter
    );
    
    /**
     * 모델 벤치마크 결과 백그라운드 업데이트
     */
    @PostMapping("/api/v1/model-benchmark-results/update")
    List<ModelBenchmarkResultReadResponse> updateResults(@RequestBody ModelBenchmarkResultUpdateRequest request);
}
