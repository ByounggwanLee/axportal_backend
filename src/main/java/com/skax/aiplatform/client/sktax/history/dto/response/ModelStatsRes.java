package com.skax.aiplatform.client.sktax.history.dto.response;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 모델 통계 조회 응답
 * 
 * <p>모델 사용 통계 조회 결과를 정의합니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-08-02
 * @version 1.0
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "모델 통계 조회 응답")
public class ModelStatsRes {

    /**
     * 데이터 목록
     */
    @JsonProperty("data")
    @Valid
    @Schema(description = "모델 통계 데이터 목록", required = true)
    private List<Map<String, Object>> data;
}
