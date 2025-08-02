package com.skax.aiplatform.client.sktax.agent;

import com.skax.aiplatform.client.sktax.agent.dto.response.CommonResponse;
import com.skax.aiplatform.client.sktax.config.SktAxFeignConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * SKTAX Agent Health 체크 Feign Client
 * 
 * <p>Agent 서비스의 헬스 체크 및 상태 확인을 위한 클라이언트입니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-08-02
 * @version 1.0
 */
@FeignClient(
    name = "sktax-agent-health", 
    url = "${sktax.agent.url:https://aip-stg.sktai.io}",
    path = "/api/v1/agent",
    configuration = SktAxFeignConfig.class
)
public interface SktAxAgentHealthClient {

    /**
     * Agent 서비스 활성 상태 확인
     * 
     * @return 서비스 활성 상태 응답
     */
    @GetMapping("/health/live")
    CommonResponse isLive();

    /**
     * Agent 서비스 준비 상태 확인
     * 
     * @return 서비스 준비 상태 응답
     */
    @GetMapping("/health/ready")
    CommonResponse isReady();
}
