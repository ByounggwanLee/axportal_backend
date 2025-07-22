package com.skax.aiportal.client.sktai.serving;

import com.skax.aiportal.client.sktai.serving.dto.request.ApiKeyCreateRequest;
import com.skax.aiportal.client.sktai.serving.dto.request.ApiKeyUpdateRequest;
import com.skax.aiportal.client.sktai.serving.dto.response.ApiKeyResponse;
import com.skax.aiportal.client.sktai.serving.dto.response.ApiKeyListResponse;
import com.skax.aiportal.client.sktai.config.SktAiClientConfig;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * SKT AI API 키 관리 Feign 클라이언트
 * 
 * API 키 관리 관련 API 엔드포인트를 담당합니다.
 * - API 키 생성, 조회, 수정, 삭제
 * - API 키 활성화/비활성화
 */
@FeignClient(
    name = "sktai-apikey-client",
    url = "${sktai.api.base-url:https://aip-stg.sktai.io}",
    configuration = SktAiClientConfig.class,
    path = "/api/v1"
)
public interface SktAiApiKeyClient {

    /**
     * API 키 목록 조회
     * 
     * @param page 페이지 번호 (1부터 시작)
     * @param size 페이지 크기
     * @param search 검색어
     * @param isActive 활성 상태 필터
     * @return API 키 목록 응답
     */
    @GetMapping("/apikeys")
    ApiKeyListResponse getApiKeys(
        @RequestParam(value = "page", defaultValue = "1") Integer page,
        @RequestParam(value = "size", defaultValue = "20") Integer size,
        @RequestParam(value = "search", required = false) String search,
        @RequestParam(value = "is_active", required = false) Boolean isActive
    );

    /**
     * API 키 생성
     * 
     * @param request API 키 생성 요청
     * @return 생성된 API 키 정보 (실제 키 포함)
     */
    @PostMapping("/apikeys")
    ApiKeyResponse createApiKey(@RequestBody ApiKeyCreateRequest request);

    /**
     * API 키 상세 조회
     * 
     * @param apiKeyId API 키 ID
     * @return API 키 상세 정보
     */
    @GetMapping("/apikeys/{apiKeyId}")
    ApiKeyResponse getApiKey(@PathVariable("apiKeyId") String apiKeyId);

    /**
     * API 키 수정
     * 
     * @param apiKeyId API 키 ID
     * @param request API 키 수정 요청
     * @return 수정된 API 키 정보
     */
    @PutMapping("/apikeys/{apiKeyId}")
    ApiKeyResponse updateApiKey(
        @PathVariable("apiKeyId") String apiKeyId,
        @RequestBody ApiKeyUpdateRequest request
    );

    /**
     * API 키 삭제
     * 
     * @param apiKeyId API 키 ID
     */
    @DeleteMapping("/apikeys/{apiKeyId}")
    void deleteApiKey(@PathVariable("apiKeyId") String apiKeyId);

    /**
     * API 키 활성화
     * 
     * @param apiKeyId API 키 ID
     * @return API 키 정보
     */
    @PostMapping("/apikeys/{apiKeyId}/activate")
    ApiKeyResponse activateApiKey(@PathVariable("apiKeyId") String apiKeyId);

    /**
     * API 키 비활성화
     * 
     * @param apiKeyId API 키 ID
     * @return API 키 정보
     */
    @PostMapping("/apikeys/{apiKeyId}/deactivate")
    ApiKeyResponse deactivateApiKey(@PathVariable("apiKeyId") String apiKeyId);

    /**
     * API 키 새로고침 (새로운 키 생성)
     * 
     * @param apiKeyId API 키 ID
     * @return 새로운 API 키 정보
     */
    @PostMapping("/apikeys/{apiKeyId}/refresh")
    ApiKeyResponse refreshApiKey(@PathVariable("apiKeyId") String apiKeyId);
}
