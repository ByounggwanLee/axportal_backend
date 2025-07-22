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
public class FinetuningResponse<T> {

    @JsonProperty("data")
    private T data;

    @JsonProperty("payload")
    private FinetuningPaginationResponse payload;
}
