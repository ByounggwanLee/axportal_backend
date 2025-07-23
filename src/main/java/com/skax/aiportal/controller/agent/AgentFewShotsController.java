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
import org.springframework.web.multipart.MultipartFile;

import com.skax.aiportal.dto.agent.request.AgentFewShotsCommentCreateRequest;
import com.skax.aiportal.dto.agent.request.AgentFewShotsCreateRequest;
import com.skax.aiportal.dto.agent.request.AgentFewShotsUpdateRequest;
import com.skax.aiportal.dto.agent.response.AgentFewShotsListResponse;
import com.skax.aiportal.dto.agent.response.AgentFewShotsResponse;
import com.skax.aiportal.service.agent.AgentFewShotsService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * Agent FewShots 관리 컨트롤러
 */
@Slf4j
@RestController
@RequestMapping("/api/v1/agent/fewshots")
@RequiredArgsConstructor
@Tag(name = "Agent FewShots", description = "Agent Few-shot 예시 데이터 관리 API")
public class AgentFewShotsController {

    private final AgentFewShotsService agentFewShotsService;

    @Operation(summary = "FewShots 목록 조회")
    @GetMapping
    public ResponseEntity<AgentFewShotsListResponse> getFewShots(
            @Parameter(description = "프로젝트 ID")
            @RequestParam(required = false) String projectId,
            @RequestParam(defaultValue = "1") Integer page,
            @RequestParam(defaultValue = "10") Integer size,
            @RequestParam(required = false) String sort,
            @RequestParam(required = false) String filter,
            @RequestParam(required = false) String search) {
        
        log.info("FewShots 목록 조회 요청 - projectId: {}, page: {}, size: {}", projectId, page, size);
        
        AgentFewShotsListResponse response = agentFewShotsService.getFewShots(projectId, page, size, sort, filter, search);
        
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "FewShots 상세 조회")
    @GetMapping("/{fewShotUuid}")
    public ResponseEntity<AgentFewShotsResponse> getFewShotById(
            @PathVariable String fewShotUuid) {
        
        log.info("FewShots 상세 조회 요청 - fewShotUuid: {}", fewShotUuid);
        
        AgentFewShotsResponse response = agentFewShotsService.getFewShotById(fewShotUuid);
        
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "FewShots 생성")
    @PostMapping
    public ResponseEntity<AgentFewShotsResponse> createFewShots(
            @Valid @RequestBody AgentFewShotsCreateRequest request) {
        
        log.info("FewShots 생성 요청 - name: {}", request.getName());
        
        AgentFewShotsResponse response = agentFewShotsService.createFewShots(request);
        
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @Operation(summary = "FewShots 수정")
    @PutMapping("/{fewShotUuid}")
    public ResponseEntity<AgentFewShotsResponse> updateFewShots(
            @PathVariable String fewShotUuid,
            @Valid @RequestBody AgentFewShotsUpdateRequest request) {
        
        log.info("FewShots 수정 요청 - fewShotUuid: {}", fewShotUuid);
        
        AgentFewShotsResponse response = agentFewShotsService.updateFewShots(fewShotUuid, request);
        
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "FewShots 삭제")
    @DeleteMapping("/{fewShotUuid}")
    public ResponseEntity<Void> deleteFewShots(@PathVariable String fewShotUuid) {
        
        log.info("FewShots 삭제 요청 - fewShotUuid: {}", fewShotUuid);
        
        agentFewShotsService.deleteFewShots(fewShotUuid);
        
        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "FewShots 가져오기")
    @PostMapping("/import/{versionId}")
    public ResponseEntity<Map<String, Object>> importFewShots(
            @PathVariable String versionId,
            @RequestParam("file") MultipartFile file,
            @RequestParam(defaultValue = "false") Boolean overwrite) {
        
        log.info("FewShots 가져오기 요청 - versionId: {}", versionId);
        
        Map<String, Object> result = agentFewShotsService.importFewShots(versionId, file, overwrite);
        
        return ResponseEntity.ok(result);
    }

    @Operation(summary = "모든 태그 목록 조회")
    @GetMapping("/tags")
    public ResponseEntity<List<String>> getAllTags() {
        
        log.info("모든 태그 목록 조회 요청");
        
        List<String> tags = agentFewShotsService.getAllTags();
        
        return ResponseEntity.ok(tags);
    }

    @Operation(summary = "FewShots 댓글 생성")
    @PostMapping("/{versionId}/comments")
    public ResponseEntity<Map<String, Object>> createComment(
            @PathVariable String versionId,
            @Valid @RequestBody AgentFewShotsCommentCreateRequest request) {
        
        log.info("FewShots 댓글 생성 요청 - versionId: {}", versionId);
        
        Map<String, Object> result = agentFewShotsService.createComment(versionId, request);
        
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

    @Operation(summary = "FewShots 테스트 실행")
    @PostMapping("/{fewShotUuid}/test")
    public ResponseEntity<Map<String, Object>> testFewShots(@PathVariable String fewShotUuid) {
        
        log.info("FewShots 테스트 실행 요청 - fewShotUuid: {}", fewShotUuid);
        
        Map<String, Object> result = agentFewShotsService.testFewShots(fewShotUuid);
        
        return ResponseEntity.ok(result);
    }

    @Operation(summary = "삭제된 모든 FewShots 완전 삭제")
    @DeleteMapping("/hard-delete")
    public ResponseEntity<Void> hardDeleteFewShots() {
        
        log.info("모든 삭제된 FewShots 완전 삭제 요청");
        
        agentFewShotsService.hardDeleteFewShots();
        
        return ResponseEntity.noContent().build();
    }
}
