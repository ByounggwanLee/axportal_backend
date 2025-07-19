package com.skax.aiportal.client.sktai.data.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.extern.jackson.Jacksonized;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import java.util.List;

/**
 * 기본 정책 클래스
 * 
 * <p>SKT AI 플랫폼의 기본 정책 정보를 담는 클래스입니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-07-19
 * @version 1.0
 */
@Getter
@Builder
@Jacksonized
public class BasePolicy {

    /**
     * 정책 타입 (user, group, role, token-exchange)
     */
    @NotBlank(message = "정책 타입은 필수입니다")
    @JsonProperty("type")
    private String type;

    /**
     * 정책 로직 (NEGATIVE, POSITIVE)
     */
    @JsonProperty("logic")
    @Builder.Default
    private String logic = "POSITIVE";

    /**
     * 정책 대상 이름 목록
     */
    @NotEmpty(message = "정책 대상 이름은 최소 하나 이상 필요합니다")
    @JsonProperty("names")
    private List<String> names;
}
