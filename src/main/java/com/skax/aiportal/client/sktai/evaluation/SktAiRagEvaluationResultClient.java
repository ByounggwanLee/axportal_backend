package com.skax.aiportal.client.sktai.evaluation;

import com.skax.aiportal.client.sktai.config.SktAiClientConfig;
import com.skax.aiportal.client.sktai.evaluation.dto.request.RagEvaluationResultCreateRequest;
import com.skax.aiportal.client.sktai.evaluation.dto.request.RagEvaluationResultUpdateRequest;
import com.skax.aiportal.client.sktai.evaluation.dto.response.EvaluationResponse;
import com.skax.aiportal.client.sktai.evaluation.dto.response.RagEvaluationResultResponse;
import com.skax.aiportal.client.sktai.evaluation.dto.response.RagEvaluationResultSummaryResponse;
import com.skax.aiportal.client.sktai.evaluation.dto.response.RagEvaluationResultWithModelResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "sktAiRagEvaluationResultClient", url = "${sktai.api.base-url:https://aip-stg.sktai.io}", configuration = {
        com.skax.aiportal.client.sktai.config.SktAiClientConfig.class,
        com.skax.aiportal.client.sktai.interceptor.SktAiAuthInterceptor.class,
        com.skax.aiportal.client.sktai.interceptor.SktAiLoggingInterceptor.class
})
public interface SktAiRagEvaluationResultClient {

    @PostMapping("/api/v1/rag-evaluation-results")
    RagEvaluationResultResponse createRagEvaluationResult(@RequestBody RagEvaluationResultCreateRequest request);

    @GetMapping("/api/v1/rag-evaluation-results")
    EvaluationResponse<List<RagEvaluationResultWithModelResponse>> getRagEvaluationResults(@RequestParam(value = "page", defaultValue = "1") Integer page,
                                                                                            @RequestParam(value = "size", defaultValue = "20") Integer size,
                                                                                            @RequestParam(value = "sort", required = false) String sort,
                                                                                            @RequestParam(value = "filter", required = false) String filter,
                                                                                            @RequestParam(value = "search", required = false) String search);

    @GetMapping("/api/v1/rag-evaluation-results/summary")
    List<RagEvaluationResultSummaryResponse> getRagEvaluationResultsSummary(@RequestParam(value = "filter", required = false) String filter);

    @GetMapping("/api/v1/rag-evaluation-results/{id}")
    RagEvaluationResultWithModelResponse getRagEvaluationResult(@PathVariable("id") Integer id);

    @DeleteMapping("/api/v1/rag-evaluation-results/{id}")
    void deleteRagEvaluationResult(@PathVariable("id") Integer id);

    @PostMapping("/api/v1/rag-evaluation-results/update")
    List<RagEvaluationResultResponse> updateRagEvaluationResults(@RequestBody RagEvaluationResultUpdateRequest request);
}
