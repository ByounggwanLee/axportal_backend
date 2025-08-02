package com.skax.aiplatform.client.sktax.modelgateway.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Audio Word DTO
 * 
 * <p>오디오 단어 타이밍을 위한 데이터 전송 객체입니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-08-02
 * @version 1.0
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "오디오 단어 DTO")
public class AudioWord {

    /**
     * 시작 시간
     */
    @Schema(description = "단어 시작 시간 (초)", example = "0.0")
    @JsonProperty("start")
    private Double start;

    /**
     * 종료 시간
     */
    @Schema(description = "단어 종료 시간 (초)", example = "3.319999933242798")
    @JsonProperty("end")
    private Double end;

    /**
     * 단어
     */
    @Schema(description = "인식된 단어")
    @JsonProperty("word")
    private String word;
}
