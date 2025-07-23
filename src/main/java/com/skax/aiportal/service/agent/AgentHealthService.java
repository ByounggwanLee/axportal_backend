package com.skax.aiportal.service.agent;

import com.skax.aiportal.dto.agent.response.AgentHealthResponse;

/**
 * Agent Health 서비스 인터페이스
 */
public interface AgentHealthService {

    /**
     * Agent 시스템 헬스 체크
     */
    AgentHealthResponse checkHealth();

    /**
     * 상세 헬스 체크
     */
    AgentHealthResponse checkDetailedHealth();

    /**
     * 특정 컴포넌트 헬스 체크
     */
    AgentHealthResponse checkComponentHealth(String component);
}
