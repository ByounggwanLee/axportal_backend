package com.skax.aiportal.client.sktai.finetuning.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TrainerResponse {

    @JsonProperty("registry_url")
    private String registryUrl;

    @JsonProperty("description")
    private String description;

    @JsonProperty("default_params")
    private String defaultParams;

    @JsonProperty("id")
    private String id;

    @JsonProperty("created_at")
    private LocalDateTime createdAt;

    @JsonProperty("updated_at")
    private LocalDateTime updatedAt;
}
