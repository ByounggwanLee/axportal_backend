package com.skax.aiplatform.client.sktax.modelgateway.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Audio Segment DTO
 * 
 * <p>오디오 세그먼트를 위한 데이터 전송 객체입니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-08-02
 * @version 1.0
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "오디오 세그먼트 DTO")
public class AudioSegment {

    /**
     * 세그먼트 ID
     */
    @Schema(description = "세그먼트 ID", example = "0")
    @JsonProperty("id")
    private Integer id;

    /**
     * 탐색 위치
     */
    @Schema(description = "탐색 위치", example = "0")
    @JsonProperty("seek")
    private Integer seek;

    /**
     * 시작 시간
     */
    @Schema(description = "시작 시간 (초)", example = "0.0")
    @JsonProperty("start")
    private Double start;

    /**
     * 종료 시간
     */
    @Schema(description = "종료 시간 (초)", example = "3.319999933242798")
    @JsonProperty("end")
    private Double end;

    /**
     * 세그먼트 텍스트
     */
    @Schema(description = "세그먼트 텍스트")
    @JsonProperty("text")
    private String text;

    /**
     * 토큰 목록
     */
    @Schema(description = "토큰 ID 목록")
    @JsonProperty("tokens")
    private List<Integer> tokens;

    /**
     * 온도
     */
    @Schema(description = "온도값", example = "0.0")
    @JsonProperty("temperature")
    private Double temperature;

    /**
     * 평균 로그 확률
     */
    @Schema(description = "평균 로그 확률", example = "-0.2860786020755768")
    @JsonProperty("avg_logprob")
    private Double avgLogprob;

    /**
     * 압축 비율
     */
    @Schema(description = "압축 비율", example = "1.236363649368286")
    @JsonProperty("compression_ratio")
    private Double compressionRatio;

    /**
     * 무음성 확률
     */
    @Schema(description = "무음성 확률", example = "0.00985979475080967")
    @JsonProperty("no_speech_prob")
    private Double noSpeechProb;
}
