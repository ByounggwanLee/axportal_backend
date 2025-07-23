package com.skax.aiportal.service.agent.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.skax.aiportal.client.sktai.agent.SktAiAgentHealthClient;
import com.skax.aiportal.client.sktai.agent.dto.response.CommonResponse;
import com.skax.aiportal.dto.agent.response.AgentHealthResponse;
import com.skax.aiportal.service.agent.AgentHealthService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * SKT Agent Health 서비스 구현 클래스
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class SktAgentHealthServiceImpl implements AgentHealthService {

    private final SktAiAgentHealthClient agentHealthClient;

    @Override
    public AgentHealthResponse checkHealth() {
        log.info("Agent 시스템 헬스 체크");
        
        try {
            CommonResponse clientResponse = agentHealthClient.checkHealth();
            return convertToHealthResponse(clientResponse);
        } catch (Exception e) {
            log.error("헬스 체크 실패: {}", e.getMessage(), e);
            return AgentHealthResponse.builder()
                    .status("DOWN")
                    .message("Health check failed: " + e.getMessage())
                    .timestamp(System.currentTimeMillis())
                    .build();
        }
    }

    @Override
    public AgentHealthResponse checkDetailedHealth() {
        log.info("Agent 상세 헬스 체크");
        
        try {
            CommonResponse clientResponse = agentHealthClient.checkDetailedHealth();
            return convertToHealthResponse(clientResponse);
        } catch (Exception e) {
            log.error("상세 헬스 체크 실패: {}", e.getMessage(), e);
            return AgentHealthResponse.builder()
                    .status("DOWN")
                    .message("Detailed health check failed: " + e.getMessage())
                    .timestamp(System.currentTimeMillis())
                    .build();
        }
    }

    @Override
    public AgentHealthResponse checkComponentHealth(String component) {
        log.info("Agent 컴포넌트 헬스 체크 - component: {}", component);
        
        try {
            CommonResponse clientResponse = agentHealthClient.checkComponentHealth(component);
            return convertToHealthResponse(clientResponse);
        } catch (Exception e) {
            log.error("컴포넌트 헬스 체크 실패: {}", e.getMessage(), e);
            return AgentHealthResponse.builder()
                    .status("DOWN")
                    .message("Component health check failed: " + e.getMessage())
                    .timestamp(System.currentTimeMillis())
                    .build();
        }
    }

    @SuppressWarnings("unchecked")
    private AgentHealthResponse convertToHealthResponse(CommonResponse clientResponse) {
        try {
            if (clientResponse.getData() == null) {
                return AgentHealthResponse.builder()
                        .status("UP")
                        .message("Service is running")
                        .timestamp(System.currentTimeMillis())
                        .build();
            }

            Map<String, Object> dataMap = (Map<String, Object>) clientResponse.getData();
            
            return AgentHealthResponse.builder()
                    .status(getString(dataMap, "status"))
                    .message(getString(dataMap, "message"))
                    .details((Map<String, Object>) dataMap.get("details"))
                    .timestamp(getLong(dataMap, "timestamp"))
                    .version(getString(dataMap, "version"))
                    .components(getStringMap(dataMap, "components"))
                    .build();
        } catch (Exception e) {
            log.error("Health 응답 변환 실패: {}", e.getMessage(), e);
            return AgentHealthResponse.builder()
                    .status("UNKNOWN")
                    .message("Failed to parse health response")
                    .timestamp(System.currentTimeMillis())
                    .build();
        }
    }

    private String getString(Map<String, Object> map, String key) {
        Object value = map.get(key);
        return value != null ? value.toString() : null;
    }

    private Long getLong(Map<String, Object> map, String key) {
        Object value = map.get(key);
        if (value instanceof Number) {
            return ((Number) value).longValue();
        }
        return System.currentTimeMillis();
    }

    @SuppressWarnings("unchecked")
    private Map<String, String> getStringMap(Map<String, Object> map, String key) {
        Object value = map.get(key);
        if (value instanceof Map) {
            Map<String, String> result = new HashMap<>();
            ((Map<?, ?>) value).forEach((k, v) -> {
                if (k != null && v != null) {
                    result.put(k.toString(), v.toString());
                }
            });
            return result;
        }
        return new HashMap<>();
    }
}
