package com.skax.aiplatform.client.sktax.serving.dto;

/**
 * Serving Status Enum
 * 서빙 상태를 정의하는 열거형입니다.
 *
 * @author ByounggwanLee
 * @since 2025-01-01
 * @version 1.0
 */
public enum ServingStatus {
    /**
     * 준비 완료
     */
    READY("Ready"),

    /**
     * 인그레스 준비 완료
     */
    INGRESS_READY("IngressReady"),

    /**
     * 예측기 준비 완료
     */
    PREDICTOR_READY("PredictorReady"),

    /**
     * 라우터 준비 완료
     */
    ROUTERS_READY("RoutersReady"),

    /**
     * 예측기 실패
     */
    PREDICTOR_FAILED("PredictorFailed"),

    /**
     * 스케일링 중
     */
    SCALING("Scaling"),

    /**
     * 업데이트 중
     */
    UPDATING("Updating"),

    /**
     * 종료됨
     */
    TERMINATED("Terminated"),

    /**
     * 오류
     */
    ERROR("Error"),

    /**
     * 알 수 없음
     */
    UNKNOWN("Unknown"),

    /**
     * 배포 중
     */
    DEPLOYING("Deploying"),

    /**
     * 사용 가능
     */
    AVAILABLE("Available"),

    /**
     * 진행 중
     */
    PROGRESSING("Progressing"),

    /**
     * 실패
     */
    FAILED("Failed"),

    /**
     * 삭제 중
     */
    DELETING("Deleting"),

    /**
     * 중지됨
     */
    STOPPED("Stopped");

    private final String value;

    ServingStatus(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return value;
    }
}
