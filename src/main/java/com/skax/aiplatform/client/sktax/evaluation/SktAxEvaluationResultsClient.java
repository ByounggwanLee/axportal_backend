package com.skax.aiplatform.client.sktax.evaluation;

import com.skax.aiplatform.client.sktax.evaluation.dto.request.EvaluationResultCreateRequest;
import com.skax.aiplatform.client.sktax.evaluation.dto.request.EvaluationResultUpdateRequest;
import com.skax.aiplatform.client.sktax.evaluation.dto.response.EvaluationResultResponse;
import com.skax.aiplatform.client.sktax.evaluation.dto.response.EvaluationResultSummary;
import com.skax.aiplatform.client.sktax.evaluation.dto.response.EvaluationResultWithModelListResponse;
import com.skax.aiplatform.client.sktax.evaluation.dto.response.EvaluationResultWithModelResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * SKT Ax Evaluation Results API Client
 * 
 * @author ByounggwanLee
 * @since 2025-08-02
 * @version 1.0
 */
@FeignClient(
    name = "sktax-evaluation-results",
    url = "${client.sktax.evaluation.url:https://aip-stg.sktai.io}",
    configuration = com.skax.aiplatform.client.sktax.config.SktAxFeignConfig.class
)
public interface SktAxEvaluationResultsClient {

    /**
     * 평가 결과 목록 조회
     */
    @GetMapping("/api/v1/evaluation-results")
    EvaluationResultWithModelListResponse getEvaluationResults(
        @RequestParam(required = false, defaultValue = "1") Integer page,
        @RequestParam(required = false, defaultValue = "20") Integer size,
        @RequestParam(required = false) String sort,
        @RequestParam(required = false) String filter,
        @RequestParam(required = false) String search
    );

    /**
     * 평가 결과 생성
     */
    @PostMapping("/api/v1/evaluation-results")
    EvaluationResultResponse createEvaluationResult(@RequestBody EvaluationResultCreateRequest request);

    /**
     * 평가 결과 요약 조회
     */
    @GetMapping("/api/v1/evaluation-results/summary")
    List<EvaluationResultSummary> getEvaluationResultSummary(
        @RequestParam(required = false) String filter
    );

    /**
     * 평가 결과 상세 조회
     */
    @GetMapping("/api/v1/evaluation-results/{id}")
    EvaluationResultWithModelResponse getEvaluationResult(@PathVariable Integer id);

    /**
     * 평가 결과 삭제
     */
    @DeleteMapping("/api/v1/evaluation-results/{id}")
    void deleteEvaluationResult(@PathVariable Integer id);

    /**
     * 평가 결과 업데이트
     */
    @PostMapping("/api/v1/evaluation-results/update")
    List<EvaluationResultResponse> updateEvaluationResults(@RequestBody EvaluationResultUpdateRequest request);
}
