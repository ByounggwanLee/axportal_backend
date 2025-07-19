package com.skax.aiportal.client.sktai.authorization.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Schema(description = "기본 정책")
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BasePolicy {
    @Schema(description = "정책 타입")
    @JsonProperty("type")
    private String type;

    @Schema(description = "로직")
    @JsonProperty("logic")
    @Builder.Default
    private String logic = "POSITIVE";

    @Schema(description = "이름 목록")
    @JsonProperty("names")
    private List<String> names;
}
