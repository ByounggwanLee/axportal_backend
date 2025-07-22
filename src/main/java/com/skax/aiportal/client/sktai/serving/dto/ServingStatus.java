package com.skax.aiportal.client.sktai.serving.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 서빙 상태 열거형
 * 
 * 서빙의 다양한 상태를 정의합니다.
 */
public enum ServingStatus {

    @JsonProperty("Ready")
    READY,

    @JsonProperty("IngressReady")
    INGRESS_READY,

    @JsonProperty("PredictorReady")
    PREDICTOR_READY,

    @JsonProperty("RoutesReady")
    ROUTES_READY,

    @JsonProperty("PredictorFailed")
    PREDICTOR_FAILED,

    @JsonProperty("Scaling")
    SCALING,

    @JsonProperty("Updating")
    UPDATING,

    @JsonProperty("Terminated")
    TERMINATED,

    @JsonProperty("Error")
    ERROR,

    @JsonProperty("Unknown")
    UNKNOWN,

    @JsonProperty("Deploying")
    DEPLOYING,

    @JsonProperty("Available")
    AVAILABLE,

    @JsonProperty("Progressing")
    PROGRESSING,

    @JsonProperty("Failed")
    FAILED,

    @JsonProperty("Deleting")
    DELETING,

    @JsonProperty("Stopped")
    STOPPED
}
