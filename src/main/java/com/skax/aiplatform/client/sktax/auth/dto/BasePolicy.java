package com.skax.aiplatform.client.sktax.auth.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 기본 정책 DTO
 * 
 * <p>OpenAPI 스키마명: BasePolicy</p>
 * 
 * @author ByounggwanLee
 * @since 2025-08-01
 * @version 1.0
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "기본 정책")
public class BasePolicy {

    @JsonProperty("type")
    @Schema(description = "정책 타입", allowableValues = {"user", "group", "role", "token-exchange"}, required = true)
    private String type;

    @JsonProperty("logic")
    @Schema(description = "논리 연산자", allowableValues = {"NEGATIVE", "POSITIVE"}, defaultValue = "POSITIVE")
    @Builder.Default
    private String logic = "POSITIVE";

    @JsonProperty("names")
    @Schema(description = "대상 이름 목록", required = true)
    private List<String> names;
}
