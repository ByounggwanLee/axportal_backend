package com.skax.aiportal.client.sktai.finetuning.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TrainingEventResponse {

    @JsonProperty("time")
    private String time;

    @JsonProperty("log")
    private String log;
}
