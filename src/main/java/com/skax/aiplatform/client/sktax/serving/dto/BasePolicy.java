package com.skax.aiplatform.client.sktax.serving.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Base Policy DTO
 * 정책 기본 정보를 나타내는 클래스입니다.
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
    private PolicyTypeEnum type;

    /**
     * 로직 타입
     */
    @JsonProperty("logic")
    private PolicyLogicEnum logic = PolicyLogicEnum.POSITIVE;

    /**
     * 정책 이름 목록
     */
    @JsonProperty("names")
    private java.util.List<String> names;
}
