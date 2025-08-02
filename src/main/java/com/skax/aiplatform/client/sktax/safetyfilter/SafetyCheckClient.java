package com.skax.aiplatform.client.sktax.safetyfilter;

import com.skax.aiplatform.client.sktax.config.SktAxFeignConfig;
import com.skax.aiplatform.client.sktax.safetyfilter.dto.request.CheckSafeOrNot;
import com.skax.aiplatform.client.sktax.safetyfilter.dto.response.SafetyCheckOutput;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * SKT AX Safety Filter API - Safety Check Feign Client
 * Safety Check(유해성 판정) 관련 API를 호출하는 Feign Client입니다.
 *
 * @author ByounggwanLee
 * @since 2025-01-01
 * @version 1.0
 */
@FeignClient(
    name = "skt-ax-safety-check-client",
    url = "${skt-ax.safety-filter.base-url:https://aip-stg.sktai.io}",
    configuration = SktAxFeignConfig.class
)
public interface SafetyCheckClient {

    /**
     * 유해성 판정
     * 지정된 발화에 대한 안전성을 검사합니다.
     */
    @PostMapping("/api/v1/safety-filters/safe")
    SafetyCheckOutput determineTheHarmfulness(
        @RequestParam("client_secret") String clientSecret,
        @RequestParam(value = "project_id", required = false) String projectId,
        @RequestBody CheckSafeOrNot request
    );
}
