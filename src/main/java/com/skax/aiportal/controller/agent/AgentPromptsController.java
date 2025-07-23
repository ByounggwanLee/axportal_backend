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

import com.skax.aiportal.dto.agent.request.AgentPromptsCreateRequest;
import com.skax.aiportal.dto.agent.request.AgentPromptsUpdateRequest;
import com.skax.aiportal.dto.agent.response.AgentPromptsResponse;
import com.skax.aiportal.service.agent.AgentPromptsService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * Agent Prompts 관리 컨트롤러
 */
@Slf4j
@RestController
@RequestMapping("/api/v1/agent/prompts")
@RequiredArgsConstructor
@Tag(name = "Agent Prompts", description = "Agent 프롬프트 관리 API")
public class AgentPromptsController {

    private final AgentPromptsService agentPromptsService;

    @Operation(summary = "Prompts 목록 조회")
    @GetMapping
    public ResponseEntity<List<AgentPromptsResponse>> getPrompts(
            @Parameter(description = "프로젝트 ID")
            @RequestParam(required = false) String projectId,
            @RequestParam(defaultValue = "1") Integer page,
            @RequestParam(defaultValue = "10") Integer size,
            @RequestParam(required = false) String sort,
            @RequestParam(required = false) String filter,
            @RequestParam(required = false) String search) {
        
        log.info("Prompts 목록 조회 요청 - projectId: {}, page: {}, size: {}", projectId, page, size);
        
        List<AgentPromptsResponse> response = agentPromptsService.getPrompts(projectId, page, size, sort, filter, search);
        
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Prompt 상세 조회")
    @GetMapping("/{promptUuid}")
    public ResponseEntity<AgentPromptsResponse> getPromptById(
            @PathVariable String promptUuid) {
        
        log.info("Prompt 상세 조회 요청 - promptUuid: {}", promptUuid);
        
        AgentPromptsResponse response = agentPromptsService.getPromptById(promptUuid);
        
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Prompt 생성")
    @PostMapping
    public ResponseEntity<AgentPromptsResponse> createPrompt(
            @Valid @RequestBody AgentPromptsCreateRequest request) {
        
        log.info("Prompt 생성 요청 - name: {}", request.getName());
        
        AgentPromptsResponse response = agentPromptsService.createPrompt(request);
        
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @Operation(summary = "Prompt 수정")
    @PutMapping("/{promptUuid}")
    public ResponseEntity<AgentPromptsResponse> updatePrompt(
            @PathVariable String promptUuid,
            @Valid @RequestBody AgentPromptsUpdateRequest request) {
        
        log.info("Prompt 수정 요청 - promptUuid: {}", promptUuid);
        
        AgentPromptsResponse response = agentPromptsService.updatePrompt(promptUuid, request);
        
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Prompt 삭제")
    @DeleteMapping("/{promptUuid}")
    public ResponseEntity<Void> deletePrompt(@PathVariable String promptUuid) {
        
        log.info("Prompt 삭제 요청 - promptUuid: {}", promptUuid);
        
        agentPromptsService.deletePrompt(promptUuid);
        
        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "Prompt 테스트 실행")
    @PostMapping("/{promptUuid}/test")
    public ResponseEntity<Map<String, Object>> testPrompt(@PathVariable String promptUuid) {
        
        log.info("Prompt 테스트 실행 요청 - promptUuid: {}", promptUuid);
        
        Map<String, Object> result = agentPromptsService.testPrompt(promptUuid);
        
        return ResponseEntity.ok(result);
    }

    @Operation(summary = "삭제된 모든 Prompts 완전 삭제")
    @DeleteMapping("/hard-delete")
    public ResponseEntity<Void> hardDeletePrompts() {
        
        log.info("모든 삭제된 Prompts 완전 삭제 요청");
        
        agentPromptsService.hardDeletePrompts();
        
        return ResponseEntity.noContent().build();
    }
}
