package com.skax.aiplatform.client.sktax.modelgateway;

import com.skax.aiplatform.client.sktax.modelgateway.dto.request.AudioSpeechRequest;
import com.skax.aiplatform.client.sktax.modelgateway.dto.request.AudioTranscriptionMultipartRequest;
import com.skax.aiplatform.client.sktax.modelgateway.dto.request.AudioTranslationMultipartRequest;
import com.skax.aiplatform.client.sktax.config.SktAxFeignConfig;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * Model Gateway Audio Client
 * 
 * <p>모델 게이트웨이의 오디오 관련 API를 호출하는 Feign Client입니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-08-02
 * @version 1.0
 */
@Tag(name = "Model Gateway Audio API", description = "모델 게이트웨이 오디오 API")
@FeignClient(
    name = "modelGatewayAudioClient",
    url = "${feign.client.model-gateway.url:https://aip-stg.sktai.io}",
    configuration = SktAxFeignConfig.class
)
public interface AudioClient {

    /**
     * 오디오 전사 API
     * 
     * @param request 오디오 전사 요청
     * @return 오디오 전사 응답
     */
    @Operation(summary = "오디오 전사", description = "오디오 파일을 텍스트로 전사합니다.")
    @PostMapping(
        value = "/api/v1/gateway/audio/transcriptions",
        consumes = MediaType.MULTIPART_FORM_DATA_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    ResponseEntity<Object> audioTranscriptions(AudioTranscriptionMultipartRequest request);

    /**
     * 오디오 번역 API
     * 
     * @param request 오디오 번역 요청
     * @return 오디오 번역 응답
     */
    @Operation(summary = "오디오 번역", description = "오디오 파일을 영어로 번역합니다.")
    @PostMapping(
        value = "/api/v1/gateway/audio/translations",
        consumes = MediaType.MULTIPART_FORM_DATA_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    ResponseEntity<Object> audioTranslations(AudioTranslationMultipartRequest request);

    /**
     * 음성 생성 API
     * 
     * @param request 음성 생성 요청
     * @return 음성 생성 응답
     */
    @Operation(summary = "음성 생성", description = "텍스트를 음성으로 변환합니다.")
    @PostMapping(
        value = "/api/v1/gateway/audio/speech",
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = {MediaType.APPLICATION_JSON_VALUE, "audio/mpeg"}
    )
    ResponseEntity<Object> audioSpeech(@RequestBody AudioSpeechRequest request);
}
