package com.skax.aiportal.client.sktai.finetuning;

import com.skax.aiportal.client.sktai.config.SktAiClientConfig;
import com.skax.aiportal.client.sktai.finetuning.dto.response.TrainingEventsResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "sktAiTrainingEventClient", url = "${sktai.base-url}", configuration = SktAiClientConfig.class)
public interface SktAiTrainingEventClient {

    @GetMapping("/api/v1/finetuning/trainings/{training_id}/events")
    TrainingEventsResponse getTrainingEvents(@PathVariable("training_id") String trainingId,
                                             @RequestParam(value = "after", required = false) String after,
                                             @RequestParam(value = "limit", defaultValue = "100") Integer limit);
}
