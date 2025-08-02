package com.skax.aiplatform.client.sktax.history.dto.response;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.skax.aiplatform.client.sktax.history.dto.Payload;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 에이전트 히스토리 조회 응답
 * 
 * <p>에이전트 사용 히스토리 조회 결과를 정의합니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-08-02
 * @version 1.0
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "에이전트 히스토리 조회 응답")
public class AgentHistoryRes {

    /**
     * 데이터 목록
     */
    @JsonProperty("data")
    @Valid
    @Schema(description = "에이전트 히스토리 데이터 목록", required = true)
    private List<Map<String, Object>> data;

    /**
     * 페이로드 정보
     */
    @JsonProperty("payload")
    @Valid
    @Schema(description = "페이징 정보", required = true)
    private Payload payload;
}
