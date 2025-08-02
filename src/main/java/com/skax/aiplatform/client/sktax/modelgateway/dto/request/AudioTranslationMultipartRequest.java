package com.skax.aiplatform.client.sktax.modelgateway.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

/**
 * Audio Translations 멀티파트 요청 DTO
 * 
 * <p>Model Gateway의 오디오 번역 API 멀티파트 요청을 위한 데이터 전송 객체입니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-08-02
 * @version 1.0
 */
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Schema(description = "오디오 번역 멀티파트 요청")
public class AudioTranslationMultipartRequest {

    /**
     * 오디오 파일
     */
    @Schema(description = "번역할 오디오 파일", required = true)
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
    @Schema(description = "번역을 가이드하는 프롬프트", example = "번역해주세요")
    private String prompt;

    /**
     * 응답 형식 (선택사항)
     */
    @Schema(description = "응답 형식", example = "json")
    private String responseFormat;
}
