package com.skax.aiportal.controller.agent;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skax.aiportal.dto.agent.response.AgentHealthResponse;
import com.skax.aiportal.service.agent.AgentHealthService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * Agent Health 관리 컨트롤러
 */
@Slf4j
@RestController
@RequestMapping("/api/v1/agent/health")
@RequiredArgsConstructor
@Tag(name = "Agent Health", description = "Agent 헬스 체크 API")
public class AgentHealthController {

    private final AgentHealthService agentHealthService;

    @Operation(summary = "Agent 시스템 헬스 체크")
    @GetMapping
    public ResponseEntity<AgentHealthResponse> checkHealth() {
        
        log.info("Agent 시스템 헬스 체크 요청");
        
        AgentHealthResponse response = agentHealthService.checkHealth();
        
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Agent 상세 헬스 체크")
    @GetMapping("/detailed")
    public ResponseEntity<AgentHealthResponse> checkDetailedHealth() {
        
        log.info("Agent 상세 헬스 체크 요청");
        
        AgentHealthResponse response = agentHealthService.checkDetailedHealth();
        
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Agent 컴포넌트 헬스 체크")
    @GetMapping("/components/{component}")
    public ResponseEntity<AgentHealthResponse> checkComponentHealth(
            @Parameter(description = "컴포넌트 이름")
            @PathVariable String component) {
        
        log.info("Agent 컴포넌트 헬스 체크 요청 - component: {}", component);
        
        AgentHealthResponse response = agentHealthService.checkComponentHealth(component);
        
        return ResponseEntity.ok(response);
    }
}
