package com.skax.aiplatform.client.sktax.serving;

import com.skax.aiplatform.client.sktax.serving.dto.request.ApiKeyCreate;
import com.skax.aiplatform.client.sktax.serving.dto.request.ApiKeyUpdate;
import com.skax.aiplatform.client.sktax.serving.dto.request.ApiKeyVerify;
import com.skax.aiplatform.client.sktax.serving.dto.response.ApiKey;
import com.skax.aiplatform.client.sktax.serving.dto.response.ApiKeyRead;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.UUID;

/**
 * SKT AX API Key Management Client
 * API 키 관리 관련 API를 호출하기 위한 Feign Client입니다.
 *
 * @author ByounggwanLee
 * @since 2025-01-01
 * @version 1.0
 */
@FeignClient(
    name = "sktax-apikey-client",
    url = "${skta.api.serving.url:https://aip-stg.sktai.io}",
    configuration = com.skax.aiplatform.client.sktax.config.SktAxFeignConfig.class
)
public interface ApiKeyClient {

    /**
     * 새로운 API 키 생성
     *
     * @param request API 키 생성 요청 데이터
     * @return 생성된 API 키 정보
     */
    @PostMapping("/api/v1/apikeys")
    ApiKey createApiKey(@RequestBody ApiKeyCreate request);

    /**
     * API 키 목록 조회
     *
     * @param page   페이지 번호 (기본값: 1)
     * @param size   페이지 크기 (기본값: 10)
     * @param sort   정렬 기준
     * @param filter 필터 조건
     * @param search 검색어
     * @return API 키 목록
     */
    @GetMapping("/api/v1/apikeys")
    ApiKeyRead getApiKeys(
        @RequestParam(value = "page", defaultValue = "1") Integer page,
        @RequestParam(value = "size", defaultValue = "10") Integer size,
        @RequestParam(value = "sort", required = false) String sort,
        @RequestParam(value = "filter", required = false) String filter,
        @RequestParam(value = "search", required = false) String search
    );

    /**
     * 특정 API 키 조회
     *
     * @param apiKeyId API 키 ID
     * @return API 키 상세 정보
     */
    @GetMapping("/api/v1/apikeys/{api_key_id}")
    ApiKey getApiKey(@PathVariable("api_key_id") UUID apiKeyId);

    /**
     * API 키 정보 수정
     *
     * @param apiKeyId API 키 ID
     * @param request  수정할 API 키 정보
     * @return 수정된 API 키 정보
     */
    @PutMapping("/api/v1/apikeys/{api_key_id}")
    ApiKey updateApiKey(
        @PathVariable("api_key_id") UUID apiKeyId,
        @RequestBody ApiKeyUpdate request
    );

    /**
     * API 키 삭제
     *
     * @param apiKeyId API 키 ID
     * @return 빈 응답
     */
    @DeleteMapping("/api/v1/apikeys/{api_key_id}")
    Void deleteApiKey(@PathVariable("api_key_id") UUID apiKeyId);

    /**
     * API 키 검증
     *
     * @param request API 키 검증 요청 데이터
     * @return 검증 결과
     */
    @PostMapping("/api/v1/apikeys/verify")
    Map<String, Object> verifyApiKey(@RequestBody ApiKeyVerify request);
}
