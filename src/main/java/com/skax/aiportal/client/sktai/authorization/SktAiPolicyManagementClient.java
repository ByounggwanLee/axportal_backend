package com.skax.aiportal.client.sktai.authorization;

import com.skax.aiportal.client.sktai.authorization.dto.PolicyPayload;
import com.skax.aiportal.client.sktai.authorization.dto.response.PolicyResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

/**
 * SKT AI 정책 관리 API Feign Client
 * 
 * <p>
 * SKT AI 플랫폼의 정책 관리 관련 API를 호출하는 Feign Client입니다.
 * 리소스 정책의 생성, 조회, 수정, 삭제 및 기본 정책 관리 기능을 제공합니다.
 * </p>
 * 
 * @author ByounggwanLee
 * @since 2025-07-19
 * @version 1.0
 */
@FeignClient(name = "skt-ai-policy", url = "${sktai.api.base-url:https://aip-stg.sktai.io}", configuration = com.skax.aiportal.client.sktai.config.SktAiClientConfig.class)
public interface SktAiPolicyManagementClient {

    /**
     * 정책 생성
     * 
     * <p>
     * 새로운 리소스 정책을 생성합니다.
     * </p>
     * 
     * @param resourceUrl   리소스 URL
     * @param policyPayload 정책 정보
     * @return 생성된 정책 정보
     */
    @PostMapping(value = "/api/v1/auth/policy", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<PolicyResponse> createPolicy(
            @RequestParam("resource_url") String resourceUrl,
            @Valid @RequestBody PolicyPayload policyPayload);

    /**
     * 정책 조회
     * 
     * <p>
     * 특정 리소스의 정책 정보를 조회합니다.
     * </p>
     * 
     * @param resourceUrl 리소스 URL
     * @return 정책 정보
     */
    @GetMapping("/api/v1/auth/policy")
    ResponseEntity<PolicyResponse> getPolicy(
            @RequestParam("resource_url") String resourceUrl);

    /**
     * 정책 수정
     * 
     * <p>
     * 기존 리소스 정책을 수정합니다.
     * </p>
     * 
     * @param resourceUrl   리소스 URL
     * @param policyPayload 수정할 정책 정보
     * @return 수정된 정책 정보
     */
    @PutMapping("/api/v1/auth/policy")
    ResponseEntity<PolicyResponse> updatePolicy(
            @RequestParam("resource_url") String resourceUrl,
            @Valid @RequestBody PolicyPayload policyPayload);

    /**
     * 정책 삭제
     * 
     * <p>
     * 특정 리소스의 정책을 삭제합니다.
     * </p>
     * 
     * @param resourceUrl 리소스 URL
     * @return 삭제 결과
     */
    @DeleteMapping("/api/v1/auth/policy")
    ResponseEntity<Void> deletePolicy(
            @RequestParam("resource_url") String resourceUrl);

    /**
     * 기본 정책 생성
     * 
     * <p>
     * 시스템 기본 정책들을 생성합니다.
     * </p>
     * 
     * @param clientName 클라이언트명 (기본값: default)
     * @return 생성 결과
     */
    @PostMapping(value = "/api/v1/auth/policy/default", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Object> createDefaultPolicies(
            @RequestParam(value = "client_name", defaultValue = "default") String clientName);

    /**
     * 모든 정책 조회
     * 
     * <p>
     * 등록된 모든 정책 목록을 조회합니다.
     * </p>
     * 
     * @param page 페이지 번호 (기본값: 0)
     * @param size 페이지 크기 (기본값: 20)
     * @return 정책 목록
     */
    @GetMapping("/api/v1/auth/policies")
    ResponseEntity<PolicyResponse> getAllPolicies(
            @RequestParam(value = "page", defaultValue = "0") int page,
            @RequestParam(value = "size", defaultValue = "20") int size);

    /**
     * 정책 검색
     * 
     * <p>
     * 조건에 맞는 정책을 검색합니다.
     * </p>
     * 
     * @param keyword 검색 키워드
     * @param type    정책 타입
     * @param page    페이지 번호 (기본값: 0)
     * @param size    페이지 크기 (기본값: 20)
     * @return 검색된 정책 목록
     */
    @GetMapping("/api/v1/auth/policies/search")
    ResponseEntity<PolicyResponse> searchPolicies(
            @RequestParam(value = "keyword", required = false) String keyword,
            @RequestParam(value = "type", required = false) String type,
            @RequestParam(value = "page", defaultValue = "0") int page,
            @RequestParam(value = "size", defaultValue = "20") int size);

    /**
     * 정책 유효성 검증
     * 
     * <p>
     * 정책 설정의 유효성을 검증합니다.
     * </p>
     * 
     * @param policyPayload 검증할 정책 정보
     * @return 검증 결과
     */
    @PostMapping(value = "/api/v1/auth/policy/validate", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Object> validatePolicy(
            @Valid @RequestBody PolicyPayload policyPayload);
}
