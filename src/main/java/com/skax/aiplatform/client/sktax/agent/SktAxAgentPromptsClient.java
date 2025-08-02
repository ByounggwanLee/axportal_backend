package com.skax.aiplatform.client.sktax.agent;

import com.skax.aiplatform.client.sktax.agent.dto.request.PromptCreateRequest;
import com.skax.aiplatform.client.sktax.agent.dto.request.PromptUpdateRequest;
import com.skax.aiplatform.client.sktax.agent.dto.request.PromptCopyRequest;
import com.skax.aiplatform.client.sktax.agent.dto.request.PromptCommentCreateRequest;
import com.skax.aiplatform.client.sktax.agent.dto.request.TestPromptVariablesRequest;
import com.skax.aiplatform.client.sktax.agent.dto.response.CommonResponse;
import com.skax.aiplatform.client.sktax.agent.dto.response.PromptsResponse;
import com.skax.aiplatform.client.sktax.config.SktAxFeignConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * SKTAX Agent Inference Prompts 관리 Feign Client
 * 
 * <p>Agent에서 사용하는 Prompt의 생성, 조회, 수정, 삭제, 버전 관리를 담당하는 클라이언트입니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-08-02
 * @version 1.0
 */
@FeignClient(
    name = "sktax-agent-prompts", 
    url = "${sktax.agent.url:https://aip-stg.sktai.io}",
    path = "/api/v1/agent",
    configuration = SktAxFeignConfig.class
)
public interface SktAxAgentPromptsClient {

    /**
     * Prompt 목록 조회
     */
    @GetMapping("/inference-prompts")
    PromptsResponse getAllPrompts(
        @RequestParam(value = "project_id", defaultValue = "d89a7451-3d40-4bab-b4ee-6aecd55b4f32") String projectId,
        @RequestParam(value = "page", defaultValue = "1") Integer page,
        @RequestParam(value = "size", defaultValue = "10") Integer size,
        @RequestParam(value = "sort", required = false) String sort,
        @RequestParam(value = "filter", required = false) String filter,
        @RequestParam(value = "search", required = false) String search
    );

    /**
     * Prompt 생성
     */
    @PostMapping("/inference-prompts")
    CommonResponse createPrompt(@RequestBody PromptCreateRequest request);

    /**
     * Prompt 상세 조회
     */
    @GetMapping("/inference-prompts/{promptUuid}")
    CommonResponse getPrompt(@PathVariable("promptUuid") String promptUuid);

    /**
     * Prompt 수정
     */
    @PutMapping("/inference-prompts/{promptUuid}")
    CommonResponse updatePrompt(
        @PathVariable("promptUuid") String promptUuid,
        @RequestBody PromptUpdateRequest request
    );

    /**
     * Prompt 삭제
     */
    @DeleteMapping("/inference-prompts/{promptUuid}")
    void deletePrompt(@PathVariable("promptUuid") String promptUuid);

    /**
     * Prompt 최신 버전 조회
     */
    @GetMapping("/inference-prompts/versions/{promptUuid}/latest")
    CommonResponse getLatestVersion(@PathVariable("promptUuid") String promptUuid);

    /**
     * Prompt 버전 목록 조회
     */
    @GetMapping("/inference-prompts/versions/{promptUuid}")
    CommonResponse getVersionList(@PathVariable("promptUuid") String promptUuid);

    /**
     * Prompt 메시지 조회
     */
    @GetMapping("/inference-prompts/messages/{versionId}")
    CommonResponse getPromptMessages(@PathVariable("versionId") String versionId);

    /**
     * Prompt 변수 조회
     */
    @GetMapping("/inference-prompts/variables/{versionId}")
    CommonResponse getPromptVariables(@PathVariable("versionId") String versionId);

    /**
     * Prompt 태그 조회 (버전별)
     */
    @GetMapping("/inference-prompts/tags/{versionId}")
    CommonResponse getPromptTagsByVersion(@PathVariable("versionId") String versionId);

    /**
     * Prompt 태그 목록 조회
     */
    @GetMapping("/inference-prompts/list/tags")
    CommonResponse getPromptTags();

    /**
     * 태그로 Prompt 검색
     */
    @GetMapping("/inference-prompts/search/tags")
    CommonResponse getPromptsByTags(@RequestParam("filters") String filters);

    /**
     * Prompt 복사
     */
    @PostMapping("/inference-prompts/copy/{promptUuid}")
    CommonResponse copyPrompt(
        @PathVariable("promptUuid") String promptUuid,
        @RequestBody PromptCopyRequest request
    );

    /**
     * Prompt 댓글 목록 조회
     */
    @GetMapping("/inference-prompts/comments/{versionId}")
    CommonResponse getComments(
        @PathVariable("versionId") String versionId,
        @RequestParam(value = "page", required = false) Integer page,
        @RequestParam(value = "size", defaultValue = "10") Integer size
    );

    /**
     * Prompt 댓글 생성
     */
    @PostMapping("/inference-prompts/comments/{versionId}")
    CommonResponse createComment(
        @PathVariable("versionId") String versionId,
        @RequestBody PromptCommentCreateRequest request
    );

    /**
     * Prompt 댓글 수정
     */
    @PutMapping("/inference-prompts/comments/{commentUuid}")
    CommonResponse updateComment(
        @PathVariable("commentUuid") String commentUuid,
        @RequestBody PromptCommentCreateRequest request
    );

    /**
     * Prompt 댓글 삭제
     */
    @DeleteMapping("/inference-prompts/comments/{commentUuid}")
    void deleteComment(@PathVariable("commentUuid") String commentUuid);

    /**
     * Prompt 버전 삭제
     */
    @DeleteMapping("/inference-prompts/versions/{versionId}")
    void deleteVersion(@PathVariable("versionId") String versionId);

    /**
     * Prompt API 통합용 (내부 API)
     */
    @GetMapping("/inference-prompts/api/{promptUuid}")
    CommonResponse promptApi(@PathVariable("promptUuid") String promptUuid);

    /**
     * Prompt 변수 검증용 API (내부 API)
     */
    @GetMapping("/inference-prompts/api/variables/{promptUuid}")
    CommonResponse promptVariablesApi(@PathVariable("promptUuid") String promptUuid);

    /**
     * Prompt 테스트 API
     */
    @GetMapping("/inference-prompts/test/{promptUuid}")
    CommonResponse promptTest(@PathVariable("promptUuid") String promptUuid);

    /**
     * Prompt 변수 테스트 API
     */
    @PostMapping("/inference-prompts/test/variables/{promptUuid}")
    CommonResponse promptVariablesTest(
        @PathVariable("promptUuid") String promptUuid,
        @RequestBody TestPromptVariablesRequest request
    );

    /**
     * 태그로 Prompt ID 조회 테스트 API
     */
    @GetMapping("/inference-prompts/test-search-tags/from-tags")
    CommonResponse promptFromTagsTest(@RequestParam(value = "filters", defaultValue = "agent,built-in") String filters);

    /**
     * 내장 Prompt 템플릿 조회
     */
    @GetMapping("/inference-prompts/templates/builtin")
    CommonResponse getBuiltinTemplates();

    /**
     * 삭제 표시된 모든 Prompt 완전 삭제
     */
    @DeleteMapping("/inference-prompts/hard-delete")
    void hardDeletePrompts();
}
