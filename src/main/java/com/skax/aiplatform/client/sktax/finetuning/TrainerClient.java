package com.skax.aiplatform.client.sktax.finetuning;

import com.skax.aiplatform.client.sktax.config.SktAxFeignConfig;
import com.skax.aiplatform.client.sktax.finetuning.dto.request.TrainerCreate;
import com.skax.aiplatform.client.sktax.finetuning.dto.request.TrainerUpdate;
import com.skax.aiplatform.client.sktax.finetuning.dto.response.TrainerRead;
import com.skax.aiplatform.client.sktax.finetuning.dto.response.TrainersRead;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

/**
 * SKT AX Fine-tuning API - Trainer Feign Client
 * 파인튜닝 트레이너 관련 API를 호출하는 Feign Client입니다.
 *
 * @author ByounggwanLee
 * @since 2025-01-01
 * @version 1.0
 */
@FeignClient(
    name = "skt-ax-finetuning-trainer-client",
    url = "${skt-ax.finetuning.base-url:https://aip-stg.sktai.io}",
    configuration = SktAxFeignConfig.class
)
public interface TrainerClient {

    /**
     * Trainer 등록
     */
    @PostMapping("/api/v1/finetuning/trainers")
    TrainerRead registerTrainer(@RequestBody TrainerCreate request);

    /**
     * Trainer 목록 조회
     */
    @GetMapping("/api/v1/finetuning/trainers")
    TrainersRead readTrainers(
        @RequestParam(value = "page", defaultValue = "1") Integer page,
        @RequestParam(value = "size", defaultValue = "10") Integer size,
        @RequestParam(value = "sort", required = false) String sort,
        @RequestParam(value = "filter", required = false) String filter,
        @RequestParam(value = "search", required = false) String search
    );

    /**
     * Trainer 상세 조회
     */
    @GetMapping("/api/v1/finetuning/trainers/{trainer_id}")
    TrainerRead readTrainer(@PathVariable("trainer_id") UUID trainerId);

    /**
     * Trainer 수정
     */
    @PutMapping("/api/v1/finetuning/trainers/{trainer_id}")
    TrainerRead editTrainer(
        @PathVariable("trainer_id") UUID trainerId,
        @RequestBody TrainerUpdate request
    );

    /**
     * Trainer 삭제
     */
    @DeleteMapping("/api/v1/finetuning/trainers/{trainer_id}")
    void removeTrainer(@PathVariable("trainer_id") UUID trainerId);

    /**
     * Trainer 하드 삭제
     */
    @PostMapping("/api/v1/finetuning/trainers/hard-delete")
    Object hardRemoveTrainer();
}
