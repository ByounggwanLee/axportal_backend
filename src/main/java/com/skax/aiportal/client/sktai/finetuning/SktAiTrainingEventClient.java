package com.skax.aiportal.client.sktai.finetuning;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.skax.aiportal.client.sktai.finetuning.dto.response.TrainingEventsResponse;

@FeignClient(name = "sktAiTrainingEventClient", url = "${sktai.api.base-url:https://aip-stg.sktai.io}", configuration = {
        com.skax.aiportal.client.sktai.config.SktAiClientConfig.class,
        com.skax.aiportal.client.sktai.interceptor.SktAiAuthInterceptor.class,
        com.skax.aiportal.client.sktai.interceptor.SktAiLoggingInterceptor.class
})
public interface SktAiTrainingEventClient {

    @GetMapping("/api/v1/finetuning/trainings/{training_id}/events")
    TrainingEventsResponse getTrainingEvents(@PathVariable("training_id") String trainingId,
                                             @RequestParam(value = "after", required = false) String after,
                                             @RequestParam(value = "limit", defaultValue = "100") Integer limit);
}
