package com.skax.aiportal.client.sktai.serving.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 서빙 파라미터 클래스
 * 
 * 모델 서빙을 위한 다양한 설정 파라미터를 담습니다.
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ServingParams {

    /**
     * 실시간 양자화 사용 여부
     */
    @JsonProperty("inflight_quantization")
    private Boolean inflightQuantization;

    /**
     * 양자화 타입
     */
    @JsonProperty("quantization")
    private String quantization;

    /**
     * 모델의 데이터 타입
     */
    @JsonProperty("dtype")
    private String dtype;

    /**
     * GPU 메모리 사용률
     */
    @JsonProperty("gpu_memory_utilization")
    private Double gpuMemoryUtilization;

    /**
     * 로드 형식
     */
    @JsonProperty("load_format")
    private String loadFormat;

    /**
     * 텐서 병렬 크기
     */
    @JsonProperty("tensor_parallel_size")
    private Integer tensorParallelSize;

    /**
     * CPU 오프로드 GB
     */
    @JsonProperty("cpu_offload_gb")
    private Integer cpuOffloadGb;

    /**
     * Eager 실행 모드 강제 사용
     */
    @JsonProperty("enforce_eager")
    private Boolean enforceEager;

    /**
     * 최대 모델 길이
     */
    @JsonProperty("max_model_len")
    private Integer maxModelLen;

    /**
     * VLLM V1 엔진 사용 여부
     */
    @JsonProperty("vllm_use_v1")
    private String vllmUseV1;

    /**
     * 최대 시퀀스 수
     */
    @JsonProperty("max_num_seqs")
    private Integer maxNumSeqs;

    /**
     * 프롬프트당 멀티미디어 제한
     */
    @JsonProperty("limit_mm_per_prompt")
    private String limitMmPerPrompt;

    /**
     * 토크나이저 모드
     */
    @JsonProperty("tokenizer_mode")
    private String tokenizerMode;

    /**
     * 설정 형식
     */
    @JsonProperty("config_format")
    private String configFormat;

    /**
     * 원격 코드 신뢰 여부
     */
    @JsonProperty("trust_remote_code")
    private Boolean trustRemoteCode;

    /**
     * HuggingFace 오버라이드
     */
    @JsonProperty("hf_overrides")
    private Object hfOverrides;

    /**
     * 멀티미디어 프로세서 설정
     */
    @JsonProperty("mm_processor_kwargs")
    private Object mmProcessorKwargs;

    /**
     * 멀티미디어 전처리기 캐시 비활성화
     */
    @JsonProperty("disable_mm_preprocessor_cache")
    private Boolean disableMmPreprocessorCache;

    /**
     * 자동 도구 선택 활성화
     */
    @JsonProperty("enable_auto_tool_choice")
    private Boolean enableAutoToolChoice;

    /**
     * 도구 호출 파서
     */
    @JsonProperty("tool_call_parser")
    private String toolCallParser;

    /**
     * 도구 파서 플러그인
     */
    @JsonProperty("tool_parser_plugin")
    private String toolParserPlugin;

    /**
     * 채팅 템플릿
     */
    @JsonProperty("chat_template")
    private String chatTemplate;

    /**
     * 가이드 디코딩 백엔드
     */
    @JsonProperty("guided_decoding_backend")
    private String guidedDecodingBackend;

    /**
     * 추론 활성화 여부
     */
    @JsonProperty("enable_reasoning")
    private Boolean enableReasoning;

    /**
     * 추론 파서
     */
    @JsonProperty("reasoning_parser")
    private String reasoningParser;
}
