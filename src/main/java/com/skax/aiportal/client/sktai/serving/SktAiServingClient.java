package com.skax.aiportal.client.sktai.serving;

import com.skax.aiportal.client.sktai.serving.dto.request.ServingCreateRequest;
import com.skax.aiportal.client.sktai.serving.dto.request.ServingUpdateRequest;
import com.skax.aiportal.client.sktai.serving.dto.request.ServingScaleRequest;
import com.skax.aiportal.client.sktai.serving.dto.response.ServingResponse;
import com.skax.aiportal.client.sktai.serving.dto.response.ServingListResponse;
import com.skax.aiportal.client.sktai.serving.dto.response.ServingModelViewResponse;
import com.skax.aiportal.client.sktai.config.SktAiClientConfig;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * SKT AI 서빙 API Feign 클라이언트
 * 
 * 모델 서빙 관련 API 엔드포인트를 담당합니다.
 * - 서빙 생성, 조회, 수정, 삭제
 * - 서빙 시작, 중지, 스케일링
 * - 서빙 가능한 모델 조회
 */
@FeignClient(
    name = "sktai-serving-client",
    url = "${sktai.api.base-url:https://aip-stg.sktai.io}",
    configuration = SktAiClientConfig.class,
    path = "/api/v1"
)
public interface SktAiServingClient {

    /**
     * 서빙 목록 조회
     * 
     * @param page 페이지 번호 (1부터 시작)
     * @param size 페이지 크기
     * @param search 검색어
     * @param status 상태 필터
     * @param modelType 모델 타입 필터
     * @return 서빙 목록 응답
     */
    @GetMapping("/servings")
    ServingListResponse getServings(
        @RequestParam(value = "page", defaultValue = "1") Integer page,
        @RequestParam(value = "size", defaultValue = "20") Integer size,
        @RequestParam(value = "search", required = false) String search,
        @RequestParam(value = "status", required = false) String status,
        @RequestParam(value = "model_type", required = false) String modelType
    );

    /**
     * 서빙 생성
     * 
     * @param request 서빙 생성 요청
     * @return 생성된 서빙 정보
     */
    @PostMapping("/servings")
    ServingResponse createServing(@RequestBody ServingCreateRequest request);

    /**
     * 서빙 상세 조회
     * 
     * @param servingId 서빙 ID
     * @return 서빙 상세 정보
     */
    @GetMapping("/servings/{servingId}")
    ServingResponse getServing(@PathVariable("servingId") String servingId);

    /**
     * 서빙 수정
     * 
     * @param servingId 서빙 ID
     * @param request 서빙 수정 요청
     * @return 수정된 서빙 정보
     */
    @PutMapping("/servings/{servingId}")
    ServingResponse updateServing(
        @PathVariable("servingId") String servingId,
        @RequestBody ServingUpdateRequest request
    );

    /**
     * 서빙 삭제
     * 
     * @param servingId 서빙 ID
     */
    @DeleteMapping("/servings/{servingId}")
    void deleteServing(@PathVariable("servingId") String servingId);

    /**
     * 서빙 시작
     * 
     * @param servingId 서빙 ID
     * @return 서빙 정보
     */
    @PostMapping("/servings/{servingId}/start")
    ServingResponse startServing(@PathVariable("servingId") String servingId);

    /**
     * 서빙 중지
     * 
     * @param servingId 서빙 ID
     * @return 서빙 정보
     */
    @PostMapping("/servings/{servingId}/stop")
    ServingResponse stopServing(@PathVariable("servingId") String servingId);

    /**
     * 서빙 스케일링
     * 
     * @param servingId 서빙 ID
     * @param request 스케일링 요청
     * @return 서빙 정보
     */
    @PostMapping("/servings/{servingId}/autoscale")
    ServingResponse scaleServing(
        @PathVariable("servingId") String servingId,
        @RequestBody ServingScaleRequest request
    );

    /**
     * 서빙 가능한 모델 조회
     * 
     * @param page 페이지 번호 (1부터 시작)
     * @param size 페이지 크기
     * @param search 검색어
     * @param modelType 모델 타입 필터
     * @return 서빙 가능한 모델 목록
     */
    @GetMapping("/serving-model-view")
    List<ServingModelViewResponse> getServingModels(
        @RequestParam(value = "page", defaultValue = "1") Integer page,
        @RequestParam(value = "size", defaultValue = "20") Integer size,
        @RequestParam(value = "search", required = false) String search,
        @RequestParam(value = "model_type", required = false) String modelType
    );
}
