package com.skax.aiplatform.client.sktax.auth;

import com.skax.aiplatform.client.sktax.auth.dto.PolicyPayloadInput;
import com.skax.aiplatform.client.sktax.auth.dto.PolicyPayloadOutput;
import com.skax.aiplatform.client.sktax.config.SktAxFeignConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * SKTAX 정책 관리 API Feign Client
 * 
 * <p>리소스에 대한 정책 생성, 조회, 수정 등의 기능을 제공합니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-08-01
 * @version 1.0
 */
@FeignClient(
    name = "sktax-auth-policy-client",
    url = "https://aip-stg.sktai.io",
    configuration = SktAxFeignConfig.class
)
public interface SktAxAuthPolicyClient {

    /**
     * 정책 생성
     * 
     * @param resourceUrl 리소스 URL
     * @param policyPayload 정책 Payload
     * @return 생성된 정책 정보
     */
    @PostMapping("/api/v1/auth/policy")
    PolicyPayloadOutput createPolicy(
            @RequestParam("resource_url") String resourceUrl,
            @RequestBody PolicyPayloadInput policyPayload
    );

    /**
     * 정책 조회
     * 
     * @param resourceUrl 리소스 URL
     * @return 정책 정보
     */
    @GetMapping("/api/v1/auth/policy")
    PolicyPayloadOutput getPolicy(@RequestParam("resource_url") String resourceUrl);

    /**
     * 정책 수정
     * 
     * @param resourceUrl 리소스 URL
     * @param policyPayload 정책 Payload
     * @return 수정된 정책 정보
     */
    @PutMapping("/api/v1/auth/policy")
    PolicyPayloadOutput updatePolicy(
            @RequestParam("resource_url") String resourceUrl,
            @RequestBody PolicyPayloadInput policyPayload
    );

    /**
     * 기본 정책 생성
     * 
     * @param clientName 클라이언트명 (기본값: default)
     * @return 생성 응답
     */
    @PostMapping("/api/v1/auth/policy/default")
    Object createDefaultPolicies(
            @RequestParam(value = "client_name", defaultValue = "default") String clientName
    );
}
