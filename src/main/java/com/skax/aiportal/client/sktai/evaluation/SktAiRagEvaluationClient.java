package com.skax.aiportal.client.sktai.evaluation;

import com.skax.aiportal.client.sktai.config.SktAiClientConfig;
import com.skax.aiportal.client.sktai.evaluation.dto.request.RagEvaluationCreateRequest;
import com.skax.aiportal.client.sktai.evaluation.dto.response.EvaluationResponse;
import com.skax.aiportal.client.sktai.evaluation.dto.response.RagEvaluationResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "sktAiRagEvaluationClient", url = "${sktai.base-url}", configuration = SktAiClientConfig.class)
public interface SktAiRagEvaluationClient {

    @PostMapping("/api/v1/rag-evaluations")
    RagEvaluationResponse createRagEvaluation(@RequestBody RagEvaluationCreateRequest request);

    @GetMapping("/api/v1/rag-evaluations")
    EvaluationResponse<List<RagEvaluationResponse>> getRagEvaluations(@RequestParam(value = "page", defaultValue = "1") Integer page,
                                                                      @RequestParam(value = "size", defaultValue = "20") Integer size,
                                                                      @RequestParam(value = "sort", required = false) String sort,
                                                                      @RequestParam(value = "filter", required = false) String filter,
                                                                      @RequestParam(value = "search", required = false) String search);

    @GetMapping("/api/v1/rag-evaluations/{id}")
    RagEvaluationResponse getRagEvaluation(@PathVariable("id") Integer id);
}
