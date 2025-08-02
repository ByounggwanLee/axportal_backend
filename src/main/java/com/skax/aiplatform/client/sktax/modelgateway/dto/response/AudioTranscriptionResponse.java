package com.skax.aiplatform.client.sktax.modelgateway.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.skax.aiplatform.client.sktax.modelgateway.dto.AudioSegment;
import com.skax.aiplatform.client.sktax.modelgateway.dto.AudioWord;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Audio Transcription Response DTO
 * 
 * <p>오디오 전사 응답을 위한 데이터 전송 객체입니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-08-02
 * @version 1.0
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "오디오 전사 응답 DTO")
public class AudioTranscriptionResponse {

    /**
     * 작업 타입
     */
    @Schema(description = "작업 타입", example = "transcribe")
    @JsonProperty("task")
    private String task;

    /**
     * 언어
     */
    @Schema(description = "감지된 언어", example = "english")
    @JsonProperty("language")
    private String language;

    /**
     * 오디오 길이
     */
    @Schema(description = "오디오 길이 (초)", example = "8.470000267028809")
    @JsonProperty("duration")
    private Double duration;

    /**
     * 전사된 텍스트
     */
    @Schema(description = "전사된 전체 텍스트")
    @JsonProperty("text")
    private String text;

    /**
     * 세그먼트 목록
     */
    @Schema(description = "오디오 세그먼트 목록")
    @JsonProperty("segments")
    private List<AudioSegment> segments;

    /**
     * 단어 목록
     */
    @Schema(description = "단어별 타이밍 정보")
    @JsonProperty("words")
    private List<AudioWord> words;
}
