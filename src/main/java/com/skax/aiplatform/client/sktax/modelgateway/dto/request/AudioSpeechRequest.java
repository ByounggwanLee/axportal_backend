package com.skax.aiplatform.client.sktax.modelgateway.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Audio Speech Request DTO
 * 
 * <p>음성 생성 요청을 위한 데이터 전송 객체입니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-08-02
 * @version 1.0
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "음성 생성 요청 DTO")
public class AudioSpeechRequest {

    /**
     * 모델명
     */
    @Schema(description = "사용할 모델명", example = "tts-1", required = true)
    @JsonProperty("model")
    @NotBlank(message = "모델명은 필수입니다")
    private String model;

    /**
     * 입력 텍스트
     */
    @Schema(description = "음성으로 변환할 텍스트", example = "The quick brown fox jumped over the lazy dog.", required = true)
    @JsonProperty("input")
    @NotBlank(message = "입력 텍스트는 필수입니다")
    private String input;

    /**
     * 음성 종류
     */
    @Schema(description = "음성 종류", example = "alloy", defaultValue = "alloy")
    @JsonProperty("voice")
    @Builder.Default
    private String voice = "alloy";

    /**
     * 응답 형식
     */
    @Schema(description = "응답 형식", example = "mp3", defaultValue = "mp3", 
            allowableValues = {"mp3", "opus", "aac", "flac", "wav", "pcm"})
    @JsonProperty("response_format")
    @Builder.Default
    private String responseFormat = "mp3";

    /**
     * 음성 속도
     */
    @Schema(description = "음성 속도", example = "1.0")
    @JsonProperty("speed")
    private Double speed;
}
