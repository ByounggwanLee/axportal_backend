package com.skax.aiportal.client.sktai.safetyfilter;

import com.skax.aiportal.client.sktai.config.SktAiClientConfig;
import com.skax.aiportal.client.sktai.safetyfilter.dto.request.CheckSafeOrNotRequest;
import com.skax.aiportal.client.sktai.safetyfilter.dto.response.SafetyCheckResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

/**
 * SKT AI 안전성 검사 API 클라이언트
 * 
 * 발화의 안전성 검사를 담당합니다.
 */
@FeignClient(
    name = "sktai-safety-check-client",
    url = "${sktai.api.base-url}",
    configuration = SktAiClientConfig.class
)
public interface SktAiSafetyCheckClient {

    /**
     * 발화의 안전성 검사
     * 
     * @param clientSecret 클라이언트 시크릿 (필수)
     * @param projectId 프로젝트 ID (선택사항)
     * @param request 안전성 검사 요청
     * @return 안전성 검사 결과
     */
    @PostMapping("/api/v1/safety-filters/safe")
    SafetyCheckResponse checkSafety(
            @RequestParam("client_secret") String clientSecret,
            @RequestParam(value = "project_id", required = false) String projectId,
            @Valid @RequestBody CheckSafeOrNotRequest request
    );
}
