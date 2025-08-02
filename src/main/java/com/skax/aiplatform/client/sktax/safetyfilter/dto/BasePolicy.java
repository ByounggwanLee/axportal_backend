package com.skax.aiplatform.client.sktax.safetyfilter.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 기본 정책 DTO
 * Safety Filter의 접근 제어 정책을 정의합니다.
 *
 * @author ByounggwanLee
 * @since 2025-01-01
 * @version 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BasePolicy {

    /**
     * 정책 타입
     */
    @JsonProperty("type")
    @NotBlank(message = "정책 타입은 필수입니다")
    private String type; // "user", "group", "role", "token-exchange"

    /**
     * 논리 연산자
     */
    @JsonProperty("logic")
    private String logic = "POSITIVE"; // "NEGATIVE", "POSITIVE"

    /**
     * 이름 목록
     */
    @JsonProperty("names")
    @NotNull(message = "이름 목록은 필수입니다")
    private List<String> names;
}
