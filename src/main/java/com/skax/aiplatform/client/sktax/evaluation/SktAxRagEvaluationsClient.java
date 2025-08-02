package com.skax.aiplatform.client.sktax.evaluation;

import com.skax.aiplatform.client.sktax.evaluation.dto.request.RagEvaluationCreateRequest;
import com.skax.aiplatform.client.sktax.evaluation.dto.response.RagEvaluationListResponse;
import com.skax.aiplatform.client.sktax.evaluation.dto.response.RagEvaluationResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * SKT Ax RAG Evaluations API Client
 * 
 * @author ByounggwanLee
 * @since 2025-08-02
 * @version 1.0
 */
@FeignClient(
    name = "sktax-rag-evaluations",
    url = "${client.sktax.evaluation.url:https://aip-stg.sktai.io}",
    configuration = com.skax.aiplatform.client.sktax.config.SktAxFeignConfig.class
)
public interface SktAxRagEvaluationsClient {

    /**
     * RAG 평가 목록 조회
     */
    @GetMapping("/api/v1/rag-evaluations")
    RagEvaluationListResponse getRagEvaluations(
        @RequestParam(required = false, defaultValue = "1") Integer page,
        @RequestParam(required = false, defaultValue = "20") Integer size,
        @RequestParam(required = false) String sort,
        @RequestParam(required = false) String filter,
        @RequestParam(required = false) String search
    );

    /**
     * RAG 평가 생성
     */
    @PostMapping("/api/v1/rag-evaluations")
    RagEvaluationResponse createRagEvaluation(@RequestBody RagEvaluationCreateRequest request);

    /**
     * RAG 평가 상세 조회
     */
    @GetMapping("/api/v1/rag-evaluations/{id}")
    RagEvaluationResponse getRagEvaluation(@PathVariable Integer id);
}
