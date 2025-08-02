package com.skax.aiplatform.client.sktax.serving;

import com.skax.aiplatform.client.sktax.serving.dto.request.ServingCreate;
import com.skax.aiplatform.client.sktax.serving.dto.request.ServingScale;
import com.skax.aiplatform.client.sktax.serving.dto.request.ServingUpdate;
import com.skax.aiplatform.client.sktax.serving.dto.response.ApiKeyRead;
import com.skax.aiplatform.client.sktax.serving.dto.response.ServingModelView;
import com.skax.aiplatform.client.sktax.serving.dto.response.ServingModelsRead;
import com.skax.aiplatform.client.sktax.serving.dto.response.ServingResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

/**
 * SKT AX Serving API Client
 * 서빙 관련 API를 호출하기 위한 Feign Client입니다.
 *
 * @author ByounggwanLee
 * @since 2025-01-01
 * @version 1.0
 */
@FeignClient(
    name = "sktax-serving-client",
    url = "${skta.api.serving.url:https://aip-stg.sktai.io}",
    configuration = com.skax.aiplatform.client.sktax.config.SktAxFeignConfig.class
)
public interface ServingClient {

    /**
     * 새로운 서빙 생성
     *
     * @param request 서빙 생성 요청 데이터
     * @return 생성된 서빙 정보
     */
    @PostMapping("/api/v1/servings")
    ServingResponse createServing(@RequestBody ServingCreate request);

    /**
     * 서빙 목록 조회
     *
     * @param page   페이지 번호 (기본값: 1)
     * @param size   페이지 크기 (기본값: 10)
     * @param sort   정렬 기준
     * @param filter 필터 조건
     * @param search 검색어
     * @return 서빙 목록
     */
    @GetMapping("/api/v1/servings")
    ServingModelsRead getServings(
        @RequestParam(value = "page", defaultValue = "1") Integer page,
        @RequestParam(value = "size", defaultValue = "10") Integer size,
        @RequestParam(value = "sort", required = false) String sort,
        @RequestParam(value = "filter", required = false) String filter,
        @RequestParam(value = "search", required = false) String search
    );

    /**
     * 특정 서빙 조회
     *
     * @param servingId 서빙 ID
     * @return 서빙 상세 정보
     */
    @GetMapping("/api/v1/servings/{serving_id}")
    ServingModelView getServing(@PathVariable("serving_id") UUID servingId);

    /**
     * 서빙 정보 수정
     *
     * @param servingId 서빙 ID
     * @param request   수정할 서빙 정보
     * @return 빈 응답
     */
    @PutMapping("/api/v1/servings/{serving_id}")
    Void updateServing(
        @PathVariable("serving_id") UUID servingId,
        @RequestBody ServingUpdate request
    );

    /**
     * 서빙 삭제 (소프트 삭제)
     *
     * @param servingId 서빙 ID
     * @return 빈 응답
     */
    @DeleteMapping("/api/v1/servings/{serving_id}")
    Void deleteServing(@PathVariable("serving_id") UUID servingId);

    /**
     * 서빙 오토스케일 설정
     *
     * @param servingId 서빙 ID
     * @param request   스케일 설정 정보
     * @return 빈 응답
     */
    @PutMapping("/api/v1/servings/{serving_id}/autoscale")
    Void scaleServing(
        @PathVariable("serving_id") UUID servingId,
        @RequestBody ServingScale request
    );

    /**
     * 서빙 중지
     *
     * @param servingId 서빙 ID
     * @return 빈 응답
     */
    @PostMapping("/api/v1/servings/{serving_id}/stop")
    Void stopServing(@PathVariable("serving_id") UUID servingId);

    /**
     * 서빙 시작
     *
     * @param servingId 서빙 ID
     * @return 빈 응답
     */
    @PostMapping("/api/v1/servings/{serving_id}/start")
    Void startServing(@PathVariable("serving_id") UUID servingId);

    /**
     * 서빙에 사용 가능한 API 키 목록 조회
     *
     * @param servingId 서빙 ID
     * @param page      페이지 번호 (기본값: 1)
     * @param size      페이지 크기 (기본값: 10)
     * @param sort      정렬 기준
     * @param filter    필터 조건
     * @param search    검색어
     * @return API 키 목록
     */
    @GetMapping("/api/v1/servings/{serving_id}/apikeys")
    ApiKeyRead getAvailableApikeys(
        @PathVariable("serving_id") UUID servingId,
        @RequestParam(value = "page", defaultValue = "1") Integer page,
        @RequestParam(value = "size", defaultValue = "10") Integer size,
        @RequestParam(value = "sort", required = false) String sort,
        @RequestParam(value = "filter", required = false) String filter,
        @RequestParam(value = "search", required = false) String search
    );

    /**
     * 하드 삭제 (DB에서 완전 삭제)
     *
     * @return 빈 응답
     */
    @PostMapping("/api/v1/servings/hard-delete")
    Void hardDeleteServings();
}
