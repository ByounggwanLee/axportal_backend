package com.skax.aiportal.client.sktai.safetyfilter.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.skax.aiportal.client.sktai.safetyfilter.dto.Pagination;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 안전 필터 목록 응답 DTO
 * 
 * 페이지네이션 정보와 함께 안전 필터 목록을 반환합니다.
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SafetyFilterListResponse {

    /**
     * 안전 필터 목록
     */
    @JsonProperty("data")
    private List<SafetyFilterResponse> data;

    /**
     * 페이지네이션 정보
     */
    @JsonProperty("payload")
    private PayloadInfo payload;

    /**
     * 페이로드 정보 클래스
     */
    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class PayloadInfo {

        /**
         * 페이지네이션 정보
         */
        @JsonProperty("pagination")
        private Pagination pagination;
    }
}
