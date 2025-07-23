package com.skax.aiportal.client.sktai.agent;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.skax.aiportal.client.sktai.agent.dto.response.CommonResponse;
import com.skax.aiportal.client.sktai.config.SktAiClientConfig;
import com.skax.aiportal.client.sktai.interceptor.SktAiAuthInterceptor;
import com.skax.aiportal.client.sktai.interceptor.SktAiLoggingInterceptor;

/**
 * SKT AI Agent Health API Feign 클라이언트
 *
 * <p>Agent 서비스의 상태 확인 및 헬스체크 기능을 제공합니다.</p>
 *
 * @author ByounggwanLee
 * @since 2025-07-22
 * @version 1.0
 */
@FeignClient(
    name = "skt-ai-agent-health", url = "${sktai.api.base-url:https://aip-stg.sktai.io}", configuration = {
        SktAiClientConfig.class,
        SktAiAuthInterceptor.class,
        SktAiLoggingInterceptor.class
})
public interface SktAiAgentHealthClient {

    /**
     * Agent 서비스 Live 상태 확인
     *
     * @return 서비스 Live 상태 응답
     */
    @GetMapping("/health/live")
    CommonResponse isLive();

    /**
     * Agent 서비스 Ready 상태 확인
     *
     * @return 서비스 Ready 상태 응답
     */
    @GetMapping("/health/ready")
    CommonResponse isReady();
}
