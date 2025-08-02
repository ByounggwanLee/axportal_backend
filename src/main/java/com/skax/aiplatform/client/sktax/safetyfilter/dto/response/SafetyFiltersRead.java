package com.skax.aiplatform.client.sktax.safetyfilter.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.skax.aiplatform.client.sktax.safetyfilter.dto.Payload;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Safety Filter 목록 조회 응답 DTO
 * OpenAPI 명세의 SafetyFiltersRead와 정확히 일치합니다.
 *
 * @author ByounggwanLee
 * @since 2025-01-01
 * @version 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SafetyFiltersRead {

    /**
     * Safety Filter 목록
     */
    @JsonProperty("data")
    private List<SafetyFilterRead> data;

    /**
     * 페이지네이션 정보
     */
    @JsonProperty("payload")
    private Payload payload;
}
