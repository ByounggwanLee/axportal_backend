package com.skax.aiportal.client.sktai.serving.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;

/**
 * 서빙 상태 열거형
 * 
 * <p>SKT AI 모델 서빙의 다양한 상태를 정의합니다.
 * 모델 배포부터 운영, 종료까지의 전체 라이프사이클을 포함합니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-07-23
 * @version 1.0
 */
@Schema(
    title = "서빙 상태",
    description = "SKT AI 모델 서빙의 상태 정보"
)
public enum ServingStatus {

    /**
     * 준비 완료 상태
     */
    @Schema(description = "서빙이 준비되어 요청을 처리할 수 있는 상태")
    @JsonProperty("Ready")
    READY,

    /**
     * 인그레스 준비 완료 상태
     */
    @Schema(description = "인그레스가 준비되어 외부 요청을 받을 수 있는 상태")
    @JsonProperty("IngressReady")
    INGRESS_READY,

    /**
     * 예측기 준비 완료 상태
     */
    @Schema(description = "모델 예측기가 준비되어 추론이 가능한 상태")
    @JsonProperty("PredictorReady")
    PREDICTOR_READY,

    /**
     * 라우트 준비 완료 상태
     */
    @Schema(description = "네트워크 라우팅이 설정되어 트래픽 전달이 가능한 상태")
    @JsonProperty("RoutesReady")
    ROUTES_READY,

    /**
     * 예측기 실패 상태
     */
    @Schema(description = "모델 예측기에 오류가 발생한 상태")
    @JsonProperty("PredictorFailed")
    PREDICTOR_FAILED,

    /**
     * 스케일링 중 상태
     */
    @Schema(description = "인스턴스 수가 조정되고 있는 상태")
    @JsonProperty("Scaling")
    SCALING,

    /**
     * 업데이트 중 상태
     */
    @Schema(description = "서빙 설정이나 모델이 업데이트되고 있는 상태")
    @JsonProperty("Updating")
    UPDATING,

    /**
     * 종료된 상태
     */
    @Schema(description = "서빙이 종료된 상태")
    @JsonProperty("Terminated")
    TERMINATED,

    /**
     * 오류 상태
     */
    @Schema(description = "서빙 처리 중 오류가 발생한 상태")
    @JsonProperty("Error")
    ERROR,

    /**
     * 알 수 없는 상태
     */
    @Schema(description = "상태를 확인할 수 없는 상태")
    @JsonProperty("Unknown")
    UNKNOWN,

    /**
     * 배포 중 상태
     */
    @Schema(description = "모델이 배포되고 있는 상태")
    @JsonProperty("Deploying")
    DEPLOYING,

    /**
     * 사용 가능한 상태
     */
    @Schema(description = "서빙이 사용 가능한 상태")
    @JsonProperty("Available")
    AVAILABLE,

    /**
     * 진행 중 상태
     */
    @Schema(description = "배포나 업데이트가 진행 중인 상태")
    @JsonProperty("Progressing")
    PROGRESSING,

    @JsonProperty("Failed")
    FAILED,

    @JsonProperty("Deleting")
    DELETING,

    @JsonProperty("Stopped")
    STOPPED
}
