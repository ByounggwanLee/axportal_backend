package com.skax.aiplatform.client.sktax.finetuning.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Training Progress DTO
 * 훈련 진행 상황을 나타내는 객체입니다.
 *
 * @author ByounggwanLee
 * @since 2025-01-01
 * @version 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Progress {

    /**
     * 진행률 (0.0 ~ 100.0)
     */
    @JsonProperty("percentage")
    private Double percentage;

    /**
     * 현재 epoch
     */
    @JsonProperty("current_epoch")
    private Integer currentEpoch;

    /**
     * 전체 epoch 수
     */
    @JsonProperty("total_epochs")
    private Integer totalEpochs;

    /**
     * 훈련 손실값
     */
    @JsonProperty("training_loss")
    private Double trainingLoss;

    /**
     * 평가 손실값
     */
    @JsonProperty("eval_loss")
    private Double evalLoss;

    /**
     * 현재 스텝
     */
    @JsonProperty("current_step")
    private Integer currentStep;

    /**
     * 전체 스텝 수
     */
    @JsonProperty("total_steps")
    private Integer totalSteps;
}
