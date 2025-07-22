package com.skax.aiportal.client.sktai.finetuning;

import com.skax.aiportal.client.sktai.config.SktAiClientConfig;
import com.skax.aiportal.client.sktai.finetuning.dto.request.TrainingTaskCallbackRequest;
import com.skax.aiportal.client.sktai.finetuning.dto.response.TrainingStatusResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "sktAiTrainingStatusClient", url = "${sktai.base-url}", configuration = SktAiClientConfig.class)
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
