package com.skax.aiportal.client.sktai.evaluation;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.skax.aiportal.client.sktai.config.SktAiClientConfig;
import com.skax.aiportal.client.sktai.evaluation.dto.request.EvaluationCreateRequest;
import com.skax.aiportal.client.sktai.evaluation.dto.response.EvaluationResponse;
import com.skax.aiportal.client.sktai.evaluation.dto.response.GeneralEvaluationResponse;
import com.skax.aiportal.client.sktai.interceptor.SktAiAuthInterceptor;
import com.skax.aiportal.client.sktai.interceptor.SktAiLoggingInterceptor;

@FeignClient(name = "sktAiGeneralEvaluationClient", url = "${sktai.api.base-url:https://aip-stg.sktai.io}", configuration = {
        SktAiClientConfig.class,
        SktAiAuthInterceptor.class,
        SktAiLoggingInterceptor.class
})
public interface SktAiGeneralEvaluationClient {

    @PostMapping("/api/v1/evaluations")
    GeneralEvaluationResponse createEvaluation(@RequestBody EvaluationCreateRequest request);

    @GetMapping("/api/v1/evaluations")
    EvaluationResponse<List<GeneralEvaluationResponse>> getEvaluations(@RequestParam(value = "page", defaultValue = "1") Integer page,
                                                                       @RequestParam(value = "size", defaultValue = "20") Integer size,
                                                                       @RequestParam(value = "sort", required = false) String sort,
                                                                       @RequestParam(value = "filter", required = false) String filter,
                                                                       @RequestParam(value = "search", required = false) String search);

    @GetMapping("/api/v1/evaluations/{id}")
    GeneralEvaluationResponse getEvaluation(@PathVariable("id") Integer id);
}
