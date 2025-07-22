package com.skax.aiportal.client.sktai.finetuning;

import com.skax.aiportal.client.sktai.config.SktAiClientConfig;
import com.skax.aiportal.client.sktai.finetuning.dto.request.TrainerCreateRequest;
import com.skax.aiportal.client.sktai.finetuning.dto.request.TrainerUpdateRequest;
import com.skax.aiportal.client.sktai.finetuning.dto.response.FinetuningResponse;
import com.skax.aiportal.client.sktai.finetuning.dto.response.TrainerResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "sktAiTrainerClient", url = "${sktai.base-url}", configuration = SktAiClientConfig.class)
public interface SktAiTrainerClient {

    @PostMapping("/api/v1/finetuning/trainers")
    TrainerResponse createTrainer(@RequestBody TrainerCreateRequest request);

    @GetMapping("/api/v1/finetuning/trainers")
    FinetuningResponse<List<TrainerResponse>> getTrainers(@RequestParam(value = "page", defaultValue = "1") Integer page,
                                                          @RequestParam(value = "size", defaultValue = "10") Integer size,
                                                          @RequestParam(value = "sort", required = false) String sort,
                                                          @RequestParam(value = "filter", required = false) String filter,
                                                          @RequestParam(value = "search", required = false) String search);

    @GetMapping("/api/v1/finetuning/trainers/{trainer_id}")
    TrainerResponse getTrainer(@PathVariable("trainer_id") String trainerId);

    @PutMapping("/api/v1/finetuning/trainers/{trainer_id}")
    TrainerResponse updateTrainer(@PathVariable("trainer_id") String trainerId,
                                  @RequestBody TrainerUpdateRequest request);

    @DeleteMapping("/api/v1/finetuning/trainers/{trainer_id}")
    void deleteTrainer(@PathVariable("trainer_id") String trainerId);

    @PostMapping("/api/v1/finetuning/trainers/hard-delete")
    void hardDeleteTrainers();
}
