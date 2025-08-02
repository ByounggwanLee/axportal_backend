package com.skax.aiplatform.client.sktax.serving.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Serving Parameters DTO
 * 서빙 파라미터 설정을 나타내는 클래스입니다.
 *
 * @author ByounggwanLee
 * @since 2025-01-01
 * @version 1.0
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ServingParams {

    /**
     * 실시간 양자화 활성화 여부
     */
    @JsonProperty("inflight_quantization")
    private Boolean inflightQuantization;

    /**
     * 양자화 타입
     */
    @JsonProperty("quantization")
    private String quantization;

    /**
     * 모델의 데이터 타입 설정
     */
    @JsonProperty("dtype")
    private String dtype;

    /**
     * GPU 메모리 사용률 조정
     */
    @JsonProperty("gpu_memory_utilization")
    private Double gpuMemoryUtilization;

    /**
     * 최적화된 모델 형식 선택
     */
    @JsonProperty("load_format")
    private String loadFormat;

    /**
     * 다중 GPU 사용 시 병렬화 설정
     */
    @JsonProperty("tensor_parallel_size")
    private Integer tensorParallelSize;

    /**
     * GPU 메모리 부족 시 사용할 최대 CPU 메모리 (GB)
     */
    @JsonProperty("cpu_offload_gb")
    private Integer cpuOffloadGb;

    /**
     * 디버깅이나 개발을 위한 즉시 실행 모드 강제 설정
     */
    @JsonProperty("enforce_eager")
    private Boolean enforceEager;

    /**
     * 최대 모델 길이 제한 설정
     */
    @JsonProperty("max_model_len")
    private Integer maxModelLen;

    /**
     * vllm v1 엔진 또는 v0 엔진 사용 설정
     */
    @JsonProperty("vllm_use_v1")
    private String vllmUseV1;

    /**
     * 반복당 최대 시퀀스 수 설정
     */
    @JsonProperty("max_num_seqs")
    private Integer maxNumSeqs;

    /**
     * 각 프롬프트에 대해 허용할 멀티모달 입력 인스턴스 수 제한
     */
    @JsonProperty("limit_mm_per_prompt")
    private String limitMmPerPrompt;

    /**
     * 모델의 토크나이저 모드 설정
     */
    @JsonProperty("tokenizer_mode")
    private String tokenizerMode;

    /**
     * 모델의 설정 형식 설정
     */
    @JsonProperty("config_format")
    private String configFormat;

    /**
     * HuggingFace에서 원격 코드 신뢰 여부
     */
    @JsonProperty("trust_remote_code")
    private Boolean trustRemoteCode;

    /**
     * HuggingFace 설정을 위한 추가 인수
     */
    @JsonProperty("hf_overrides")
    private Object hfOverrides;

    /**
     * 멀티모달 입력 매핑/처리를 위한 오버라이드
     */
    @JsonProperty("mm_processor_kwargs")
    private Object mmProcessorKwargs;

    /**
     * 멀티모달 전처리기/매퍼 캐싱 비활성화 여부
     */
    @JsonProperty("disable_mm_preprocessor_cache")
    private Boolean disableMmPreprocessorCache;

    /**
     * 지원되는 모델에 대한 자동 도구 선택 활성화
     */
    @JsonProperty("enable_auto_tool_choice")
    private Boolean enableAutoToolChoice;

    /**
     * 사용 중인 모델에 따른 도구 호출 파서 선택
     */
    @JsonProperty("tool_call_parser")
    private String toolCallParser;

    /**
     * 도구 파서 플러그인 지정
     */
    @JsonProperty("tool_parser_plugin")
    private String toolParserPlugin;

    /**
     * 채팅 템플릿 파일 경로 또는 단일 라인 형태의 템플릿
     */
    @JsonProperty("chat_template")
    private String chatTemplate;

    /**
     * 가이드된 디코딩을 위한 엔진 선택
     */
    @JsonProperty("guided_decoding_backend")
    private String guidedDecodingBackend;

    /**
     * 모델에 대한 추론 활성화 여부
     */
    @JsonProperty("enable_reasoning")
    private Boolean enableReasoning;

    /**
     * 사용 중인 모델에 따른 추론 파서 선택
     */
    @JsonProperty("reasoning_parser")
    private String reasoningParser;
}
