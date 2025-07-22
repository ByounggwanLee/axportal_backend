package com.skax.aiportal.client.sktai.finetuning;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.skax.aiportal.client.sktai.finetuning.dto.request.TrainingTaskCallbackRequest;
import com.skax.aiportal.client.sktai.finetuning.dto.response.TrainingStatusResponse;

@FeignClient(name = "sktAiTrainingStatusClient", url = "${sktai.api.base-url:https://aip-stg.sktai.io}", configuration = {
        com.skax.aiportal.client.sktai.config.SktAiClientConfig.class,
        com.skax.aiportal.client.sktai.interceptor.SktAiAuthInterceptor.class,
        com.skax.aiportal.client.sktai.interceptor.SktAiLoggingInterceptor.class
})
public interface SktAiTrainingStatusClient {

    @GetMapping("/api/v1/finetuning/trainings/{training_id}/status")
    TrainingStatusResponse getTrainingStatus(@PathVariable("training_id") String trainingId);

    @PutMapping("/api/v1/finetuning/trainings/{ref_id}/status")
    Object updateTrainingStatus(@PathVariable("ref_id") String refId,
                                @RequestBody TrainingTaskCallbackRequest request);

    @PostMapping("/api/v1/finetuning/trainings/hook")
    Object hookTrainings(@RequestParam(value = "cycle", defaultValue = "5") Integer cycle,
                         @RequestParam(value = "timeout", defaultValue = "1800") Integer timeout,
                         @RequestBody List<String> ids);
}
