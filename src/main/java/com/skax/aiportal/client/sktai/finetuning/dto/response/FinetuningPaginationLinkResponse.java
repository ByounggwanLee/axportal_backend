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
public class FinetuningPaginationLinkResponse {

    @JsonProperty("url")
    private String url;

    @JsonProperty("label")
    private String label;

    @JsonProperty("active")
    private Boolean active;

    @JsonProperty("page")
    private Integer page;
}
