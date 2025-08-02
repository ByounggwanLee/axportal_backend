package com.skax.aiplatform.client.sktax.modelgateway.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

/**
 * Audio Transcriptions 멀티파트 요청 DTO
 * 
 * <p>Model Gateway의 오디오 전사 API 멀티파트 요청을 위한 데이터 전송 객체입니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-08-02
 * @version 1.0
 */
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Schema(description = "오디오 전사 멀티파트 요청")
public class AudioTranscriptionMultipartRequest {

    /**
     * 오디오 파일
     */
    @Schema(description = "전사할 오디오 파일", required = true)
    @NotNull(message = "오디오 파일은 필수입니다")
    private MultipartFile file;

    /**
     * 사용할 모델 ID
     */
    @Schema(description = "사용할 모델 ID", example = "whisper-1", required = true)
    @NotNull(message = "모델 ID는 필수입니다")
    private String model;

    /**
     * 프롬프트 (선택사항)
     */
    @Schema(description = "전사를 가이드하는 프롬프트", example = "이것은 한국어 오디오입니다")
    private String prompt;

    /**
     * 언어 코드 (선택사항)
     */
    @Schema(description = "오디오 언어 코드", example = "ko")
    private String language;

    /**
     * 응답 형식 (선택사항)
     */
    @Schema(description = "응답 형식", example = "json")
    private String responseFormat;

    /**
     * 스트리밍 여부 (선택사항)
     */
    @Schema(description = "스트리밍 응답 여부", example = "false")
    private String stream;
}
