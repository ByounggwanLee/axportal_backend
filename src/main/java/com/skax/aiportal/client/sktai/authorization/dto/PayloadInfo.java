package com.skax.aiportal.client.sktai.authorization.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Schema(description = "페이징 정보")
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PayloadInfo {

    @Schema(description = "페이징 정보")
    @JsonProperty("pagination")
    private PaginationInfo pagination;
}
