package com.skax.aiplatform.client.sktax.evaluation;

import com.skax.aiplatform.client.sktax.evaluation.dto.request.RagEvaluationLogUpdateStatusRequest;
import com.skax.aiplatform.client.sktax.evaluation.dto.response.RagEvaluationLog;
import com.skax.aiplatform.client.sktax.evaluation.dto.response.RagEvaluationLogWithModelListResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * SKT Ax RAG Evaluation Logs API Client
 * 
 * @author ByounggwanLee
 * @since 2025-08-02
 * @version 1.0
 */
@FeignClient(
    name = "sktax-rag-evaluation-logs",
    url = "${client.sktax.evaluation.url:https://aip-stg.sktai.io}",
    configuration = com.skax.aiplatform.client.sktax.config.SktAxFeignConfig.class
)
public interface SktAxRagEvaluationLogsClient {

    /**
     * RAG 평가 로그 목록 조회
     */
    @GetMapping("/api/v1/rag-evaluation-logs")
    RagEvaluationLogWithModelListResponse getRagEvaluationLogs(
        @RequestParam(required = false, defaultValue = "1") Integer page,
        @RequestParam(required = false, defaultValue = "20") Integer size,
        @RequestParam(required = false) String sort,
        @RequestParam(required = false) String filter,
        @RequestParam(required = false) String search
    );

    /**
     * RAG 평가 로그 상태 업데이트
     */
    @PutMapping("/api/v1/rag-evaluation-logs/{id}")
    RagEvaluationLog updateRagEvaluationLogStatus(
        @PathVariable Integer id,
        @RequestBody RagEvaluationLogUpdateStatusRequest request
    );
}
