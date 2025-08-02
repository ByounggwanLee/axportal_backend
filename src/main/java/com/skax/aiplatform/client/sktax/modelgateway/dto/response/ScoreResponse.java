package com.skax.aiplatform.client.sktax.modelgateway.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.skax.aiplatform.client.sktax.modelgateway.dto.ScoreData;
import com.skax.aiplatform.client.sktax.modelgateway.dto.Usage;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Score Response DTO
 * 
 * <p>점수 계산 응답을 위한 데이터 전송 객체입니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-08-02
 * @version 1.0
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "점수 계산 응답 DTO")
public class ScoreResponse {

    /**
     * 응답 ID
     */
    @Schema(description = "점수 계산 응답 ID", example = "score-3aa2237ab67d48cb9d0e232f91c32100")
    @JsonProperty("id")
    private String id;

    /**
     * 객체 타입
     */
    @Schema(description = "응답 객체 타입", example = "list")
    @JsonProperty("object")
    private String object;

    /**
     * 생성 시간
     */
    @Schema(description = "응답 생성 시간 (Unix 타임스탬프)", example = "191006")
    @JsonProperty("created")
    private Long created;

    /**
     * 사용된 모델
     */
    @Schema(description = "사용된 모델명", example = "BAAI/bge-reranker-v2-m3")
    @JsonProperty("model")
    private String model;

    /**
     * 점수 데이터 목록
     */
    @Schema(description = "계산된 점수 데이터 목록")
    @JsonProperty("data")
    private List<ScoreData> data;

    /**
     * 토큰 사용량
     */
    @Schema(description = "토큰 사용량 정보")
    @JsonProperty("usage")
    private Usage usage;
}
