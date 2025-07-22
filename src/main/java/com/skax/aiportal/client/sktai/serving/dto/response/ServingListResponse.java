package com.skax.aiportal.client.sktai.serving.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.skax.aiportal.client.sktai.serving.dto.Pagination;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 페이지네이션된 서빙 목록 응답 DTO
 * 
 * 서빙 목록 조회 시 페이지네이션 정보와 함께 반환되는 응답 데이터를 담습니다.
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ServingListResponse {

    /**
     * 서빙 목록
     */
    @JsonProperty("data")
    private java.util.List<ServingResponse> data;

    /**
     * 페이지네이션 정보
     */
    @JsonProperty("pagination")
    private Pagination pagination;
}
