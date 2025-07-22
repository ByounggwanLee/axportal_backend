package com.skax.aiportal.client.sktai.evaluation;

import com.skax.aiportal.client.sktai.config.SktAiClientConfig;
import com.skax.aiportal.client.sktai.evaluation.dto.request.EvaluationResultCreateRequest;
import com.skax.aiportal.client.sktai.evaluation.dto.request.EvaluationResultUpdateRequest;
import com.skax.aiportal.client.sktai.evaluation.dto.response.EvaluationResponse;
import com.skax.aiportal.client.sktai.evaluation.dto.response.GeneralEvaluationResultResponse;
import com.skax.aiportal.client.sktai.evaluation.dto.response.GeneralEvaluationResultSummaryResponse;
import com.skax.aiportal.client.sktai.evaluation.dto.response.GeneralEvaluationResultWithModelResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "sktAiGeneralEvaluationResultClient", url = "${sktai.api.base-url:https://aip-stg.sktai.io}", configuration = {
        com.skax.aiportal.client.sktai.config.SktAiClientConfig.class,
        com.skax.aiportal.client.sktai.interceptor.SktAiAuthInterceptor.class,
        com.skax.aiportal.client.sktai.interceptor.SktAiLoggingInterceptor.class
})
public interface SktAiGeneralEvaluationResultClient {

    @PostMapping("/api/v1/evaluation-results")
    GeneralEvaluationResultResponse createEvaluationResult(@RequestBody EvaluationResultCreateRequest request);

    @GetMapping("/api/v1/evaluation-results")
    EvaluationResponse<List<GeneralEvaluationResultWithModelResponse>> getEvaluationResults(@RequestParam(value = "page", defaultValue = "1") Integer page,
                                                                                             @RequestParam(value = "size", defaultValue = "20") Integer size,
                                                                                             @RequestParam(value = "sort", required = false) String sort,
                                                                                             @RequestParam(value = "filter", required = false) String filter,
                                                                                             @RequestParam(value = "search", required = false) String search);

    @GetMapping("/api/v1/evaluation-results/summary")
    List<GeneralEvaluationResultSummaryResponse> getEvaluationResultsSummary(@RequestParam(value = "filter", required = false) String filter);

    @GetMapping("/api/v1/evaluation-results/{id}")
    GeneralEvaluationResultWithModelResponse getEvaluationResult(@PathVariable("id") Integer id);

    @DeleteMapping("/api/v1/evaluation-results/{id}")
    void deleteEvaluationResult(@PathVariable("id") Integer id);

    @PostMapping("/api/v1/evaluation-results/update")
    List<GeneralEvaluationResultResponse> updateEvaluationResults(@RequestBody EvaluationResultUpdateRequest request);
}
