package com.skax.aiplatform.client.sktax.evaluation;

import com.skax.aiplatform.client.sktax.evaluation.dto.request.EvaluationCreateRequest;
import com.skax.aiplatform.client.sktax.evaluation.dto.response.EvaluationListResponse;
import com.skax.aiplatform.client.sktax.evaluation.dto.response.EvaluationResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * SKT Ax Evaluation API Client
 * 
 * @author ByounggwanLee
 * @since 2025-08-02
 * @version 1.0
 */
@FeignClient(
    name = "sktax-evaluation",
    url = "${client.sktax.evaluation.url:https://aip-stg.sktai.io}",
    configuration = com.skax.aiplatform.client.sktax.config.SktAxFeignConfig.class
)
public interface SktAxEvaluationClient {

    /**
     * 평가 목록 조회
     */
    @GetMapping("/api/v1/evaluations")
    EvaluationListResponse getEvaluations(
        @RequestParam(required = false, defaultValue = "1") Integer page,
        @RequestParam(required = false, defaultValue = "20") Integer size,
        @RequestParam(required = false) String sort,
        @RequestParam(required = false) String filter,
        @RequestParam(required = false) String search
    );

    /**
     * 평가 생성
     */
    @PostMapping("/api/v1/evaluations")
    EvaluationResponse createEvaluation(@RequestBody EvaluationCreateRequest request);

    /**
     * 평가 상세 조회
     */
    @GetMapping("/api/v1/evaluations/{id}")
    EvaluationResponse getEvaluation(@PathVariable Integer id);
}
