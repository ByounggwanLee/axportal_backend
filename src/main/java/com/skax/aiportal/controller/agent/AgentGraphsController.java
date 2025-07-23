package com.skax.aiportal.controller.agent;

import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.skax.aiportal.dto.agent.request.AgentGraphsCreateRequest;
import com.skax.aiportal.dto.agent.request.AgentGraphsUpdateRequest;
import com.skax.aiportal.dto.agent.response.AgentGraphsResponse;
import com.skax.aiportal.service.agent.AgentGraphsService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * Agent Graphs 관리 컨트롤러
 */
@Slf4j
@RestController
@RequestMapping("/api/v1/agent/graphs")
@RequiredArgsConstructor
@Tag(name = "Agent Graphs", description = "Agent 그래프 관리 API")
public class AgentGraphsController {

    private final AgentGraphsService agentGraphsService;

    @Operation(summary = "Graphs 목록 조회")
    @GetMapping
    public ResponseEntity<List<AgentGraphsResponse>> getGraphs(
            @Parameter(description = "프로젝트 ID")
            @RequestParam(required = false) String projectId,
            @RequestParam(defaultValue = "1") Integer page,
            @RequestParam(defaultValue = "10") Integer size,
            @RequestParam(required = false) String sort,
            @RequestParam(required = false) String filter,
            @RequestParam(required = false) String search) {
        
        log.info("Graphs 목록 조회 요청 - projectId: {}, page: {}, size: {}", projectId, page, size);
        
        List<AgentGraphsResponse> response = agentGraphsService.getGraphs(projectId, page, size, sort, filter, search);
        
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Graph 상세 조회")
    @GetMapping("/{graphUuid}")
    public ResponseEntity<AgentGraphsResponse> getGraphById(
            @PathVariable String graphUuid) {
        
        log.info("Graph 상세 조회 요청 - graphUuid: {}", graphUuid);
        
        AgentGraphsResponse response = agentGraphsService.getGraphById(graphUuid);
        
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Graph 생성")
    @PostMapping
    public ResponseEntity<AgentGraphsResponse> createGraph(
            @Valid @RequestBody AgentGraphsCreateRequest request) {
        
        log.info("Graph 생성 요청 - name: {}", request.getName());
        
        AgentGraphsResponse response = agentGraphsService.createGraph(request);
        
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @Operation(summary = "Graph 수정")
    @PutMapping("/{graphUuid}")
    public ResponseEntity<AgentGraphsResponse> updateGraph(
            @PathVariable String graphUuid,
            @Valid @RequestBody AgentGraphsUpdateRequest request) {
        
        log.info("Graph 수정 요청 - graphUuid: {}", graphUuid);
        
        AgentGraphsResponse response = agentGraphsService.updateGraph(graphUuid, request);
        
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Graph 삭제")
    @DeleteMapping("/{graphUuid}")
    public ResponseEntity<Void> deleteGraph(@PathVariable String graphUuid) {
        
        log.info("Graph 삭제 요청 - graphUuid: {}", graphUuid);
        
        agentGraphsService.deleteGraph(graphUuid);
        
        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "Graph 테스트 실행")
    @PostMapping("/{graphUuid}/test")
    public ResponseEntity<Map<String, Object>> testGraph(@PathVariable String graphUuid) {
        
        log.info("Graph 테스트 실행 요청 - graphUuid: {}", graphUuid);
        
        Map<String, Object> result = agentGraphsService.testGraph(graphUuid);
        
        return ResponseEntity.ok(result);
    }

    @Operation(summary = "삭제된 모든 Graphs 완전 삭제")
    @DeleteMapping("/hard-delete")
    public ResponseEntity<Void> hardDeleteGraphs() {
        
        log.info("모든 삭제된 Graphs 완전 삭제 요청");
        
        agentGraphsService.hardDeleteGraphs();
        
        return ResponseEntity.noContent().build();
    }
}
